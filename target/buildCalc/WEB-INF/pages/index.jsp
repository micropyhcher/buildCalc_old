<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="utf-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/regform">Регистрация</a>
<a href="${pageContext.request.contextPath}/logform">Вход</a>
<a href="${pageContext.request.contextPath}/userlist">Список пользователей</a>
<br>
<%--<jstl:if test="${}">Вы вошли под именем:</jstl:if>--%>
    <jstl:out value="Вы вошли под именем: ${userEntered}"/>
<jstl:if test="${isUserListEmpty}">Список пользователей:</jstl:if>
<hr>
<jstl:forEach items="${userList}" var="user">
    <li><jstl:out value="${user}"/></li>
</jstl:forEach>
</body>
</html>
