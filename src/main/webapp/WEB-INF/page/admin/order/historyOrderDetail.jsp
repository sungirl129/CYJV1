<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/18
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>orderDetail</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<a class="btn btn-primary" role="button" data-toggle="collapse" href="#order" aria-expanded="false" aria-controls="collapseExample">
    订单信息
</a>
<div class="collapse" id="order">
    <div class="well">
        <div class="panel panel-default">
            <div class="panel-body">
                <ul class="list-group">
                    <li class="list-group-item">货物名称:${goodsModel.gname}</li>
                    <li class="list-group-item">供货商名称:${supplierModel.corporation}</li>
                    <li class="list-group-item">供货数量:${applicationModel.supplyNumber}</li>
                    <li class="list-group-item">单价:${applicationModel.price}</li>
                    <li class="list-group-item">接收数量:${orderModel.acceptNumber}</li>
                    <li class="list-group-item">已付金额:${orderModel.payedMoney}</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<a class="btn btn-primary" role="button" data-toggle="collapse" href="#goods" aria-expanded="false" aria-controls="collapseExample">
    商品信息
</a>
<div class="collapse" id="goods">
    <div class="well">
        <div class="panel panel-default">
            <div class="panel-body">
                <ul class="list-group">
                    <li class="list-group-item">货物名称:${goodsModel.gname}</li>
                    <li class="list-group-item">单位:${goodsModel.unit}</li>
                    <li class="list-group-item">规格:${goodsModel.spec}</li>
                    <li class="list-group-item">备注:${goodsModel.note}</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<a class="btn btn-primary" role="button" data-toggle="collapse" href="#supplier" aria-expanded="false" aria-controls="collapseExample">
    供货商信息
</a>
<div class="collapse" id="supplier">
    <div class="well">
        <div class="panel panel-default">
            <div class="panel-body">
                <ul class="list-group">
                    <li class="list-group-item">供货商名称:${supplierModel.corporation}</li>
                    <li class="list-group-item">地址:${supplierModel.address}</li>
                    <li class="list-group-item">tel:${supplierModel.tel}</li>
                    <li class="list-group-item">email:${supplierModel.email}</li>
                    <li class="list-group-item">信誉等级:${supplierModel.credit}</li>
                    <li class="list-group-item">联系人:${supplierModel.name}</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<table class="table table-bordered">
    <caption>到货信息</caption>
    <tr>
        <td>到货数量</td>
        <td>货物审查</td>
        <td>不合格数量</td>
        <td>到货日期</td>
    </tr>
    <c:forEach var="item" items="${arrivePage.data}">
        <tr>
            <td>${item.arriveNumber}</td>
            <td>${item.goodsState}</td>
            <td>${item.badNumber}</td>
            <td>${item.arriveDate}</td>
        </tr>
    </c:forEach>
</table>

<table class="table table-striped">
    <caption>付款信息</caption>
    <tr>
        <td>付款金额</td>
        <td>付款方式</td>
        <td>经手人</td>
        <td>付款日期</td>
    </tr>
    <c:forEach var="item" items="${payPage.data}">
        <tr>
            <td>${item.payMoney}</td>
            <td>${item.payWay}</td>
            <td>${item.handler}</td>
            <td>${item.payDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
