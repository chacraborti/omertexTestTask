<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inquires</title>
</head>
<body>

<table border=1>
    <thead><tr>
        <th>ID</th>
        <th>Costumer Name</th>
        <th>Description</th>
        <th>Create Date</th>
        <th>Topic</th>
    </tr></thead>
    <c:forEach items="${inquires}" var="inquire">
        <tr>
            <td>${inquire.id}</td>
            <td>${inquire.costumerName}</td>
            <td>${inquire.description}</td>
            <td>${inquire.createDate}</td>
            <td>${inquire.topic.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>