<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rejestracja</title>
    <link rel="stylesheet" href="/media/css/main.css"/>
</head>
<body>
<form:form modelAttribute="registrationForm" method="post">
    <form:errors path="*" cssClass="error"/>
    <p>Nazwa użytkownika:<br/><form:input path="username"/></p>
    <p>Imię:<br/><form:input path="firstName"/></p>
    <p>Nazwisko:<br/><form:input path="lastName"/></p>
    <p>Hasło:<br/><form:input path="password"/></p>
    <p>Powtórz hasło:<br/><form:input path="confirmedPassword"/></p>
    <input type="submit" value="Zarejestruj" class="btn">
</form:form>
</body>
</html>
