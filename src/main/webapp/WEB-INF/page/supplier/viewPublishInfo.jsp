<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/16
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>viewPublishInfo</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/supplier/processApply" method="post">
    <c:forEach var="list" items="${curPage.data}">
        <div class="row">
            <c:forEach var="item" items="${list}">
                <div class="col-xs-6 col-md-3">
                    <div class="thumbnail">
                        <input type="checkbox" name="applyId" value="${item.get("publishModel").id}">
                        <img src="/resources/${item.get("goodsModel").url}.jpg" alt="${item.get("goodsModel").gname}" class="img-circle">
                        <div class="caption">
                            <h3>${item.get("goodsModel").gname}</h3>
                            <p>单位：${item.get("goodsModel").unit}</p>
                            <p>规格：${item.get("goodsModel").spec}</p>
                            <p>备注：${item.get("goodsModel").note}</p>
                            <p>已发布个数:${item.get("publishModel").publishNumber}</p>
                            <p>已申请数目:${item.get("publishModel").applyNumber}</p>
                            <div>
                                供货数量：<input type="number" name="n${item.get("publishModel").id}">
                            </div>
                            <div>
                                单价(元)：<input type="number" step="0.01" name="p${item.get("publishModel").id}">
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:forEach>
    <div>
        <button type="submit">申请</button>
    </div>
</form>
<div class="foot">
    <p>
        总共【${curPage.totalPage}】页 &nbsp;&nbsp;
        ${curPage.pageNumber}/${curPage.totalPage}&nbsp;&nbsp;
        <a href="/supplier/viewPublishInfo?pageNumber=1">首页</a>
        <c:choose>
            <c:when test="${requestScope.curPage.pageNumber > 1}"><a href="/supplier/viewPublishInfo?pageNumber=${curPage.pageNumber-1}">上一页</a></c:when>
            <c:otherwise>
                上一页
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${curPage.pageNumber < curPage.totalPage}"><a href="/supplier/viewPublishInfo?pageNumber=${curPage.pageNumber+1}">下一页</a></c:when>
            <c:otherwise>
                下一页
            </c:otherwise>
        </c:choose>
        <a href="/supplier/viewPublishInfo?pageNumber=${curPage.totalPage}">尾页</a>
    </p>
</div>
</body>
</html>
