<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Результат</title>
</head>

<body>

<h2>Результат скоринга</h2>

<p>
    Сумма: ${result.amount}
</p>

<p>
    Срок: ${result.termMonths}
</p>

<c:choose>

    <c:when test="${result.status == 'APPROVED'}">
        <p style="color: green;">
            Статус: <b>${result.status}</b>
        </p>
    </c:when>

    <c:when test="${result.status == 'REJECTED'}">
        <p style="color: red;">
            Статус: <b>${result.status}</b>
        </p>
    </c:when>

    <c:otherwise>
        <p style="color: orange;">
            Статус: <b>${result.status}</b>
        </p>
    </c:otherwise>

</c:choose>

<br>

<button onclick="location.href='main'">
    На главную
</button>

</body>
</html>