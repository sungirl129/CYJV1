<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Administrator--%>
  <%--Date: 2017/4/26--%>
  <%--Time: 17:20--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
    <%--<link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">--%>
    <%--<script src="/resources/js/jquery-3.1.1.min.js"></script>--%>
    <%--<script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>--%>
    <%--<script src="/resources/js/Chart.bundle.js"></script>--%>
    <%--<script src="/resources/js/utils.js"></script>--%>
    <%--<script src="/resources/js/statistics.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<nav class="navbar navbar-default">--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
            <%--<form action="/admin/pie" class="navbar-form navbar-left" id="myForm">--%>
                <%--<div class="form-group">--%>
                    <%--<select name="type" class="form-control">--%>
                        <%--<option value="gname" selected="selected">货物名称</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="text" class="form-control" placeholder="Search" name="condition">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<select class="form-control">--%>
                        <%--<option value="year" selected="selected">年份</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="number" class="form-control" placeholder="2017" name="year">--%>
                <%--</div>--%>
                <%--<button type="button" onclick="query()" class="btn btn-default">查看</button>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>
<%--<div id="canvas-holder" style="width:40%">--%>
    <%--<canvas id="chart-area" />--%>
<%--</div>--%>
<%--<script>--%>
    <%--window.onload = function() {--%>
        <%--window.ctx = document.getElementById("chart-area").getContext("2d");--%>
        <%--console.log(window.ctx);--%>
        <%--query();--%>
    <%--};--%>
<%--</script>--%>

<%--</body>--%>
<%--</html>--%>


<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/26
  Time: 17:20
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
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form action="/admin/pie" class="navbar-form navbar-left" target="context">
                <div class="form-group">
                    <select name="type" class="form-control">
                        <option value="gname" selected="selected">货物名称</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" name="gname">
                </div>
                <div class="form-group">
                    <select name="time" class="form-control">
                        <option value="year" selected="selected">年份</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" placeholder="2017" name="year">
                </div>
                <div class="form-group">
                    <select name="style" class="form-control">
                        <option value="bar" selected="selected">条形图</option>
                        <option value="line">折线图</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">查看</button>
            </form>
        </div>
    </div>
</nav>

<iframe src="/admin/viewStatistics" width="100%" height="90%" name="context"></iframe>
</body>
</html>
