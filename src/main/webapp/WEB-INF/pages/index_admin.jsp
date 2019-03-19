<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="utf-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>

<form class="input-group" style="background: #0069d9">
    <input type="button" value="Выйти из записи" onClick='location.href="${pageContext.request.contextPath}/unlog"'>
    <input type="button" value="Список пользователей" onClick='location.href="${pageContext.request.contextPath}/userlist"' align="right">
</form>

</body>
</html>
