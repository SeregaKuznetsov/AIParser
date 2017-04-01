<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>History</title>
</head>


<body>
<p1> Operation history: </p1>
<br>

<core:forEach var="calculator" items="${history}">
    ${calculator.firstOperand} ${calculator.secondOperand} ${calculator.mathAction} ${calculator.date} <br>
</core:forEach>
</body>
</html>

