<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 03.05.2017
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://meyerweb.com/eric/tools/css/reset/reset.css">
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <title>add ${item.itemName}</title>
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
<div class="container" style="margin-top: 75px;"><%--Item--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="thumbnail">
                <h3>Товар добавлен в корзину</h3>
                <img src="${item.url}" alt="Картинка отсутствует">
                <div class="caption">
                    <h3 class="center">${item.itemName}</h3>
                    <p>${item.description}</p>
                    <p class="center"><a href="/order" class="btn btn-primary" role="button">К корзине</a>
                        <a href="/" class="btn btn-default" role="button">Продолжить покупки</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<%--Item end--%>

</body>
</html>
