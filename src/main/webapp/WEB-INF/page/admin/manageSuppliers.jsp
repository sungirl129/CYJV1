<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/13
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>供应商档案管理</title>
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<h4 style="text-align: center">供应商档案管理</h4>

<form action="/admin/deleteSuppliers" method="post">
    <table id="post" class="table table-striped">
        <thead>
        <tr>
            <th></th>
            <th>公司名称</th>
            <th>地址</th>
            <th>联系人</th>
            <th>电话</th>
            <th>Email</th>
            <th>用户名</th>
            <th>密码</th>
            <th>等级</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${nowPage.data}">
            <tr>
                <td><input type="checkbox" name="supplierId" value="${item.id}"></td>
                <td>${item.corporation}</td>
                <td>${item.address}</td>
                <td>${item.name}</td>
                <td>${item.tel}</td>
                <td>${item.email}</td>
                <td>${item.username}</td>
                <td>${item.password}</td>
                <td>${item.credit}</td>
                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".modify${item.id}">修改</button>
                    <div class="modal fade modify${item.id}" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">修改信息</h4>
                                </div>
                                <div class="modal-body">
                                    <iframe width="100%" style="padding: 0;margin: 0;border: 0" height="78%" src="/admin/modifyModal?id=${item.id}"></iframe>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" rowspan="2">
                总共【${nowPage.totalPage}】页 &nbsp;&nbsp;
                ${nowPage.pageNumber}/${nowPage.totalPage}&nbsp;&nbsp;
                <a href="/admin/manageSuppliers?pageNo=1">首页</a>
                <c:choose>
                    <c:when test="${requestScope.nowPage.pageNumber > 1}"><a href="/admin/manageSuppliers?pageNo=${nowPage.pageNumber-1}">上一页</a></c:when>
                    <c:otherwise>
                        上一页
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${nowPage.pageNumber < nowPage.totalPage}"><a href="/admin/manageSuppliers?pageNo=${nowPage.pageNumber+1}">下一页</a></c:when>
                    <c:otherwise>
                        下一页
                    </c:otherwise>
                </c:choose>
                <a href="/admin/manageSuppliers?pageNo=${nowPage.totalPage}">尾页</a>
            </td>
            <td colspan="2" rowspan="2">
                <button type="submit" value="delete" name="operation">删除</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<br/>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".add_supplier">
    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>  增加
</button>
<div class="modal fade add_supplier" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加供货商</h4>
            </div>
            <form class="form-horizontal" action="/admin/addSupplier" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="corpration_name" class="col-sm-3 control-label">公司名称</label>
                        <div class="col-sm-8">
                            <input type="text"  name="corporation" class="form-control" id="corpration_name" placeholder="公司名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="corpration_addr" class="col-sm-3 control-label">公司地址</label>
                        <div class="col-sm-8">
                            <input type="text"  name="address" class="form-control" id="corpration_addr" placeholder="公司地址">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="person" class="col-sm-3 control-label">联系人</label>
                        <div class="col-sm-8">
                            <input type="text"  name="name" class="form-control" id="person" placeholder="联系人">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tel" class="col-sm-3 control-label">电话</label>
                        <div class="col-sm-8">
                            <input type="tel"  name="tel" class="form-control" id="tel" placeholder="电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label">Email</label>
                        <div class="col-sm-8">
                            <input type="email"  name="email" class="form-control" id="email" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="set_name" class="col-sm-3 control-label">用户名</label>
                        <div class="col-sm-8">
                            <input type="text"  name="username" class="form-control" id="set_name" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-8">
                            <input type="password"  name="password" class="form-control" id="password" placeholder="密码">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
