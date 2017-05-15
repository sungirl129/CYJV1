<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/14
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminLeft</title>
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/app.css">
    <script src="/resources/AmazeUI-2.7.2/assets/js/amazeui.min.js"></script>
</head>
<body>
<ul class="am-list admin-sidebar-list" id="collapase-nav-1">
    <li class="am-panel">
        <a data-am-collapse="{parent: '#collapase-nav-1', target: '#schedule-nav'}">
            <i class="am-icon-table am-margin-left-sm"></i> 计划单管理 <i class="am-icon-angle-right am-fr am-margin-right"></i>
        </a>
        <ul class="am-list am-collapse admin-sidebar-sub" id="schedule-nav">
            <li><a href="/admin/viewStock?pageNo=1" target="adminRight"><i class="am-icon-table am-margin-left-sm"></i> 查看库存 </a></li>
            <li><a href="/admin/makePurchasePlan?pageNum=1" target="adminRight"><i class="am-icon-table am-margin-left-sm"></i> 制定采购计划 </a></li>
            <li><a href="/admin/manageSchedule?pageNo=1&type=0" target="adminRight"><i class="am-icon-table am-margin-left-sm"></i> 未发布计划 </a></li>
            <li><a href="/admin/manageSchedule?pageNo=1&type=1" target="adminRight"><i class="am-icon-table am-margin-left-sm"></i> 已发布计划 </a></li>
            <li><a href="/admin/manageSchedule?pageNo=1&type=2" target="adminRight"><i class="am-icon-table am-margin-left-sm"></i> 无效计划 </a></li>
        </ul>
    </li>
    <li class="am-panel">
        <a data-am-collapse="{parent: '#collapase-nav-1', target: '#publish-nav'}">
            <i class="am-icon-table am-margin-left-sm"></i> 发布单管理 <i class="am-icon-angle-right am-fr am-margin-right"></i>
        </a>
        <ul class="am-list am-collapse admin-sidebar-sub" id="publish-nav">
            <li><a href="/admin/viewPublish?pageNumber=1&type=0" target="adminRight"><span class="am-icon-table am-margin-left-sm"></span> 发布中 </a></li>
            <li><a href="/admin/viewPublish?pageNumber=1&type=1" target="adminRight"><span class="am-icon-table am-margin-left-sm"></span> 已取消 </a></li>
        </ul>
    </li>
    <li class="am-panel">
        <a data-am-collapse="{parent: '#collapase-nav-1', target: '#application-nav'}">
            <i class="am-icon-table am-margin-left-sm"></i> 申请单管理 <i class="am-icon-angle-right am-fr am-margin-right"></i>
        </a>
        <ul class="am-list am-collapse admin-sidebar-sub" id="application-nav">
            <li><a href="/admin/viewApplication?pageNum=1&type=0" target="adminRight"><span class="am-icon-table am-margin-left-sm"></span> 未审核的申请单 </a></li>
            <li><a href="/admin/viewApplication?pageNum=1&type=1" target="adminRight"><span class="am-icon-table am-margin-left-sm"></span> 审核通过的申请单 </a></li>
            <li><a href="/admin/viewApplication?pageNum=1&type=2" target="adminRight"><span class="am-icon-table am-margin-left-sm"></span> 审核不通过 </a></li>
        </ul>
    </li>
    <li class="am-panel">
        <a data-am-collapse="{parent: '#collapase-nav-1', target: '#order-nav'}">
            <i class="am-icon-table am-margin-left-sm"></i> 订单管理 <i class="am-icon-angle-right am-fr am-margin-right"></i>
        </a>
        <ul class="am-list am-collapse admin-sidebar-sub" id="order-nav">
            <li><a href="/admin/processingOrder?pageNum=1" target="adminRight"><span class="am-icon-table am-margin-left-sm"></span> 进行中的订单 </a></li>
            <li><a href="/admin/historyOrder?pageNum=1" target="adminRight"><span class="am-icon-table am-margin-left-sm"></span> 历史订单 </a></li>
        </ul>
    </li>
    <li class="am-panel">
        <a data-am-collapse="{parent: '#collapase-nav-1', target: '#advance-nav'}">
            <i class="am-icon-table am-margin-left-sm"></i> 统计和预测 <i class="am-icon-angle-right am-fr am-margin-right"></i>
        </a>
        <ul class="am-list am-collapse admin-sidebar-sub" id="advance-nav">
            <li><a href="/admin/predict" target="adminRight"><span class="am-icon-table am-margin-left-sm"></span> 采购预测 </a></li>
            <li><a href="/admin/statistics" target="adminRight"><span class="am-icon-table am-margin-left-sm"></span> 采购统计 </a></li>
        </ul>
    </li>
    <li class="am-panel">
        <a data-am-collapse="{parent: '#collapase-nav-1', target: '#user-nav'}">
            <i class="am-icon-users am-margin-left-sm"></i> 人员管理 <i class="am-icon-angle-right am-fr am-margin-right"></i>
        </a>
        <ul class="am-list am-collapse admin-sidebar-sub" id="user-nav">
            <li><a href="/admin/manageSuppliers?pageNo=1" target="adminRight"><i class="am-icon-user am-margin-left-sm"></i> 供应商档案管理 </a></li>
            <li><a href="/admin/modifyAdmin" target="adminRight"><i class="am-icon-user am-margin-left-sm"></i> 修改账户 </a></li>
        </ul>
    </li>
    <li  class="am-panel">
        <a href="/admin/adminExit" target="_top"><i class="am-icon-backward am-margin-left-sm"></i> 退出</a>
    </li>
</ul>
</body>
</html>
