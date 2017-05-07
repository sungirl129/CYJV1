package com.cyj.service;

import com.cyj.dao.SupplierDao;
import com.cyj.model.SupplierModel;
import com.cyj.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 */
@Service
public class SupplierService {
    @Resource
    private SupplierDao supplierDao;

    public SupplierModel findModelById(int id) {
        return supplierDao.findModelById(id);
    }

    public SupplierModel getModelByUsername(String username) {
        return supplierDao.findModelByUsername(username);
    }

    public boolean supplierValid(String username, String password) {
        SupplierModel supplierModel = supplierDao.findModelByUsername(username);
        String psw = supplierModel.getPassword();
        if(psw.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertSupplier(SupplierModel supplierModel) {
        int r = supplierDao.insertSupplier(supplierModel);
        if(r == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int getSupplierTotalCount() {
        List<SupplierModel> list = supplierDao.getAllSupplier();
        return list.size();
    }
    public PageUtil getOnePageSupplierInfo(int pageNum, int pageSize) {
        int totalCount = getSupplierTotalCount();
        int offset = (pageNum - 1) * pageSize;
        List<SupplierModel> list = supplierDao.getOnePageSupplier(offset, pageSize);
        PageUtil page = new PageUtil(pageSize, totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }

    public boolean modifySupplier(SupplierModel model) {
        return (supplierDao.updateSupplier(model) == 1);
    }

    public boolean deleteSupplier(int id) {
        return (supplierDao.deleteSupplier(id) == 1);
    }

    public boolean changePassword(String password, int id) {
        return (supplierDao.updatePassword(password, id) == 1);
    }
}
