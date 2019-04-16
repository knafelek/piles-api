<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rejestracja</title>
    <style>
        .error{
            color: red;
            font-weight:bold;
        }
        body{
            background-color: lightgray;
        }
        div {
            width:300px;
            background-color: yellow;
            text-align:center;
            margin-bottom:15px;
            border:5px solid #000;
            padding:15px;
        }
        .btn{
            background-color: black;
            color: white;
            width:100px;
            height:40px;
            line-height:40px;
            text-align:center;
            font-weight:700;
        }

    </style>
</head>
<body>
<form:form modelAttribute="registrationForm" method="post">
    <form:errors path="*"/>
    Nazwa użytkownika: <form:input path="username"/><br>
    Imię: <form:input path="firstName"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    Hasło: <form:input path="password"/><br>
    Powtórz hasło: <form:input path="confirmedPassword"/><br>
    <button type="submit" value="Zarejestruj" class="btn"></button>
</form:form>
</body>
</html>
