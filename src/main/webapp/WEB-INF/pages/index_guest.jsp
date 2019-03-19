<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="utf-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Главная</title>
    <style>
        <%@include file="../css/bootstrap.min.css"%>
    </style>
</head>
<body>

    <form class="input-group" style="background: #0069d9">
        <input type="button" value="Регистрация" onClick='location.href="${pageContext.request.contextPath}/regform"'>
        <input type="button" value="Вход на сайт" onClick='location.href="${pageContext.request.contextPath}/logform"'>
    </form>


</body>
</html>
