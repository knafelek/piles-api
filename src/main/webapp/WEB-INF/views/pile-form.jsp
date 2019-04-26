<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
    <title>Pile Form</title>
    <link rel="stylesheet" href="/media/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/media/css/main.css"/>
</head>
<body>
<header>
    <nav class="navbar navbar-light bg-info navbar-expand-lg">

        <a class="navbar-brand" href="http://localhost:8090/home"><img src="/media/images/logo.jpg" width="50" height="50" alt=""> pilesAPI</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainmenu" aria-controls="mainmenu" aria-expanded="false" aria-label="Przełącznik nawigacji">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class = "collapse navbar-collapse" id="mainmenu">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/user"> STRONA GŁÓWNA </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/pile/calculate"> OBLICZENIA </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-expanded="false" id="submenu"> MOJE INWESTYCJE </a>
                    <div class="dropdown-menu" aria-labelledby="submenu" aria-haspopup="true">
                        <a class="dropdown-item" href="/investition/page"> Pokaż wszystkie inwestycje </a>
                        <a class="dropdown-item" href="/investition/form"> Dodaj nową inwestycję </a>
                    </div>
                </li>
                <li class="nav-item dropdown active">
                    <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-expanded="false" id="submenu"> BAZA DANYCH </a>
                    <div class="dropdown-menu" aria-labelledby="submenu" aria-haspopup="true">
                        <a class="dropdown-item" href="/pile/page"> Pokaż tabelę pali </a>
                        <a class="dropdown-item" href="/pile/form"> Zapisz nowy pal </a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"> REJESTRACJA </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"> ZALOGUJ </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout"> WYLOGUJ </a>
                </li>
            </ul>
        </div>

    </nav>
</header>

<div class = "container">
    <form:form modelAttribute="pile" method="post">
        <form:hidden path="id"/>
        <div class="row">
            <div class="col-sm-12">
                <br><h1 align="center">UZUPEŁNIJ PARAMETRY PALA</h1>
                <p>Sygnatura pala:<br/>
                    <form:input path="signature" cssClass="col-4"/> <form:errors path="signature" cssClass="error"/></p>

                <p>Długość pala: <br/>
                    <form:input path="length" type="number" min="4.0" step="0.5" cssClass="col-4"/> <form:errors path="length" cssClass="error"/></p>

                <p>Średnica pala: <br/>
                    <form:input path="diameter" type="number" min="0.1" step="0.1" cssClass="col-4"/> m <form:errors path="diameter" cssClass="error"/></p>

                <p>Wymagana nośność: <br/>
                    <form:input path="bearingCapacity" type="text" cssClass="col-4"/> kN <form:errors path="bearingCapacity" cssClass="error"/></p>

                <p>Inwestycja: <br/>
                <select name="investitionId">
                    <c:forEach items="${allInvestition}" var="inv">
                        <option value="${inv.id}">${inv.investitionSignature}</option>
                    </c:forEach>
                </select>

                <p>Obciążenia próbne: <br/>
                    <input type="checkbox" path="loadTest"/> TAK <br/>

                 <p><input type="submit" value="Zapisz" class="btn"/>
            </div>

        </div>
    </form:form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>