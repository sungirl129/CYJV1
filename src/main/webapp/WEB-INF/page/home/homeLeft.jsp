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
    <%--<link rel="stylesheet" href="/resources/amazeui/amazeui.tree.min.css"/>--%>
    <%--<script src="/resources/amazeui/amazeui.tree.min.js"></script>--%>
</head>
<body>
<button class="am-btn am-btn-primary" data-am-collapse="{target: '#collapse-nav'}">菜单 <i class="am-icon-bars"></i></button>
<nav>
    <ul id="collapse-nav" class="am-nav am-collapse">
        <li><a href="/home/homeInfo" class="list-group-item" target="homeRight">主页</a></li>
        <li><a href="/home/purchaseInfo" class="list-group-item" target="homeRight">采购信息</a></li>
        <li class="am-active"><a href="/home/logIn" class="list-group-item" target="homeRight">登录管理</a></li>
    </ul>
</nav>
</body>
</html>
