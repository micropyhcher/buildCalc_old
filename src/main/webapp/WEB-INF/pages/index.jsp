<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="utf-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>

<img src="${pageContext.request.contextPath}/WEB-INF/images/Logo.jpg" alt="Фон" align="center">

    <form style="background: cadetblue">
        <input type="button" value="Регистрация" onClick='location.href="${pageContext.request.contextPath}/regform"'>
        <input type="button" value="Вход на сайт" onClick='location.href="${pageContext.request.contextPath}/logform"'>
        <input type="button" value="Список пользователей" onClick='location.href="${pageContext.request.contextPath}/userlist"'>
    </form>
<br>
<jstl:if test="${isUserLogined}">Вы вошли под именем:</jstl:if>
    <jstl:out value="${userEntered}"/>
</body>
</html>
