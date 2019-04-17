<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Investition Form</title>
    <link rel="stylesheet" href="/media/css/main.css"/>
</head>
<body>
<p>UZUPEŁNIJ DANE INWESTYCJI:<br/>
<p>Numer projektu:<br/>
    <input type="text" name="investitionSignature"/></p>
<p>Nazwa inwestycji: <br/>
    <input type="text" name="investitionTitle"/></p>
<p>Opis inwestycji: <br/>
    <input type="text" name="description"/></p>
<input type="submit" value="Zapisz" class="btn"/>
</body>
</html>
