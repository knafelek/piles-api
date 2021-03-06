<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="/media/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/media/css/main.css"/>
</head>
<body>
<header>
    <nav class="navbar navbar-light bg-info navbar-expand-md">

        <a class="navbar-brand" href="http://localhost:8090/home"><img src="/media/images/logo.jpg" width="50" height="50" alt=""> pilesAPI</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainmenu" aria-controls="mainmenu" aria-expanded="false" aria-label="Przełącznik nawigacji">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class = "collapse navbar-collapse" id="mainmenu">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"> STRONA GŁÓWNA </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"> OBLICZENIA </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-expanded="false" id="submenu"> MOJE INWESTYCJE </a>
                        <div class="dropdown-menu" aria-labelledby="submenu" aria-haspopup="true">
                            <a class="dropdown-item" href="#"> Pokaż wszystkie inwestycje </a>
                            <a class="dropdown-item" href="#"> Dodaj nową inwestycję </a>
                        </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-expanded="false" id="submenu"> BAZA DANYCH </a>
                    <div class="dropdown-menu" aria-labelledby="submenu" aria-haspopup="true">
                        <a class="dropdown-item" href="#"> Pokaż tabele pali </a>
                        <a class="dropdown-item" href="#"> Zapisz nowy pal </a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"> REJESTRACJA </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#"> ZALOGUJ </a>
                </li>
                <li class="nav-item disabled">
                    <a class="nav-link" href="/logout"> WYLOGUJ </a>
                </li>
            </ul>
        </div>

    </nav>
</header>

<div class = "container">
<form method ="post" action="/login">
    <br><h1 align="center">LOGOWANIE</h1><br>
    <p>Nazwa użytkownika:<br/>
    <input type="text" name="username" required min="3" max="20"/></p>
    <p>Hasło: <br/>
    <input type="password" name="password" required min="3" max="20"/></p>
    <p> <input type="checkbox" name="remember-me"/> Zapamiętaj mnie <p/>
    <input type="submit" value="Zaloguj" class="btn"/><br><br>

    <c:if test="${param.error != null}">
        <span class="error"> <b> Nieprawidłowe dane logowania! </b> </span>
    </c:if>
    <c:if test="${param.logout != null}">
        <span class="error"> <b> Zostałeś wylogowany! </b> </span>
    </c:if>

</form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
