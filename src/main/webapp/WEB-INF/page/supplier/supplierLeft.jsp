<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/16
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>supplierLeft</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="list-group">
    <a href="/supplier/viewPublishInfo?pageNumber=1" class="list-group-item" target="supplierRight">查看采购信息</a>
    <a href="/supplier/myApplication?pageNum=1" class="list-group-item" target="supplierRight">我的供货申请</a>
    <a href="/supplier/processingOrder?pageNum=1" class="list-group-item" target="supplierRight">我的订单</a>
    <a href="/supplier/purchaseHistory?pageNum=1" class="list-group-item" target="supplierRight">历史记录</a>
    <a href="/supplier/modifySupplier" class="list-group-item" target="supplierRight">修改账户</a>
    <a href="/supplier/supplierExit" class="list-group-item" target="_top">退出</a>
</div>
</body>
</html>
