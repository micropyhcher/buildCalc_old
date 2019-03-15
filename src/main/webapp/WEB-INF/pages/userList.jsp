<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="utf-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
    <style>
        <%@include file="../css/bootstrap.min.css"%>
    </style>
</head>
<body>

    <form>
        <input type="button" value="На главную" onClick='location.href="${pageContext.request.contextPath}/list"'>
    </form>
    <p>
    <jstl:if test="${!isUserListEmpty}">Список пользователей:</jstl:if>
    <jstl:if test="${isUserListEmpty}">Список пользователей пуст</jstl:if>
    <hr>
    <jstl:forEach items="${userList}" var="user">
        <li><jstl:out value="${user}"/></li>
    </jstl:forEach>
</body>
</html>
