<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/14
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>viewStock</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<h3 style="text-align: center">库存信息</h3>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form action="/admin/search?pageNo=1" class="navbar-form navbar-left">
                <div class="form-group">
                    <select name="type" class="form-control">
                        <option value="gname" selected="selected">货物名称</option>
                        <option value="unit">单位</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" name="condition">
                </div>
                <div class="form-group">
                    <select name="stock" class="form-control">
                        <option value="stock">库存范围</option>
                        <option value="null" selected="selected">无</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" placeholder="最小库存" name="stockL">
                </div>
                <div class="form-group">
                    <span class="form-control">至</span>
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" placeholder="最大库存" name="stockR">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
        </div>
    </div>
</nav>

<c:forEach var="row" items="${nowPage.data}">
    <div class="row">
    <c:forEach var="item" items="${row}">
        <div class="col-xs-6 col-md-3">
            <div class="thumbnail">
                <img src="/resources/${item.goodsModel.url}.jpg" alt="${item.goodsModel.gname}">
                <div class="caption">
                    <h3>${item.goodsModel.gname}</h3>
                    <p>单位：${item.goodsModel.unit}</p>
                    <p>规格：${item.goodsModel.spec}</p>
                    <p>备注：${item.goodsModel.note}</p>
                    <p>现有库存：${item.stockModel.nowNumber}</p>
                    <p>最小库存：${item.stockModel.minStore}</p>
                    <p>最大库存：${item.stockModel.maxStore}</p>
                </div>
            </div>
        </div>
    </c:forEach>
    </div>
</c:forEach>

<hr/>
<p>
    总共【${nowPage.totalPage}】页 &nbsp;&nbsp;
    ${nowPage.pageNumber}/${nowPage.totalPage}&nbsp;&nbsp;
    <a href="/admin/viewStock?pageNo=1">首页</a>
    <c:choose>
        <c:when test="${requestScope.nowPage.pageNumber > 1}"><a href="/admin/viewStock?pageNo=${nowPage.pageNumber-1}">上一页</a></c:when>
        <c:otherwise>
            上一页
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${nowPage.pageNumber < nowPage.totalPage}"><a href="/admin/viewStock?pageNo=${nowPage.pageNumber+1}">下一页</a></c:when>
        <c:otherwise>
            下一页
        </c:otherwise>
    </c:choose>
    <a href="/admin/viewStock?pageNo=${nowPage.totalPage}">尾页</a>
</p>

</body>
</html>
