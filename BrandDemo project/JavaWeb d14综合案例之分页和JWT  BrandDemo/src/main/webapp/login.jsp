<%--
  Created by IntelliJ IDEA.
  User: ytdag
  Date: 2023/11/9
  Time: 11:37
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
<h4><font color="red ">${error}</font> </h4>
<br>
<form action="<%=request.getContextPath()%>/login" id="form" method="post">
    <h1 id="loginMsg">登陆</h1>
    <p>用户名:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>

    <p>密码:<input id="password" name="password" type="password"></p>
    <p><input type="checkbox" name="isRemember"/>记住我 </p>
    <p>验证码：<input type="text" name="checkcode"/>

        <img id="checkCodeImg" src="<%=request.getContextPath()%>/checkCode"/>
        <a href="#" id="changeImg">看不清</a>

    </p>
    <div id="subDiv">
        <input type="submit" class="button" value="登陆">
        <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;

    </div>
</form>
<script>
    document.getElementById("changeImg").onclick = function () {
        document.getElementById("checkCodeImg").src = "<%=request.getContextPath()%>/checkCode?"+new Date().getMilliseconds();
    }

</script>
</body>
</html>
