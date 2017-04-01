<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 18.03.2017
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>


<sf:form action="/calculator/operate" method="post" modelAttribute="calculator">

    <sf:label path="firstOperand">Current digit: </sf:label> <sf:input path="firstOperand" value="${summa}"/> <sf:errors path="firstOperand"/>
    <br><sf:label path="secondOperand">Second Operand: </sf:label> <sf:input path="secondOperand"/> <sf:errors path="secondOperand"/><br>

    <div class="buttons">
        <sf:button class="btn btn-primary btn-lg" name= "mathAction" value = "addition">+</sf:button>
        <sf:button  class="btn btn-primary btn-lg" name= "mathAction" value = "subtraction">-</sf:button>
        <sf:button  class="btn btn-primary btn-lg" name= "mathAction" value = "multiplication">*</sf:button>
        <sf:button class="btn btn-primary btn-lg" name= "mathAction" value = "division">/</sf:button>
    </div>

</sf:form>


</body>
</html>
