<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dto.CreditDecisionDTO" %>
<%@ page import="model.enums.ApplicationStatus" %>

<%
    CreditDecisionDTO result =
            (CreditDecisionDTO) request.getAttribute("result");
%>

<%
    String color = "black";

    if (result.getStatus() == ApplicationStatus.APPROVED) {
        color = "green";
    } else if (result.getStatus() == ApplicationStatus.REJECTED) {
        color = "red";
    } else if (result.getStatus() == ApplicationStatus.MANUAL_REVIEW) {
        color = "orange";
    }
%>

<html>
<head>
    <title>Результат</title>
</head>

<body>

<h2>Результат скоринга</h2>

<p>Сумма: <%= result.getAmount() %>
</p>

<p>Срок: <%= result.getTermMonths() %>
</p>

<p style="color: <%= color %>;">
    Статус: <b><%= result.getStatus() %>
</b>
</p>

<br>

<button onclick="location.href='main'">
    На главную
</button>

</body>
</html>