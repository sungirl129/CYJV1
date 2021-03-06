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
            <form action="/admin/predict" class="navbar-form navbar-left" target="context">
                <div class="form-group">
                    <select name="type" class="form-control">
                        <option value="gname" selected="selected">货物名称</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" name="gname">
                </div>
                <%--<div class="form-group">--%>
                    <%--<select name="time" class="form-control">--%>
                        <%--<option value="year" selected="selected">年份</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="number" class="form-control" name="year" value="2017">--%>
                <%--</div>--%>
                <button type="submit" class="btn btn-default">预测</button>
            </form>
        </div>
    </div>
</nav>
<iframe src="/admin/" width="100%" height="90%" name="context"></iframe>
</body>
</html>
