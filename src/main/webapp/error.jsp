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
    <%= request.getAttribute("error") %>
</p>

<br>

<button onclick="location.href='main'">
    На главную
</button>

</body>

</html>
