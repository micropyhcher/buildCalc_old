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

<div>
    <jstl:if test="${enteredUser.name.length()>0}">
        <jstl:out value="Вы вошли под именем: ${enteredUser}"/>
    </jstl:if>
    <%--<jstl:out value="from session ${enteredUserFromSession}"/>--%>
</div>


<img src="${pageContext.request.contextPath}images/Logo.jpg" alt="Фон" style="alignment: center">

    <form class="input-group" style="background: #0069d9">
        <input type="button" value="Регистрация" onClick='location.href="${pageContext.request.contextPath}/regform"'>
        <input type="button" value="Вход на сайт" onClick='location.href="${pageContext.request.contextPath}/logform"'>
        <input type="button" value="Список пользователей" onClick='location.href="${pageContext.request.contextPath}/userlist"'>
    </form>
<br>


</body>
</html>
