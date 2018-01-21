<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 19.01.18
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register Page</h1>
    <%--@elvariable id="user" type="pl.coderslab.entity.User"--%>
    <form:form method="post" action="#" modelAttribute="user">
        Username: <form:input path="username"/>
        <form:errors path="username"/><br>
        Email: <form:input path="email"/>
        <form:errors path="email"/><br>
        Password: <form:password path="password"/>
        <form:errors path="password"/><br>
        <input type="submit" value="register"/>
        <form:errors path="*"/>
    </form:form>
<br>Do you have and account? <a href="/user/login">Login now</a>.
</body>
</html>
