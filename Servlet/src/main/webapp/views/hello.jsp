<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Uri</title>
</head>
<body>
<c:if test="${!flag}">
    <h2>Please sign up</h2>
</c:if>

<h2><c:out value="${message}"/></h2>

</body>
</html>