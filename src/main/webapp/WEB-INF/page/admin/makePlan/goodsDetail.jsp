<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/25
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>goodsDetail</title>
    <link type="text/css" href="/resources/css/admin.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<h4 class="title_h4">货物详情</h4>
<div class="thumbnail detail_goods">
    <img src="/resources/${goodsModel.url}.jpg" alt="${goodsModel.gname}" class="img-rounded" width="200" height="200">
    <div class="caption">
        <h3>${goodsModel.gname}</h3>
        <p style="text-align: center">单位：${goodsModel.unit}</p>
        <p style="text-align: center">规格：${goodsModel.spec}</p>
        <p style="text-align: center">备注：${goodsModel.note}</p>
        <p style="text-align: center">现有库存：${stockModel.nowNumber}</p>
        <p style="text-align: center">最小库存：${stockModel.minStore}</p>
        <p style="text-align: center">最大库存：${stockModel.maxStore}</p>
    </div>
</div>
</body>
</html>
