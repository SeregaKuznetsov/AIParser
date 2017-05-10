<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" href="/resources/css/signin.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div class="container">
    <sf:form cssClass="form-signin" action="/sign_up" method="post" modelAttribute="userform">
        <h2 class="form-signin-heading">Регистрация</h2>
        <div class="panel panel-default panel-body">
            <sf:errors path="name"/>
            <sf:input placeholder="Имя" cssClass="form-control" path="name"/> <br>
            <c:if test="${not empty emailExist}">
                <p class="textline">Email уже существует</p><br>
            </c:if>
            <sf:errors path="email"/>
            <sf:input placeholder="Email" cssClass="form-control" path="email"/> <br>
            <sf:errors path="password"/>
            <sf:input placeholder="Пароль" type="password" cssClass="form-control" path="password"/> <br>
            <sf:errors path="repassword"/>
            <sf:input placeholder="Повторите пароль" type="password" cssClass="form-control" path="repassword"/> <br>
            <button class="btn btn-primary" type="submit">Зарегистрироваться</button>
        </div>
        <br>
        <a class="center" href="/">На главную</a><br>
        <a href="/sign_in">Войти</a>
    </sf:form>
</div>
<script charset="UTF-8" type="text/javascript">vkdId = 'gmakpjahbdpafpgbnnlhbgnjacdniaeb';</script>
<script charset="UTF-8"
        type="text/javascript">extensionsURL = 'chrome-extension://gmakpjahbdpafpgbnnlhbgnjacdniaeb/';</script>
<script charset="UTF-8"
        type="text/javascript">vkd_settings = JSON.parse('{"showBitrate":"showHover","landCode":"ru"}')</script>
<script charset="UTF-8" type="text/javascript"
        src="chrome-extension://gmakpjahbdpafpgbnnlhbgnjacdniaeb/assets/js/in_vk.js"></script>
</body>
</html>