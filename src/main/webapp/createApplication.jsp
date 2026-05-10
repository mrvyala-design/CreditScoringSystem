<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Создание заявки</title>
</head>

<body>

<h2>Новая кредитная заявка</h2>

<form action="application" method="post">

    ID клиента: <input type="text" name="clientId"><br><br>

    Сумма кредита: <input type="text" name="amount"><br><br>

    Срок (мес): <input type="text" name="term"><br><br>

    <button type="submit">Отправить заявку</button>

</form>

</body>
</html>
