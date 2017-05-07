<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/14
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logIn</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/home.css" type="text/css">
</head>
<body>
<div class="login_position">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".admin_login_model">管理员登录</button>
    <div class="modal fade admin_login_model" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">管理员登录</h4>
                </div>
                <form class="form-horizontal" action="/home/adminValid" target="_top" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="zhanghao1" class="col-sm-3 control-label">账号</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="zhanghao1" placeholder="账号" name="NT">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword1" class="col-sm-3 control-label">密码</label>
                            <div class="col-sm-8">
                                <input type="password"  name="password" class="form-control" id="inputPassword1" placeholder="password">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".supplier_login_modal">供货商登录</button>
    <div class="modal fade supplier_login_modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <form class="form-horizontal" action="/home/supplierValid" name="slogin" target="_top" method="post">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">供货商登录</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="Username1" class="col-sm-3 control-label">Username</label>
                            <div class="col-sm-8">
                                <input type="text"  name="username" class="form-control" id="Username1" placeholder="Username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sPassword" class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-8">
                                <input type="password" name="password" class="form-control" id="sPassword" placeholder="Password">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".supplier_signup">供货商注册</button>
    <div class="modal fade supplier_signup" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">供货商注册</h4>
                </div>
                <form class="form-horizontal" action="/home/supplierSignup" name="ssignup" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="corpration_name" class="col-sm-3 control-label">公司名称</label>
                            <div class="col-sm-8">
                                <input type="text"  name="corporation" class="form-control" id="corpration_name" placeholder="公司名称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="corpration_addr" class="col-sm-3 control-label">公司地址</label>
                            <div class="col-sm-8">
                                <input type="text"  name="address" class="form-control" id="corpration_addr" placeholder="公司地址">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="person" class="col-sm-3 control-label">联系人</label>
                            <div class="col-sm-8">
                                <input type="text"  name="name" class="form-control" id="person" placeholder="联系人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="tel" class="col-sm-3 control-label">电话</label>
                            <div class="col-sm-8">
                                <input type="tel"  name="tel" class="form-control" id="tel" placeholder="电话">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-8">
                                <input type="email"  name="email" class="form-control" id="email" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="set_name" class="col-sm-3 control-label">用户名</label>
                            <div class="col-sm-8">
                                <input type="text"  name="username" class="form-control" id="set_name" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">密码</label>
                            <div class="col-sm-8">
                                <input type="password"  name="password" class="form-control" id="password" placeholder="密码">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary">注册</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

