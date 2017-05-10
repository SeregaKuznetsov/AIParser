<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27.04.2017
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--<%@ page isELIgnored="false" %>--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Список пользователей</title>
    <link rel="stylesheet" href="http://meyerweb.com/eric/tools/css/reset/reset.css">
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
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
                <li><a href="/all_users">Пользователи</a></li>
                <li><a href="/new">Добавить товар</a></li>
                <li><a href="/all_items">Список товаров</a></li>
                <li><a href="/order">Корзина</a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<%--HEADER end--%>
<div class="container" style="margin-top: 75px;"><%--Таблица пользователей--%>
    <div class="row">
        <div class="col-md-1 col-md-offset-4">
            <form action="/all_users">
                <table class="table table-bordered table-hover">
                    <tr>
                        <th class="bold">Email</th>
                        <th class="bold">Имя пользователя</th>
                        <th class="bold">Роль</th>
                        <th class="bold">Статус подтверждения</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.role}"/></td>
                            <td><c:out value="${user.isActive}"/></td>
                        </tr>
                    </c:forEach>
                </table>
                <%--<button class="btn btn-primary" type="submit">Сохранить изменения</button>--%>
                <a class="btn btn-default" href="/">На главную</a>
            </form>
        </div>
    </div>
</div>
<%--<script>--%>
<%--function changeRole(input) {--%>
<%--$.post('/userlist?role=' + $(input).attr('data-role') + '&id=' + $(input).attr('data-user'));--%>
<%--}--%>
<%--</script>--%>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.js"></script>
</body>
</html>

