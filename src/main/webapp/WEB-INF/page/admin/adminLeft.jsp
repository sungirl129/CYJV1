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
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/admin.css" type="text/css">
</head>
<body>
<div class="list-group">
    <a href="/admin/viewStock?pageNo=1" class="list-group-item" target="adminRight">查看库存</a>
    <a href="/admin/makePurchasePlan?pageNum=1" class="list-group-item" target="adminRight">制定采购计划</a>
    <a href="/admin/viewUnpostSchedule?pageNo=1" class="list-group-item" target="adminRight">计划单管理</a>
    <a href="/admin/viewPublish?pageNumber=1&type=0" class="list-group-item" target="adminRight">发布信息管理</a>
    <a href="/admin/viewApplication?pageNum=1" class="list-group-item" target="adminRight">申请单管理</a>
    <a href="/admin/processingOrder?pageNum=1" class="list-group-item" target="adminRight">订单管理</a>
    <a href="/admin/historyOrder?pageNum=1" class="list-group-item" target="adminRight">历史订单</a>
    <a href="/admin/predict" class="list-group-item" target="adminRight">采购预测</a>
    <a href="/admin/statistics" class="list-group-item" target="adminRight">采购数量统计</a>
    <a href="/admin/viewRate" class="list-group-item" target="adminRight">采购完成率统计</a>
    <a href="/admin/manageSuppliers?pageNo=1" class="list-group-item" target="adminRight">供应商档案管理</a>
    <a href="/admin/modifyAdmin" class="list-group-item" target="adminRight">修改账户</a>
    <a href="/admin/adminExit" class="list-group-item" target="_top">退出</a>
</div>
</body>
</html>
