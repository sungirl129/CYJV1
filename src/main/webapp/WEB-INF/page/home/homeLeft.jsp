<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/1
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homeLeft</title>
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/app.css">
    <script src="/resources/AmazeUI-2.7.2/assets/js/amazeui.min.js"></script>
</head>
<body>
<ul class="am-list admin-sidebar-list" id="collapase-nav-1">
    <li  class="am-panel">
        <a href="/home/homeInfo" target="homeRight"><i class="am-icon-home am-margin-left-sm"></i> 主页</a>
        <a href="/home/purchaseInfo" target="homeRight"><i class="am-icon-table am-margin-left-sm"></i> 采购信息</a>
        <a href="/home/logIn" target="homeRight"><i class="am-icon-user am-margin-left-sm"></i> 登录管理</a>
    </li>
</ul>
</body>
</html>
