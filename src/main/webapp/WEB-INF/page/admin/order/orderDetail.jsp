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
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/resources/AmazeUI-2.7.2/assets/css/app.css">
    <script src="/resources/AmazeUI-2.7.2/assets/js/amazeui.min.js"></script>
    <script>
        function show() {
            var div1 = document.getElementById("badNumDiv");
            var div2 = document.getElementById("processWayDiv");
            div1.style.display = 'block';
            div2.style.display = 'block';
        }

        function mix() {
            var div1 = document.getElementById("mixDiv");
            div1.style.display = 'block';
        }
    </script>
</head>
<body>

<div class="am-panel-group" id="accordion">
    <div class="am-panel am-panel-default">
        <div class="am-panel-hd">
            <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-1'}">
                订单信息
            </h4>
        </div>
        <div id="do-not-say-1" class="am-panel-collapse am-collapse am-in">
            <div class="am-panel-bd">
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
    </div>
    <div class="am-panel am-panel-default">
        <div class="am-panel-hd">
            <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-2'}">
                商品信息
            </h4>
        </div>
        <div id="do-not-say-2" class="am-panel-collapse am-collapse">
            <div class="am-panel-bd">
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
    </div>
    <div class="am-panel am-panel-default">
        <div class="am-panel-hd">
            <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-3'}">
                供货商信息
            </h4>
        </div>
        <div id="do-not-say-3" class="am-panel-collapse am-collapse">
            <div class="am-panel-bd">
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
    </div>
</div>

<%--<a class="btn btn-primary" role="button" data-toggle="collapse" href="#order" aria-expanded="false" aria-controls="collapseExample">--%>
    <%--订单信息--%>
<%--</a>--%>
<%--<div class="collapse" id="order">--%>
    <%--<div class="well">--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-body">--%>
                <%--<ul class="list-group">--%>
                    <%--<li class="list-group-item">货物名称:${goodsModel.gname}</li>--%>
                    <%--<li class="list-group-item">供货商名称:${supplierModel.corporation}</li>--%>
                    <%--<li class="list-group-item">供货数量:${applicationModel.supplyNumber}</li>--%>
                    <%--<li class="list-group-item">单价:${applicationModel.price}</li>--%>
                    <%--<li class="list-group-item">接收数量:${orderModel.acceptNumber}</li>--%>
                    <%--<li class="list-group-item">已付金额:${orderModel.payedMoney}</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<%--<a class="btn btn-primary" role="button" data-toggle="collapse" href="#goods" aria-expanded="false" aria-controls="collapseExample">--%>
    <%--商品信息--%>
<%--</a>--%>
<%--<div class="collapse" id="goods">--%>
    <%--<div class="well">--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-body">--%>
                <%--<ul class="list-group">--%>
                    <%--<li class="list-group-item">货物名称:${goodsModel.gname}</li>--%>
                    <%--<li class="list-group-item">单位:${goodsModel.unit}</li>--%>
                    <%--<li class="list-group-item">规格:${goodsModel.spec}</li>--%>
                    <%--<li class="list-group-item">备注:${goodsModel.note}</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<%--<a class="btn btn-primary" role="button" data-toggle="collapse" href="#supplier" aria-expanded="false" aria-controls="collapseExample">--%>
    <%--供货商信息--%>
<%--</a>--%>
<%--<div class="collapse" id="supplier">--%>
    <%--<div class="well">--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-body">--%>
                <%--<ul class="list-group">--%>
                    <%--<li class="list-group-item">供货商名称:${supplierModel.corporation}</li>--%>
                    <%--<li class="list-group-item">地址:${supplierModel.address}</li>--%>
                    <%--<li class="list-group-item">tel:${supplierModel.tel}</li>--%>
                    <%--<li class="list-group-item">email:${supplierModel.email}</li>--%>
                    <%--<li class="list-group-item">信誉等级:${supplierModel.credit}</li>--%>
                    <%--<li class="list-group-item">联系人:${supplierModel.name}</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<table class="table table-bordered">
    <caption>到货信息</caption>
    <tr>
        <td>到货数量</td>
        <td>货物审查</td>
        <td>不合格数量</td>
        <td>到货日期</td>
        <td>货物处理方式</td>
        <td>退货数量</td>
        <td>换货数量</td>
    </tr>
    <c:forEach var="item" items="${arrivePage.data}">
        <tr>
            <td>${item.arriveNumber}</td>
            <td>${item.strGoodsState}</td>
            <td>${item.badNumber}</td>
            <td>${item.arriveDate}</td>
            <td>${item.strProcessWay}</td>
            <td>${item.returnedNumber}</td>
            <td>${item.exchangeNumber}</td>
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
<hr/>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".arrive">新增到货</button>
<div class="modal fade arrive" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增到货</h4>
            </div>
            <form class="form-horizontal" action="/admin/goodsArrive" method="post">
                <div class="modal-body">
                    <input hidden type="number" name="orderId" value="${orderModel.id}">
                    <div class="form-group">
                        <label for="arriveNum" class="col-sm-3 control-label">到货数量</label>
                        <div class="col-sm-4">
                            <input type="number" class="form-control" id="arriveNum" name="arriveNumber">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="checkGoods" class="col-sm-3 control-label">货物审核</label>
                        <div class="col-sm-4" id="checkGoods">
                            <%--<input type="radio" name="goodsState" value="0" checked>未审查--%>
                            <input type="radio" name="goodsState" value="1">全部合格
                            <input type="radio" name="goodsState" value="2" onclick="show()">部分不合格
                        </div>
                    </div>

                    <div class="modal-body" id="badNumDiv" style="display: none">
                        <div class="form-group">
                            <label for="badNum" class="col-sm-3 control-label">不合格数量</label>
                            <div class="col-sm-4">
                                <input type="number" class="form-control" id="badNum" name="badNumber" value="0">
                            </div>
                        </div>
                    </div>
                    <div class="form-group" id="processWayDiv" style="display: none">
                        <label for="processGoods" class="col-sm-3 control-label">不合格货物处理：</label>
                        <div class="col-sm-4" id="processGoods">
                            <%--<input type="radio" name="goodsState" value="0" checked>未审查--%>
                            <input type="radio" name="processWay" value="1">换货
                            <input type="radio" name="processWay" value="2">退货
                            <input type="radio" name="processWay" value="3" onclick="mix()">退换货
                        </div>
                    </div>
                    <div class="modal-body" id="mixDiv" style="display: none">
                        <div class="form-group">
                            <label for="changeNum" class="col-sm-3 control-label">换货数量</label>
                            <div class="col-sm-4">
                                <input type="number" class="form-control" id="changeNum" name="changeNum" value="0">
                            </div>
                            <p>其余退货</p>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>

<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".pay">新增付款</button>
<div class="modal fade pay" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增付款</h4>
            </div>
            <form class="form-horizontal" action="/admin/goodsPay" method="post">
                <div class="modal-body">
                    <input hidden type="number" name="orderId" value="${orderModel.id}">
                    <div class="form-group">
                        <label for="payMoney" class="col-sm-3 control-label">付款金额</label>
                        <div class="col-sm-4">
                            <input type="number" step="0.01" class="form-control" id="payMoney" name="payMoney">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="payWay" class="col-sm-3 control-label">付款方式</label>
                        <div class="col-sm-4" id="payWay">
                            <input type="radio" name="payWay" value="0" checked>现金
                            <input type="radio" name="payWay" value="1">银行卡
                            <input type="radio" name="payWay" value="2">支付宝
                        </div>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="handler" class="col-sm-3 control-label">经手人</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="handler" name="handler">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
