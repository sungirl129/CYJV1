<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/15
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>viewUnpostSchedule</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form action="/admin/manageSchedule" class="navbar-form navbar-left">
                <div class="form-group">
                    <select name="type" class="form-control">
                        <option value="0" selected="selected">未发布计划</option>
                        <option value="1">已发布计划</option>
                        <option value="2">无效计划</option>
                    </select>
                </div>
                <%--<button type="button" onclick="query()" class="btn btn-default">查看</button>--%>
                <button type="submit" class="btn btn-default">查看</button>
            </form>
        </div>
    </div>
</nav>

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

<h4 style="text-align: center">${title}</h4>
<c:forEach var="list" items="${nowPage.data}">
    <div class="row">
        <c:forEach var="item" items="${list}">
            <div class="col-xs-6 col-md-3">
                <div class="thumbnail">
                    <input type="checkbox" name="selectPlans" value="${item.get("scheduleModel").id}">
                    <img src="/resources/${item.get("goodsModel").url}.jpg" alt="${item.get("goodsModel").gname}" class="img-circle">
                    <div class="caption">
                        <h3>${item.get("goodsModel").gname}</h3>
                        <p>单位：${item.get("goodsModel").unit}</p>
                        <p>规格：${item.get("goodsModel").spec}</p>
                        <p>备注：${item.get("goodsModel").note}</p>
                        <p>采购数量:${item.get("scheduleModel").buyNumber}</p>
                        <p>发布日期：${item.get("scheduleModel").publishDate}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</c:forEach>

<div class="foot">
    <p>
        总共【${nowPage.totalPage}】页 &nbsp;&nbsp;
        ${nowPage.pageNumber}/${nowPage.totalPage}&nbsp;&nbsp;
        <a href="/admin/manageSchedule?pageNo=1&type=1">首页</a>
        <c:choose>
            <c:when test="${requestScope.nowPage.pageNumber > 1}"><a href="/admin/manageSchedule?pageNo=${nowPage.pageNumber-1}&type=1">上一页</a></c:when>
            <c:otherwise>
                上一页
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${nowPage.pageNumber < nowPage.totalPage}"><a href="/admin/manageSchedule?pageNo=${nowPage.pageNumber+1}&type=1">下一页</a></c:when>
            <c:otherwise>
                下一页
            </c:otherwise>
        </c:choose>
        <a href="/admin/manageSchedule?pageNo=${nowPage.totalPage}&type=1">尾页</a>
    </p>
</div>

</body>
</html>
