<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Uri</title>
</head>
<body>

    <c:forEach items="${list}" var="file">
        ${file}<br>
    </c:forEach>

</body>
</html>