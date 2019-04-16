<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/media/css/main.css"/>
</head>
<body>
<form method ="post" action="/login">
    <c:if test="${param.error != null}">
        <span> Nieprawidłowe dane logowania </span>
    </c:if>
    <c:if test="${param.logout != null}">
        <span> Zostałeś wylogowany </span>
    </c:if>
    <p>Nazwa użytkownika:<br/>
    <input type="text" name="username" required min="3" max="20"/></p>
    <p>Hasło: <br/>
    <input type="password" name="password" required min="3" max="20"/></p>
    <p> <input type="checkbox" name="remember-me"/> Czy zapamiętać? <p/>
    <input type="submit" value="Zaloguj" class="btn"/>
</form>
</body>
</html>
