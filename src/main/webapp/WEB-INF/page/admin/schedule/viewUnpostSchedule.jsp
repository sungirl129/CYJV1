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
<form action="/admin/processPublish" method="post">
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
                        <input type="number" name="bn${item.get("scheduleModel").id}" value="${item.get("scheduleModel").buyNumber}">
                        <button type="submit" name="operation" value="${item.get("scheduleModel").id}">修改</button>
                    </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </c:forEach>
    <div>
        <button type="submit" name="operation" value="ok">发布</button>
        <button type="submit" name="operation" value="cancel">取消</button>
    </div>
</form>

<div class="foot">
    <p>
        总共【${nowPage.totalPage}】页 &nbsp;&nbsp;
        ${nowPage.pageNumber}/${nowPage.totalPage}&nbsp;&nbsp;
        <a href="/admin/manageSchedule?pageNo=1&type=0">首页</a>
        <c:choose>
            <c:when test="${requestScope.nowPage.pageNumber > 1}"><a href="/admin/manageSchedule?pageNo=${nowPage.pageNumber-1}&type=0">上一页</a></c:when>
            <c:otherwise>
                上一页
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${nowPage.pageNumber < nowPage.totalPage}"><a href="/admin/manageSchedule?pageNo=${nowPage.pageNumber+1}&type=0">下一页</a></c:when>
            <c:otherwise>
                下一页
            </c:otherwise>
        </c:choose>
        <a href="/admin/manageSchedule?pageNo=${nowPage.totalPage}&type=0">尾页</a>
    </p>
</div>

</body>
</html>
