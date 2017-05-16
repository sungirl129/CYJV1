<%--
  Created by IntelliJ IDEA.
  User: zhuangqf
  Date: 5/16/17
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/resources/css/index.css" type="text/css">
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="/resources/js/index.js"></script>
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h1>采购管理系统</h1>
        </div>
        <ul class="nav nav-tabs">
            <li role="presentation" class="myPre active"><a role="button" onclick="show('#collapseAdmin',this)" >管理员登录</a></li>
            <li role="presentation" class="myPre"><a role="button" onclick="show('#collapseSupplier',this)">供应商登录</a></li>
            <li role="presentation" class="myPre"><a role="button" onclick="show('#collapseSignUp',this)">供应商注册</a></li>
        </ul>

        <div class="collapse in" id="collapseAdmin">
            <div class="well">
                <form class="form-horizontal" action="/home/adminValid" target="_top" method="post">
                    <div class="form-group">
                        <label for="zhanghao1" class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="zhanghao1" placeholder="账号" name="NT">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword1" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password" id="inputPassword1" placeholder="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default btn-primary">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="collapse" id="collapseSupplier">
            <div class="well">
                <form class="form-horizontal" action="/home/supplierValid" target="_top" method="post">
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="username" placeholder="账号" id="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password" id="password" placeholder="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default btn-primary">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="collapse" id="collapseSignUp">
            <div class="well">
                <form class="form-horizontal" action="/home/supplierSignup" target="_top" method="post">
                    <div class="form-group">
                        <label for="corporation" class="col-sm-2 control-label">公司名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="corporation" placeholder="公司名称" name="corporation">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="address" class="col-sm-2 control-label">公司地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="address" id="address" placeholder="公司地址">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">联系人</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="name" id="name" placeholder="联系人">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tel" class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-10">
                            <input type="tel" class="form-control" name="tel" id="tel" placeholder="电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="set_name" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="username" placeholder="用户名" id="set_name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="set_password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password" id="set_password" placeholder="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default btn-primary">注册</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
    <footer class="footer">
        <div class="container">
            <p class="text-muted">Power By ChuYingjun</p>
        </div>
    </footer>
</body>
</html>
