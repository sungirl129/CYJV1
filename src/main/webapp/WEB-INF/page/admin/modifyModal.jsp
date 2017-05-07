<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/10
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-horizontal" action="/admin/modifySupplier" target="adminRight" method="post" style="width: 500px;border: 0">
        <div class="form-group" hidden>
            <div class="col-sm-5">
                <input hidden type="text"  name="id" class="form-control" value="${supplierModel.id}">
            </div>
        </div>
        <div class="form-group">
            <label for="corpration_name1" class="col-sm-2 control-label" style="width: 30%">公司名称</label>
            <div class="col-sm-3" style="display: inline-block;width:60%">
                <input type="text"  name="corporation" class="form-control" id="corpration_name1" value="${supplierModel.corporation}">
            </div>
        </div>
        <div class="form-group">
            <label for="corpration_addr1" class="col-sm-2 control-label" style="width: 30%">公司地址</label>
            <div class="col-sm-3" style="display: inline-block;width:60%">
                <input type="text"  name="address" class="form-control" id="corpration_addr1" value="${supplierModel.address}">
            </div>
        </div>
        <div class="form-group">
            <label for="person1" class="col-sm-2 control-label" style="width: 30%">联系人</label>
            <div class="col-sm-3" style="display: inline-block;width:60%">
                <input type="text"  name="name" class="form-control" id="person1" value="${supplierModel.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="tel1" class="col-sm-2 control-label" style="width: 30%">电话</label>
            <div class="col-sm-3" style="display: inline-block;width:60%">
                <input type="tel"  name="tel" class="form-control" id="tel1" value="${supplierModel.tel}">
            </div>
        </div>
        <div class="form-group">
            <label for="email1" class="col-sm-2 control-label" style="width: 30%">Email</label>
            <div class="col-sm-3" style="display: inline-block;width:60%">
                <input type="email"  name="email" class="form-control" id="email1" value="${supplierModel.email}">
            </div>
        </div>
        <div class="form-group">
            <label for="set_name1" class="col-sm-2 control-label" style="width: 30%">用户名</label>
            <div class="col-sm-3" style="display: inline-block;width:60%">
                <input type="text"  name="username" class="form-control" id="set_name1" value="${supplierModel.username}">
            </div>
        </div>
        <div class="form-group">
            <label for="password1" class="col-sm-2 control-label" style="width: 30%">密码</label>
            <div class="col-sm-3" style="display: inline-block;width:60%">
                <input type="text"  name="password" class="form-control" id="password1" value="${supplierModel.password}">
            </div>
        </div>
    <div class="form-group">
        <label for="credit" class="col-sm-2 control-label" style="width: 30%">等级</label>
        <div class="col-sm-3" style="display: inline-block;width:60%">
            <input type="text"  name="credit" class="form-control" id="credit" value="${supplierModel.credit}">
        </div>
    </div>
        <div class="form-group">
            <div class="col-sm-2">
                <button type="submit" class="btn btn-primary">确定修改</button>
            </div>
        </div>
    </form>
</body>
</html>
