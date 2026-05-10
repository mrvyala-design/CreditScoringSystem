<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.CreditApplication" %>

<%
  CreditApplication result =
          (CreditApplication) request.getAttribute("result");
%>

<%
  String color = "black";

  if (result.getStatus().equals("APPROVED")) {
    color = "green";
  } else if (result.getStatus().equals("REJECTED")) {
    color = "red";
  } else if (result.getStatus().equals("MANUAL")) {
    color = "orange";
  }
%>

<html>
<head>
  <title>Результат</title>
</head>

<body>

<h2>Результат скоринга</h2>

<p>Сумма: <%= result.getAmount() %></p>

<p>Срок: <%= result.getTermMonths() %></p>

<p style="color: <%= color %>;">
  Статус: <b><%= result.getStatus() %></b>
</p>

<br>

<button onclick="location.href='main'">
  На главную
</button>

</body>
</html>