<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="utf-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/list">На главную</a>
    <br>
    <spring:form modelAttribute="userLogined" method="post" action="${pageContext.request.contextPath}/logform">
        E-Mail: <spring:input path="email"/>
        Пароль: <spring:password path="pass"/>
        <spring:button>Войти</spring:button>
    </spring:form>
    <jstl:out value="${userEntered}"/>
</body>
</html>
