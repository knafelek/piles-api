<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
    <title>Investition Form</title>
    <link rel="stylesheet" href="/media/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/media/css/main.css"/>
</head>
<body>
<header>
    <nav class="navbar navbar-light bg-info navbar-expand-md">

        <a class="navbar-brand" href="#"><img src="/media/images/logo.jpg" width="50" height="50" alt=""> pilesAPI</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainmenu" aria-controls="mainmenu" aria-expanded="false" aria-label="Przełącznik nawigacji">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class = "collapse navbar-collapse" id="mainmenu">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#"> STRONA GŁÓWNA </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"> OBLICZENIA </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-expanded="false" id="submenu"> MOJE INWESTYCJE </a>
                    <div class="dropdown-menu" aria-labelledby="submenu" aria-haspopup="true">
                        <a class="dropdown-item" href="#"> Pokaż wszystkie inwestycje </a>
                        <a class="dropdown-item" href="#"> Dodaj nową inwestycję </a>
                        <a class="dropdown-item" href="#"> Usuń inwestycję </a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-expanded="false" id="submenu"> BAZA DANYCH </a>
                    <div class="dropdown-menu" aria-labelledby="submenu" aria-haspopup="true">
                        <a class="dropdown-item" href="#"> Pokaż tabele pali </a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"> REJESTRACJA </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"> ZALOGUJ </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"> WYLOGUJ </a>
                </li>
            </ul>
        </div>

    </nav>
</header>
<div class = "container">
    <form>
        <p><br><b>UZUPEŁNIJ DANE INWESTYCJI:</b><br/>
        <p>Numer projektu:<br/>
            <input type="text" name="investitionSignature"/></p>
        <p>Nazwa inwestycji: <br/>
            <input type="text" name="investitionTitle"/></p>
        <p>Opis inwestycji: <br/>
            <input type="text" name="description"/></p>
        <input type="submit" value="Zapisz" class="btn"/>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
