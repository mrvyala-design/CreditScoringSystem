<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
    <title>Ошибка</title>
</head>

<body>

<h2 style="color:red;">
    Ошибка
</h2>

<p>
    ${error}
</p>

<br>

<button onclick="location.href='main'">
    На главную
</button>

</body>

</html>
