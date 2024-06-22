<%--
  Created by IntelliJ IDEA.
  User: 74168
  Date: 2023/11/8
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<h4><font color="#8a2be2 ">${error}</font> </h4>
<br>
<form action="<%=request.getContextPath()%>/login" id="form" method="post">
    <h1 id="loginMsg">登陆</h1>
    <p>用户名:<input id="username" name="username" type="text"></p>

    <p>密码:<input id="password" name="password" type="password"></p>

    <div id="subDiv">
        <input type="submit" class="button" value="登陆">
        <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;

    </div>
</form>
</body>
</html>
