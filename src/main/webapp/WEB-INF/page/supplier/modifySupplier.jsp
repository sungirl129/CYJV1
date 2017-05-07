<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/17
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>modifySupplier</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<br>
<br>
<form class="form-horizontal" action="/supplier/modifySupplierVerify" method="post">
    <div class="form-group">
        <label for="oldPassword1" class="col-sm-2 control-label">旧密码</label>
        <div class="col-sm-3">
            <input type="password" name="oldPassword" class="form-control" id="oldPassword1" placeholder="旧密码">
        </div>
    </div>
    <div class="form-group">
        <label for="newPassword1" class="col-sm-2 control-label">新密码</label>
        <div class="col-sm-3">
            <input type="password" name="newPassword" class="form-control" id="newPassword1" placeholder="新密码">
        </div>
    </div>
    <div class="form-group">
        <label for="repeat1" class="col-sm-2 control-label">确认密码</label>
        <div class="col-sm-3">
            <input type="password" name="newPassword1" class="form-control" id="repeat1">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-3">
            <button type="submit" class="btn btn-default">确定</button>
        </div>
    </div>
</form>
</body>
</html>
