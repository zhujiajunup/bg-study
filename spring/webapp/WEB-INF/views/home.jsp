<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<html>
    <head>
        <title>Spittr</title>
        <link href="<c:url />">
    </head>
    <body>
        <h1>Welcome to Spittr</h1>
        <a href="<c:url value="/spittles"/>">Spittles</a>
        <a href="<c:url value="/spittles/register"/>">Register</a>
    </body>
</html>