<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改品牌</title>
</head>
<body>
<h3>修改品牌</h3>
<%-- 如何知道要更新哪个品牌数据--%>
<form action="<%=request.getContextPath()%>/update" method="post">

    <%-- type="hidden" 隐藏域，为了悄悄的提交id--%>
    <input type="hidden" name="id" value="${brand.id}">
<%--      表单 提交框 自动填写好了 当前品牌的信息--%>
    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description} </textarea><br>
    状态：
    <c:if test="${brand.status == 0}">

        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>

    <c:if test="${brand.status == 1}">

        <input type="radio" name="status" value="0" >禁用
<%--        checked  哪个 单选框被勾选中--%>
        <input type="radio" name="status" value="1" checked>启用<br>
    </c:if>


    <input type="submit" value="提交">
</form>
</body>
</html>