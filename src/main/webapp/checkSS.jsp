<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Spring Security Taglibs</title>
</head>
<body>
<sec: authorize access="isAuthenticated()">
    <p>Dla zalogowanego</p>
</sec:>
<sec: authorize access="!isAuthenticated()">
    <p>Dla niezalogowanego</p>
</sec:>
<sec: authorize access="hasRole('ADMIN')">
    <p>Dla zalogowanego z rolą ADMIN </p>
</sec:>
</body>
</html>
