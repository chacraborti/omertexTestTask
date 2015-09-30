<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilona
  Date: 26.09.15
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border=1>
    <thead><tr>
        <th>ID</th>
        <th>Name</th>
    </tr></thead>
    <c:forEach items="${topics}" var="topic">
        <tr>
            <td>${topic.id}</td>
            <td>${topic.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
