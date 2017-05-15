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
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/app.css">
    <script src="/resources/AmazeUI-2.7.2/assets/js/amazeui.min.js"></script>
</head>
<body>

<%--<div class="list-group">--%>
    <%--<a href="/supplier/viewPublishInfo?pageNumber=1" class="list-group-item" target="supplierRight">查看采购信息</a>--%>
    <%--<a href="/supplier/myApplication?pageNum=1" class="list-group-item" target="supplierRight">我的供货申请</a>--%>
    <%--<a href="/supplier/processingOrder?pageNum=1" class="list-group-item" target="supplierRight">我的订单</a>--%>
    <%--<a href="/supplier/purchaseHistory?pageNum=1" class="list-group-item" target="supplierRight">历史记录</a>--%>
    <%--<a href="/supplier/modifySupplier" class="list-group-item" target="supplierRight">修改账户</a>--%>
    <%--<a href="/supplier/supplierExit" class="list-group-item" target="_top">退出</a>--%>
<%--</div>--%>


<ul class="am-list admin-sidebar-list" id="collapase-nav-1">
    <li  class="am-panel">
        <a href="/supplier/viewPublishInfo?pageNumber=1" target="supplierRight"><i class="am-icon-table am-margin-left-sm"></i> 查看采购信息</a>
    </li>
    <li class="am-panel">
        <a data-am-collapse="{parent: '#collapase-nav-1', target: '#application-nav'}">
            <i class="am-icon-table am-margin-left-sm"></i> 我的供货申请 <i class="am-icon-angle-right am-fr am-margin-right"></i>
        </a>
        <ul class="am-list am-collapse admin-sidebar-sub" id="application-nav">
            <li><a href="/supplier/myApplication?pageNum=1&type=3" target="supplierRight"><span class="am-icon-table am-margin-left-sm"></span> 所有申请单 </a></li>
            <li><a href="/supplier/myApplication?pageNum=1&type=0" target="supplierRight"><span class="am-icon-table am-margin-left-sm"></span> 未审核 </a></li>
            <li><a href="/supplier/myApplication?pageNum=1&type=1" target="supplierRight"><span class="am-icon-table am-margin-left-sm"></span> 审核通过 </a></li>
            <li><a href="/supplier/myApplication?pageNum=1&type=2" target="supplierRight"><span class="am-icon-table am-margin-left-sm"></span> 审核不通过 </a></li>
        </ul>
    </li>
    <li class="am-panel">
        <a data-am-collapse="{parent: '#collapase-nav-1', target: '#order-nav'}">
            <i class="am-icon-table am-margin-left-sm"></i> 订单管理 <i class="am-icon-angle-right am-fr am-margin-right"></i>
        </a>
        <ul class="am-list am-collapse admin-sidebar-sub" id="order-nav">
            <li><a href="/supplier/processingOrder?pageNum=1" target="supplierRight"><span class="am-icon-table am-margin-left-sm"></span> 进行中的订单 </a></li>
            <li><a href="/supplier/purchaseHistory?pageNum=1" target="supplierRight"><span class="am-icon-table am-margin-left-sm"></span> 历史订单 </a></li>
        </ul>
    </li>
    <li  class="am-panel">
        <a href="/supplier/modifySupplier" target="supplierRight"><i class="am-icon-user am-margin-left-sm"></i> 修改账户</a>
    </li>
    <li  class="am-panel">
        <a href="/supplier/supplierExit" target="_top"><i class="am-icon-backward am-margin-left-sm"></i> 退出</a>
    </li>
</ul>
</body>
</html>
