<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/17
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>processingOrder</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<c:forEach var="list" items="${nowPage.data}">
    <div class="row">
    <c:forEach var="item" items="${list}">
        <div class="col-xs-6 col-md-3">
            <div class="thumbnail">
                <img src="/resources/${item.get("goodsModel").url}.jpg" alt="${item.get("goodsModel").gname}" class="img-circle">
                <div class="caption">
                    <h3>${item.get("goodsModel").gname}</h3>
                    <p>供货商名称：${item.get("supplierModel").corporation}</p>
                    <p>供货数量：${item.get("applicationModel").supplyNumber}</p>
                    <p>单价：${item.get("applicationModel").price}</p>
                    <p>到货数量:${item.get("orderModel").acceptNumber}</p>
                    <p>已付款金额:${item.get("orderModel").payedMoney}</p>
                    <a href="/admin/orderDetail?orderId=${item.get("orderModel").id}&type=1" class="btn">详情</a>
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
        <a href="/admin/processingOrder?pageNum=1">首页</a>
        <c:choose>
            <c:when test="${requestScope.nowPage.pageNumber > 1}"><a href="/admin/processingOrder?pageNum=${nowPage.pageNumber-1}">上一页</a></c:when>
            <c:otherwise>
                上一页
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${nowPage.pageNumber < nowPage.totalPage}"><a href="/admin/processingOrder?pageNum=${nowPage.pageNumber+1}">下一页</a></c:when>
            <c:otherwise>
                下一页
            </c:otherwise>
        </c:choose>
        <a href="/admin/processingOrder?pageNum=${nowPage.totalPage}">尾页</a>
    </p>
</div>
</body>
</html>
