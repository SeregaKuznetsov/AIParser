<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22.10.15
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://meyerweb.com/eric/tools/css/reset/reset.css">
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <title>Forbidden</title>
</head>
<body>
<%--HEADER--%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">OnlineShop</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Главная</a></li>
                <security:authorize access="hasRole('ROLE_BUYER')">
                    <li><a href="/logout">Выйти</a></li>
                    <li><a href="/order">Корзина</a></li>
                </security:authorize>
                <security:authorize access="isAnonymous()">
                    <li><a href="/sign_in">Войти</a></li>
                </security:authorize>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/all_users">Пользователи</a></li>
                    <li><a href="/all_items">Список товаров</a></li>
                    <li><a href="/new">Добавить товар</a></li>
                    <li><a href="/order">Корзина</a></li>
                    <li><a href="/logout">Выйти</a></li>
                </security:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div><%--HEADER end--%>
<div class="container" style="margin-top: 75px">
    <h1>Недостаточно прав</h1>
    <h2><a href="/">Перейти на главную</a></h2>
</div>
</body>
</html>
