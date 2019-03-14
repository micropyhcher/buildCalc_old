<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="utf-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/list">На главную</a>
<br>
    <spring:form modelAttribute="newUser" method="post" action="${pageContext.request.contextPath}/regform">
        Ваше имя: <spring:input path="name"/>
        Ваш возраст: <spring:input path="age"/>
        Ваш E-Mail: <spring:input path="email"/>
        Пароль: <spring:password path="pass"/>
        <spring:button>Зарегистрироваться</spring:button>
    </spring:form>
    <jstl:if test="${errorRegisterMessage.size() > 0}">Ошибка введенных данных:</jstl:if>
    <jstl:forEach items="${errorRegisterMessage}" var="i">
        <li><jstl:out value="${i}"/></li>
    </jstl:forEach>
    <jstl:out value="${errorRegisterMessage_doubleUser}"/>
</body>
</html>
