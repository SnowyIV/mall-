<%--
  Created by IntelliJ IDEA.
  User: ytdag
  Date: 2023/11/7
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 设置不要忽略EL表达式 --%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>品牌列表</title>
</head>
<body>
欢迎您:<h3>${uname}</h3>
<h5><font color="#dc143c">${error}</font> </h5>
<%--  onclick 点击按钮后会触发的JS方法
 location.href  网页会跳转到哪里
 --%>
<%
request.getContextPath();
session.getAttribute("uname");
application.getAttribute("onlineUsers");
%>
<h2>在线用户列表</h2>

<c:forEach items="${onlineUsers}" var="onlineUser" >

    <b>${onlineUser}</b>
</c:forEach>

<hr>
<%--<a href="addBrand.jsp">  添加</a>--%>
<a href="/logout">注销</a>
<%-- 在各个作用域中查找 role变量，不为null，才会显示添加按钮--%>
<c:if test="${role != null}">
    <input type="button" value="添加" onclick="location.href='addBrand.jsp'" />
</c:if>

<table border="1" cellspacing="0" >
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>
    <%--   前提，  目标变量bdList是一个集合 或者数组--%>
  <c:forEach items="${bdList}" var="brand">
    <tr>
        <td>${brand.id}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.ordered}</td>
        <td>${brand.description}</td>
        <td>${brand.status == 1 ? '启用' : '禁用'}</td>
        <td><a href="<%=request.getContextPath()%>/selectById?brdId=${brand.id}">修改</a> <a href="<%=request.getContextPath()%>/delete?id=${brand.id}">删除</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
