<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.12.2016
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistic</title>
    <link rel="stylesheet" type="text/css" href="css/statistic.css">
</head>
<body>

<table style="margin: 0 auto; margin-top: 50px;">
    <tr><td colspan="2" class="alignCenter">Hello, ${name} ${surname}</td></tr>
    <tr><td colspan="2" class="alignCenter">Статистика по запросам</td></tr>
    <tr>
        <td class="names">Ответ:</td>
        <td class="names">Количество:</td>
    </tr>

    <% Map<String, Integer> statistic = (HashMap<String, Integer>) request.getAttribute("statistic"); %>
    <% for(Map.Entry<String, Integer> pair : statistic.entrySet()){
        String key = pair.getKey();
        int value = pair.getValue();
    %>
    <tr>
        <td class="variants"><%=key%></td>
        <td class="values"><%=value%></td>
    </tr>
    <%}%>
    <tr>
        <td colspan="2" class="alignCenter"><a href="\index.html" role="button">Back</a></td>
    </tr>
</table>
</body>
</html>
