<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculate Form</title>
    <link rel="stylesheet" href="/media/css/main.css"/>
</head>
<body>
<form:form modelAttribute="pile" method="post">
    <form:errors path="*" cssClass="error"/>
<div>
    <p>UZUPEŁNIJ PARAMETRY PALA:<br/>

    <p>Podaj sygnaturę pala:<br/>
        <input type="text" name="signature"/></p>

    <p>Podaj średnicę pala w metrach: <br/>
        <input type="number" min="0" step="0.1" name="diameter"/></p>

    <p>Podaj wymaganą nośność: <br/>
        <input type="text" name="bearingCapacity"/></p>

    <p>Typ pala: <br/>
        <form:select path="type">
            <form:options items="${type}"/>
        </form:select>

    <p>Obciążenia próbne: <br/>
        <checkbox path="loadTest" value="tak"/> TAK <br/>
        <checkbox path="loadTest" value="nie"/> NIE
    </p>
</div>

<div>

    <p>UZUPEŁNIJ PARAMETRY GRUNTU:<br/>

    <p>Podaj poziom zwierciadła wód gruntowych w metrach: <br/>
        <input type="text" name="zwg"/></p>

    <p>Wybierz wskaźnik zagęszczenia ID: <br/>
        <form:select path="zag">
            <form:options items="${ID}"/>
        </form:select>

</div>

        <input type="submit" value="Zatwierdź" class="btn"/>


</form:form>

</body>
</html>
