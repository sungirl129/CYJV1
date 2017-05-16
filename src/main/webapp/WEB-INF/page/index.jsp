<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/30
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/app.css">
    <script src="/resources/AmazeUI-2.7.2/assets/js/amazeui.min.js"></script>
</head>
<body>
<header class="am-topbar">
    <h1 class="am-topbar-brand">
        <a href="#">采购管理系统</a>
    </h1>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>
    <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
        <div class="am-topbar-right">
            <button class="am-btn am-btn-primary am-topbar-btn am-btn-sm" data-am-offcanvas="{target: '#doc-oc-demo3'}">注册</button>
        </div>
        <div class="am-topbar-right">
            <button class="am-btn am-btn-primary am-topbar-btn am-btn-sm" data-am-offcanvas="{target: '#doc-oc-demo2', effect: 'overlay'}">供货商登录</button>
        </div>
            <div class="am-topbar-right">
                <button class="am-btn am-btn-primary am-topbar-btn am-btn-sm" data-am-offcanvas="{target: '#doc-oc-demo1', effect: 'overlay'}">管理员登录</button>
            </div>
    </div>
</header>
<%--管理员登录--%>
<div id="doc-oc-demo1" class="am-offcanvas am-text-xs">
    <div class="am-offcanvas-bar">
        <div class="am-offcanvas-content">
            <form class="am-form" action="/home/adminValid" target="_top" method="post">
                <fieldset>
                    <legend style="text-decoration-color: #5bc0de">管理员登录</legend>
                    <div class="am-form-group">
                        <label for="zhanghao1">账号</label>
                        <input type="text" id="zhanghao1" placeholder="账号" name="NT">
                    </div>
                    <div class="am-form-group">
                        <label for="inputPassword1">密码</label>
                        <input type="password"  name="password" id="inputPassword1" placeholder="password">
                    </div>
                    <p><button type="submit" class="am-btn am-btn-default">登录</button></p>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<!-- 侧边栏内容 -->
<div id="doc-oc-demo2" class="am-offcanvas am-text-xs">
    <div class="am-offcanvas-bar">
        <div class="am-offcanvas-content">
            <form class="am-form" action="/home/supplierValid" name="slogin" target="_top" method="post">
                <fieldset>
                    <legend style="text-decoration-color: #5bc0de">供货商登录</legend>
                    <div class="am-form-group">
                        <label for="Username1">Username</label>
                        <input type="text"  name="username" id="Username1" placeholder="Username">
                    </div>
                    <div class="am-form-group">
                        <label for="sPassword">Password</label>
                        <input type="password" name="password" id="sPassword" placeholder="Password">
                    </div>
                    <p><button type="submit" class="am-btn am-btn-default">登录</button></p>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<!-- 注册 -->
<div id="doc-oc-demo3" class="am-offcanvas am-text-xs">
        <div class="am-offcanvas-bar">
        <div class="am-offcanvas-content">
            <form class="am-form" action="/home/supplierSignup" name="ssignup" method="post">
                <fieldset>
                    <legend style="text-decoration-color: #5bc0de">供货商注册</legend>
                    <div class="am-form-group">
                        <label for="corpration_name">公司名称</label>
                        <input type="text" name="corporation" id="corpration_name" placeholder="公司名称">
                    </div>
                    <div class="am-form-group">
                        <label for="corpration_addr">公司地址</label>
                        <input type="text"  name="address" id="corpration_addr" placeholder="公司地址">
                    </div>
                    <div class="am-form-group">
                        <label for="person">联系人</label>
                        <input type="text"  name="name" id="person" placeholder="联系人">
                    </div>
                    <div class="am-form-group">
                        <label for="tel">电话</label>
                        <input type="tel" name="tel" id="tel" placeholder="电话">
                    </div>
                    <div class="am-form-group">
                        <label for="email">Email</label>
                        <input type="email"  name="email" id="email" placeholder="Email">
                    </div>
                    <div class="am-form-group">
                        <label for="set_name">用户名</label>
                        <input type="text"  name="username" id="set_name" placeholder="用户名">
                    </div>
                    <div class="am-form-group">
                        <label for="password">密码</label>
                        <input type="password"  name="password" id="password" placeholder="密码">
                    </div>
                    <p><button type="submit" class="am-btn am-btn-default">注册</button></p>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>