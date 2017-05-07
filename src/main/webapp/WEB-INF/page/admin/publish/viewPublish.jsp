<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/15
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>viewPublish</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form action="/admin/viewPublish?pageNumber=1" class="navbar-form navbar-left">
                <div class="form-group">
                    <span class="form-control">发布单状态：</span>
                    <select name="type" class="form-control">
                        <option value="0" selected="selected">发布中</option>
                        <option value="1">已取消</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">查看</button>
            </form>
        </div>
    </div>
</nav>
<h3>${title}</h3>
<form action="/admin/cancelPublish?pageNumber=${curPage.pageNumber}&type=${type}" method="post">
    <c:forEach var="list" items="${curPage.data}">
        <div class="row">
        <c:forEach var="item" items="${list}">
            <div class="col-xs-6 col-md-3">
                <div class="thumbnail">
                    <img src="/resources/${item.get("goodsModel").url}.jpg" alt="${item.get("goodsModel").gname}" class="img-circle">
                    <div class="caption">
                        <h3>${item.get("goodsModel").gname}</h3>
                        <p>单位：${item.get("goodsModel").unit}</p>
                        <p>规格：${item.get("goodsModel").spec}</p>
                        <p>备注：${item.get("goodsModel").note}</p>
                        <p>已发布个数:${item.get("publishModel").publishNumber}</p>
                        <p>已申请数目:${item.get("publishModel").applyNumber}</p>
                        <button type="submit" name="operation" value="${item.get("publishModel").id}">${btnName}</button>
                    </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </c:forEach>
</form>
<div class="foot">
    <p>
        总共【${curPage.totalPage}】页 &nbsp;&nbsp;
        ${curPage.pageNumber}/${curPage.totalPage}&nbsp;&nbsp;
        <a href="/admin/viewPublish?pageNumber=1">首页</a>
        <c:choose>
            <c:when test="${requestScope.curPage.pageNumber > 1}"><a href="/admin/viewPublish?pageNumber=${curPage.pageNumber-1}">上一页</a></c:when>
            <c:otherwise>
                上一页
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${curPage.pageNumber < curPage.totalPage}"><a href="/admin/viewPublish?pageNumber=${curPage.pageNumber+1}">下一页</a></c:when>
            <c:otherwise>
                下一页
            </c:otherwise>
        </c:choose>
        <a href="/admin/viewPublish?pageNumber=${curPage.totalPage}">尾页</a>
    </p>
</div>
</body>
</html>
