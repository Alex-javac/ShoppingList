<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Shopping List</title>

</head>
<body>
<spring:form method="post"  modelAttribute="userJSP" action="check-user">

    Login: <spring:input path="login"/>  <br/>
    Password: <spring:input path="password"/>   <br/>
    <spring:button>Next Page</spring:button>

</spring:form>
</body>
</html>





