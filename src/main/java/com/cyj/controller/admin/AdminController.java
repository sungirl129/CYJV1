package com.cyj.controller.admin;

import com.cyj.excel.SheetHandler;
import com.cyj.excel.SimpleImportStatus;
import com.cyj.model.*;
import com.cyj.model.show.Stock;
import com.cyj.service.*;
import com.cyj.tools.PageUtil;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/4/3.
 */
@Controller
@RequestMapping("/admin")

public class AdminController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    @Resource
    private StockService stockService;
    @Resource
    private MakePlanService makePlanService;
    @Resource
    private ScheduleService scheduleService;
    @Resource
    private PublishService publishService;
    @Resource
    private ApplicationService applicationService;
    @Resource
    private OrderService orderService;
    @Resource
    private SupplierService supplierService;
    @Resource
    private ArriveService arriveService;
    @Resource
    private PayService payService;
    @Resource
    private RejectedService rejectedService;
    @Resource
    private AdminService adminService;
    @Resource
    private StatisticsService statisticsService;

    @RequestMapping("/adminMain")
    public String adminMain(Model model) {
        return "admin/adminMain";
    }

    @RequestMapping("/adminTop")
    public String adminTop(Model model) {
        return "admin/adminTop";
    }

    @RequestMapping("/adminLeft")
    public String adminLeft(Model model) {
        return "admin/adminLeft";
    }

    @RequestMapping("/adminRight")
    public String adminRight(Model model, HttpServletResponse response) throws IOException {
        return "redirect:/admin/viewStock";
    }

    @RequestMapping("/viewStock")
    public String viewStock(Model model, @RequestParam(value = "pageNo",defaultValue = "1",required = false) int pageNo) {
        int pageSize = 8;
        List<Stock> list = stockService.search(null,null,0,0);
        PageUtil nowPage = new PageUtil(list,pageSize,pageNo,4);
        model.addAttribute("nowPage", nowPage);
        return "admin/stock/viewStock";
    }

    @RequestMapping("/search")
    public String search(Model model, @RequestParam(value = "pageNo",defaultValue = "1",required = false) int pageNo,
                         String type, String condition, String stock,
                         @RequestParam(required = false,defaultValue = "0")int stockL,
                         @RequestParam(required = false,defaultValue = "0")int stockR) {
        logger.info("search");
        boolean isStock = "stock".equals(stock);//为true时有库存条件
        if(!isStock){
            stockL = 0;
            stockR = 0;
        }
        String unit = null,gname = null;
        if("gname".equals(type)) gname = condition;
        else unit = condition;

        List<Stock> list = stockService.search(gname,unit,stockL,stockR);
        PageUtil nowPage = new PageUtil(list,8,pageNo,4);
        model.addAttribute("nowPage", nowPage);
        return "admin/stock/viewStock";
    }

    @RequestMapping("/exportStock")
    public @ResponseBody String exportStock(Model model, String type, String condition, String stock,
                       @RequestParam(required = false,defaultValue = "0")int stockL,
                       @RequestParam(required = false,defaultValue = "0")int stockR) throws Exception {

        boolean isStock = "stock".equals(stock);//为true时有库存条件
        if(!isStock){
            stockL = 0;
            stockR = 0;
        }
        String unit = null,gname = null;
        if("gname".equals(type)) gname = condition;
        else unit = condition;
        List<Stock> list = stockService.search(gname,unit,stockL,stockR);
        File file = new File(UUID.randomUUID()+".xlsx");
        if(!file.exists()) file.createNewFile();
        SheetHandler.exportSheet(file,Arrays.asList(Stock.HEADER),list);
        String fileName = "stock.xlsx";
        return "/admin/download?fileName="+fileName+"&path="+file.getName();
    }

    @RequestMapping("/makePurchasePlan")
    public String makePurchasePlan(Model model, @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum, HttpServletRequest request) {
        int pageSize = 8;
        PageUtil nowPage = makePlanService.getGoodsStockInfo(pageNum,pageSize);
        nowPage.setRowNum(4);
        model.addAttribute("nowPage", nowPage);
        return "admin/makePlan/makePurchasePlan";
    }

    @RequestMapping("/planExcel")
    public @ResponseBody String planExcel() throws Exception {
        File file = new File(UUID.randomUUID()+".xlsx");
        if(!file.exists()) file.createNewFile();
        SheetHandler.exportSheet(file,Arrays.asList(ScheduleModel.HEADER),null);
        String fileName = "plan.xlsx";
        return "/admin/download?fileName="+fileName+"&path="+file.getName();
    }

    @RequestMapping("/planImport")
    public @ResponseBody String planImport(@RequestParam(value = "file",required = false) MultipartFile file) throws Exception {

        if(file==null||file.isEmpty()) return "no file";
        File tempFile = new File(UUID.randomUUID() + "_" + file.getOriginalFilename());
        file.transferTo(tempFile);
        SimpleImportStatus<ScheduleModel> list = SheetHandler.importSheet(tempFile,ScheduleModel.class,true);
        tempFile.deleteOnExit();
        Gson gson = new Gson();
        logger.info("logger====================================");
        logger.info(gson.toJson(list));
        List<ScheduleModel> scheduleModelList = list.getBatchAddList();
        for(ScheduleModel scheduleModel:scheduleModelList) {
            int gid = stockService.findGoodsIdByGname(scheduleModel.getGname());
            int buyNumber = scheduleModel.getBuyNumber();
            scheduleService.addPlan(gid,buyNumber);
        }
        return gson.toJson(list);
    }

    @RequestMapping("/addPlan")
    public void addPlan(Model model,int pageNum, HttpServletRequest request, HttpServletResponse response) throws IOException {

        boolean isHave = request.getParameterMap().containsKey("selectGoods");
        if(isHave) {
            String[] strGoodsId = request.getParameterValues("selectGoods");
            boolean flag = true;
            for(int i = 0; i < strGoodsId.length; i++) {
                int goodsId = Integer.parseInt(strGoodsId[i]);
                String strNumber = request.getParameter(strGoodsId[i]);
                int buyNumber = Integer.parseInt(strNumber);
                flag = scheduleService.addPlan(goodsId,buyNumber);
            }
//            if(flag)
//                response.getWriter().write("<script language=\"javascript\">alert(\"操作成功!\");</script>");
//            else
//                response.getWriter().write("<script>alert('操作失败!');</script>");
        }
        response.sendRedirect("/admin/makePurchasePlan?pageNum="+ pageNum);
    }

    @RequestMapping("/goodsDetail")
    public String goodsDetail(Model model, int gid) {
        StockModel stockModel = stockService.findStockModelByGoodsId(gid);
        GoodsModel goodsModel = stockService.findGoodsModelByGoodsId(gid);
        model.addAttribute("stockModel",stockModel);
        model.addAttribute("goodsModel",goodsModel);
        return "admin/makePlan/goodsDetail";
    }

    @RequestMapping("/manageSchedule")
    public String manageSchedule(Model model, @RequestParam(value = "type",defaultValue = "0",required = false)int type, @RequestParam(value = "pageNo",defaultValue = "1",required = false) int pageNo) {
        int pageSize = 8;
        PageUtil nowPage;
        String title;
        if(type == 0) {
            nowPage = scheduleService.getOnePageValidUnpublish(0, 0, pageNo,pageSize);
            nowPage.setRowNum(4);
            model.addAttribute("nowPage", nowPage);
            return "admin/schedule/viewUnpostSchedule";
        } else if(type == 1) {
            nowPage = scheduleService.getOnePageValidUnpublish(1, 1, pageNo,pageSize);
            nowPage.setRowNum(4);
            title = "已发布的计划";
            model.addAttribute("nowPage", nowPage);
            model.addAttribute("title", title);
            return "admin/schedule/viewPostedSchedule";
        } else {
            nowPage = scheduleService.getOnePageValidUnpublish(0, 1, pageNo,pageSize);
            nowPage.setRowNum(4);
            model.addAttribute("nowPage", nowPage);
            title = "无效计划";
            model.addAttribute("title", title);
            return "admin/schedule/viewInvalidSchedule";
        }
    }

    @Transactional
    @RequestMapping("/processPublish")
    public String processPublish(Model model, HttpServletRequest request) throws Exception {
        String operation = request.getParameter("operation");
        if(operation.equals("ok") || operation.equals("cancel")) {
            //发布或者取消发布
            if(request.getParameterMap().containsKey("selectPlans")) {
                String[] strSchedulesId = request.getParameterValues("selectPlans");
                if(operation.equals("ok")) {
                    //发布
                    for(int i = 0; i < strSchedulesId.length; i++) {
                        int scheduleId = Integer.parseInt(strSchedulesId[i]);
                        ScheduleModel scheduleModel = scheduleService.findModelById(scheduleId);
                        int goodsId = scheduleModel.getGoodsId();
                        String strBuyNumber = request.getParameter("bn" + strSchedulesId[i]);
                        int buyNumber = Integer.parseInt(strBuyNumber);
                        if(!scheduleService.publishChangeScheduleState(scheduleId)) throw new Exception("error");
                        if(! scheduleService.addPublishDate(scheduleId)) throw new Exception("error1");
                        PublishModel publishModel = new PublishModel();
                        publishModel.setScheduleId(scheduleId);
                        publishModel.setGoodsId(goodsId);
                        publishModel.setPublishNumber(buyNumber);
                        publishModel.setApplyNumber(0);
                        publishModel.setPublishState(0);
                        if(!publishService.publishSchedule(publishModel)) throw new Exception("error");
                        if(!statisticsService.insertPurchaseNumber(goodsId, buyNumber)) throw new Exception("error");
                    }
                } else {
                    //取消计划
                    for(int i = 0; i < strSchedulesId.length; i++) {
                        int scheduleId = Integer.parseInt(strSchedulesId[i]);
                        scheduleService.cancelPublish(scheduleId);
                    }
                }
            }
        } else {
            //修改计划个数
            String strPlanId = request.getParameter("operation");
            int scheduleId = Integer.parseInt(strPlanId);
            String strBuyNumber = request.getParameter("bn" + strPlanId);
            int buyNum = Integer.parseInt(strBuyNumber);
            scheduleService.changeBuyNumber(buyNum,scheduleId);
        }
        return "redirect:/admin/manageSchedule";
    }


    @RequestMapping("/viewPublish")
    public String viewPublish(Model model, @RequestParam(value = "pageNumber",defaultValue = "1",required = false) int pageNumber, @RequestParam(value = "type",defaultValue = "0",required = false)int type) {
        String btnName = "取消发布";
        String title = "发布的采购信息";
        int state = 0;
        if(type == 1) {
            btnName = "发布";
            title = "取消发布的消息";
            state = 2;
        }
        int pageSize = 8;
        PageUtil curPage = publishService.getOnePagePublishInfo(pageNumber,pageSize,state);
        curPage.setRowNum(4);
        model.addAttribute("curPage",curPage);
        model.addAttribute("btnName",btnName);
        model.addAttribute("type",type);
        model.addAttribute("title", title);
        return "admin/publish/viewPublish";
    }

    @Transactional
    @RequestMapping("/cancelPublish")
    public String cancelPublish(Model model, int operation, int pageNumber, int type) throws Exception {
        int publishId = operation;
        if(type == 0) {
            publishService.cacelPublish(publishId);
        } else if(type == 1) {
            PublishModel publishModel = publishService.findModelById(publishId);
            publishModel.setPublishNumber(publishModel.getPublishNumber() - publishModel.getApplyNumber());
            publishModel.setApplyNumber(0);
            publishModel.setPublishState(0);
            if(!publishService.publishSchedule(publishModel)) throw new Exception("error");
            if(!publishService.deleteItem(publishId)) throw new Exception("error");
        }
        String url = "redirect:/admin/viewPublish?pageNumber=" + pageNumber;
        return url;
    }

    @RequestMapping("/viewApplication")
    public String viewApplication(Model model, @RequestParam(value = "pageNum",defaultValue = "1",required = false)int pageNum, @RequestParam(value = "type",defaultValue = "0",required = false)int type) {
        int pageSize = 4;
        PageUtil nowPage = null;
        String title = "";
        String url = "";
        switch (type) {
            case 0:
                nowPage = applicationService.viewApplicationInfo(0, 0, pageNum,pageSize);
                title = "暂未审核的申请单";
                url = "admin/application/viewApplication";
                break;
            case 1:
                nowPage = applicationService.viewApplicationInfo(1, 0, pageNum,pageSize);
                title = "审核通过";
                url = "admin/application/viewApplication1";
                break;
            case 2:
                nowPage = applicationService.viewApplicationInfo(2, 0, pageNum,pageSize);
                title = "审核不通过";
                url = "admin/application/viewApplication1";
                break;
            default:
                break;
        }
        nowPage.setRowNum(4);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("title", title);
        model.addAttribute("type",type);
        return url;
    }

    @RequestMapping("/processApplication")
    @Transactional
    public String processApplication(Model model, HttpServletRequest request, String access, String pageNum) throws Exception {
        if(request.getParameterMap().containsKey("selectApplication")) {
            String[] strApplicationsId = request.getParameterValues("selectApplication");
            for(String strApplicationId:strApplicationsId) {
                int applicationId = Integer.parseInt(strApplicationId);
                if(access.equals("yes")) {
                    //审批通过
                    ApplicationModel applicationModel = applicationService.findModelById(applicationId);
                    int supplyNumber = applicationModel.getSupplyNumber();
                    int publishId = applicationModel.getPublishId();
                    int goodsId = applicationModel.getGoodsId();
                    int supplierId = applicationModel.getSupplierId();
                   if(!applicationService.applicationAccess(applicationId)) throw new Exception("error1");
                    OrderModel orderModel = new OrderModel();
                    orderModel.setApplicationId(applicationId);
                    orderModel.setGoodsId(goodsId);
                    orderModel.setSupplierId(supplierId);
                    orderModel.setAcceptNumber(0);
                    orderModel.setPayedMoney(0);
                    orderModel.setOrderState(0);
                    if(!orderService.insertOrder(orderModel)) throw new Exception("error2");
                    if(!publishService.addApplyNumber(supplyNumber, publishId)) throw new Exception("error3");
                } else if(access.equals("no")) {
                    applicationService.applicationDeny(applicationId);
                }
            }
        }
        return ("redirect:/admin/viewApplication?pageNum=" + pageNum);
    }

    @RequestMapping("/processingOrder")
    public String processingOrder(Model model, @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum) {
        int pageSize = 4;
        PageUtil nowPage = orderService.viewOnePageOrderByState(pageNum,pageSize,0);
        nowPage.setRowNum(4);
        model.addAttribute("nowPage",nowPage);
        return "admin/order/processingOrder";
    }

    @RequestMapping("/orderDetail")
    public String orderDetail(Model model, int orderId, int type) {
        OrderModel orderModel = orderService.findModelById(orderId);
        model.addAttribute("orderModel",orderModel);
        int applicationId = orderModel.getApplicationId();
        ApplicationModel applicationModel = applicationService.findModelById(applicationId);
        model.addAttribute("applicationModel",applicationModel);
        int supplierId = applicationModel.getSupplierId();
        int publishId = applicationModel.getPublishId();
        SupplierModel supplierModel = supplierService.findModelById(supplierId);
        model.addAttribute("supplierModel",supplierModel);
        PublishModel publishModel = publishService.findModelById(publishId);
        int goodsId = publishModel.getGoodsId();
        GoodsModel goodsModel = stockService.findGoodsModelByGoodsId(goodsId);
        model.addAttribute("goodsModel", goodsModel);
        PageUtil arrivePage = arriveService.viewArriveInfoByOrderId(orderId);
        model.addAttribute("arrivePage", arrivePage);
        PageUtil payPage = payService.viewPayInfoByOrderId(orderId);
        model.addAttribute("payPage", payPage);
        if(type == 1) {
            return "admin/order/orderDetail";
        } else {
            return "admin/order/historyOrderDetail";
        }
    }

    @Transactional
    @RequestMapping("/goodsArrive")
    public String goodsArrive(Model model, int orderId, int arriveNumber, int goodsState, int badNumber, int returnedQuantity) throws Exception {
        ArriveModel arriveModel = new ArriveModel();
        arriveModel.setOrderId(orderId);
        arriveModel.setArriveNumber(arriveNumber);
        arriveModel.setGoodsState(goodsState);
        arriveModel.setBadNumber(badNumber);
        if(!arriveService.insertArriveItem(arriveModel)) throw new Exception("error");
        if(!orderService.goodsArriveChangeAcceptNumber(orderId, arriveNumber-badNumber)) throw new Exception("error");
        if(goodsState == 2) {
            RejectedModel rejectedModel = new RejectedModel();
            rejectedModel.setArriveId(orderId);
            rejectedModel.setReturnedQuantity(returnedQuantity);
            if(!rejectedService.insertItem(rejectedModel)) throw new Exception("error");

            int applicationId = orderService.getApplicationIdByOrderId(orderId);
            int publishId = applicationService.getPublishIdById(applicationId);
            if(!publishService.returnGoodsChangePulish(publishId,returnedQuantity)) throw new Exception("error");
        }
        String url = "redirect:/admin/orderDetail?orderId=" + orderId;
        return url;
    }

    @Transactional
    @RequestMapping("/goodsPay")
    public String goodsPay(Model model, int orderId, double payMoney, int payWay, String handler) throws Exception {
        PayModel payModel = new PayModel();
        payModel.setOrderId(orderId);
        payModel.setPayMoney(payMoney);
        payModel.setPayWay(payWay);
        payModel.setHandler(handler);
        if(!payService.insetPayItem(payModel)) throw new Exception("error");
        if(!orderService.changePayedMoney(orderId,payMoney)) throw new Exception("error");
        if(orderService.SupplyNumberEqualsArriveNumber(orderId)) {
            if(orderService.checkPayedMoney(orderId)) {
                orderService.changeOrderState(orderId,1);
                OrderModel orderModel = orderService.findModelById(orderId);
                int acceptNumber = orderModel.getAcceptNumber();
                int goodsId = orderModel.getGoodsId();
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                statisticsService.updateInNumber(acceptNumber, goodsId, year, month);
            }
        }
        String url = "redirect:/admin/orderDetail?orderId=" + orderId;
        return url;
    }

    @RequestMapping("/historyOrder")
    public String historyOrder(Model model, @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum) {
        int pageSize = 4;
        PageUtil nowPage = orderService.viewOnePageOrderByState(pageNum, pageSize,1);
        nowPage.setRowNum(4);
        model.addAttribute("nowPage",nowPage);
        return "admin/historyOrder";
    }

    @RequestMapping("/manageSuppliers")
    public String manageSuppliers(Model model, @RequestParam(value = "pageNo",defaultValue = "1",required = false)int pageNo) {
        int pageSize = 15;
        PageUtil nowPage = supplierService.getOnePageSupplierInfo(pageNo,pageSize);
        model.addAttribute("nowPage",nowPage);
        return "admin/manageSuppliers";
    }

    @RequestMapping("/deleteSuppliers")
    public String deleteSuppliers(Model model, HttpServletRequest request) {
        if(request.getParameterMap().containsKey("supplierId")) {
            String[] strIds = request.getParameterValues("supplierId");
            for(String strid : strIds) {
                int id = Integer.parseInt(strid);
                supplierService.deleteSupplier(id);
            }
        }
        return "redirect:/admin/manageSuppliers";
    }

    @RequestMapping("/modifyModal")
    public String modifyModal(Model model, int id) {
        SupplierModel supplierModel = supplierService.findModelById(id);
        model.addAttribute("supplierModel", supplierModel);
        return "admin/modifyModal";
    }


    @RequestMapping("/modifySupplier")
    public String modifySupplier(Model model, int id, HttpServletRequest request) {
        SupplierModel supplierModel = new SupplierModel();
        supplierModel.setId(id);
        supplierModel.setUsername(request.getParameter("username"));
        supplierModel.setPassword(request.getParameter("password"));
        supplierModel.setCorporation(request.getParameter("corporation"));
        supplierModel.setAddress(request.getParameter("address"));
        supplierModel.setName(request.getParameter("name"));
        supplierModel.setTel(request.getParameter("tel"));
        supplierModel.setEmail(request.getParameter("email"));
        supplierModel.setCredit(Integer.parseInt(request.getParameter("credit")));
        supplierService.modifySupplier(supplierModel);
        return "redirect:/admin/manageSuppliers";
    }

    @RequestMapping("/addSupplier")
    public String addSupplier(Model model, HttpServletRequest request) {
        SupplierModel supplierModel = new SupplierModel();
        supplierModel.setUsername(request.getParameter("username"));
        supplierModel.setPassword(request.getParameter("password"));
        supplierModel.setCorporation(request.getParameter("corporation"));
        supplierModel.setAddress(request.getParameter("address"));
        supplierModel.setName(request.getParameter("name"));
        supplierModel.setTel(request.getParameter("tel"));
        supplierModel.setEmail(request.getParameter("email"));
        supplierModel.setCredit(0);
        supplierService.insertSupplier(supplierModel);
        return "redirect:/admin/manageSuppliers";
    }

    @RequestMapping("/modifyAdmin")
    public String modifyAdmin(Model model) {
        return "admin/modifyAdmin";
    }

    @RequestMapping("/modifyAdminVerify")
    public String modifyAdminVerify(Model model, String oldPassword, String newPassword, String newPassword1, HttpServletRequest request) {
        String error = "";
        AdminModel adminModel = (AdminModel) request.getSession().getAttribute("admin");
        if(! newPassword1.equals(newPassword)) {
            error = "两次密码不一致!请重新输入。";
        } else if(!adminModel.getPassword().equals(oldPassword)){
            error = "密码错误";
        } else {
            if(!adminService.changePassword(newPassword, adminModel)) {
                error = "修改密码失败";
            } else {
                error = "修改成功";
            }
        }
        model.addAttribute("result", error);
        return "admin/modifyAdminVerify";
    }

    @RequestMapping("/adminExit")
    public String adminExit(Model model, HttpServletRequest request) {
        request.getSession().removeAttribute("admin");
        return "index";
    }

    @RequestMapping("/viewStatistics")
    public String viewStatistics(Model model) {
        return "admin/statistics/viewStatistics";
    }

    @RequestMapping("/statistics")
    public String statistics(Model model) {
        return "admin/statistics/statistics";
    }

    @RequestMapping("/chooseType")
    public String chooseType(Model model, String gname, int year, String style) {
        model.addAttribute("gname", gname);
        int goodsId = stockService.findGoodsIdByGname(gname);
        int[] month = statisticsService.statisticsGoodsByYear(goodsId, year);
        int[] purchaseNumber = new int[12];
        int[] applyNumber = new int[12];
        for(int i = 0; i < 12; i++) {
            purchaseNumber[i] = month[i * 2];
            applyNumber[i] = month[i * 2 + 1];
        }
        model.addAttribute("purchaseNumber", purchaseNumber);
        model.addAttribute("applyNumber", applyNumber);
        model.addAttribute("purchaseNumber", purchaseNumber);
        model.addAttribute("applyNumber", applyNumber);
        int[] season = new int[4];
        int[] season1 = new int[4];
        for(int i = 0; i < 4; i++) {
            season[i] = purchaseNumber[i * 3] + purchaseNumber[i * 3 + 1] + purchaseNumber[i * 3 + 2];
            season1[i] = applyNumber[i * 3] + applyNumber[i * 3 + 1] + applyNumber[i * 3 + 2];
        }
        model.addAttribute("season", season);
        model.addAttribute("season1", season1);

        if(style.equals("bar")) {
            return "admin/statistics/bar";
        } else if(style.equals("line")) {
            return "admin/statistics/line";
        } else if(style.equals("pie")) {
            return "admin/statistics/pie";
        } else if(style.equals("huan")) {
            return "admin/statistics/doughnut";
        } else {
            return "admin/statistics/viewStatistics";
        }
    }





//    @RequestMapping("/statistics")
//    public String statistics(Model model) {
//        return "admin/statistics";
//    }
//
//    @RequestMapping("/pie")
//    public String pie(Model model) {
//        return "admin/doughnut";
//    }
//
//    @RequestMapping(value = "/pieData",produces = "text/html;charset=UTF-8")
//    public @ResponseBody
//    String pieData(
//            @RequestParam(required = false,defaultValue = "") String condition,
//            @RequestParam(required = false,defaultValue = "0") int year){
//        logger.info("condition:"+condition);
//        logger.info("year:"+year);
//        // 可以在此处做查询
//
//        //此处假设有A、B、C、D、E五种货物，各占25
//        Gson gson = new Gson();
//        Map<String,Integer> data = new HashMap<String, Integer>();
//        Map<String,Object> result = new HashMap<String, Object>();
//        result.put("data",data);
//        result.put("title","饼图");
//        data.put("A",25);
//        data.put("B",25);
//        data.put("C",25);
//        data.put("D",25);
//        data.put("E",25);
//        String resultString = gson.toJson(result);
//        logger.info("result:"+ resultString);
//        return resultString;
//    }


    @RequestMapping("/predict")
    public String predict(Model model) {

        return "admin/predict/predict";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,String fileName,String path) throws IOException {
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        fileName=new String(fileName.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        byte[] data = FileUtils.readFileToByteArray(file);
        file.deleteOnExit();
        return new ResponseEntity<byte[]>(data,headers, HttpStatus.CREATED);
    }
}

