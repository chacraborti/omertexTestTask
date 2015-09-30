<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilona
  Date: 27.09.15
  Time: 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>New inquire</h1>
<%--<c:url var="saveUrl" value="edit?id=${inquireForm.costumerName}" />--%>
<%--<c:url var="postIncuireUrl" value="/customers/${inquireForm.costumerName}/inquires" />--%>
<%--action="/customers/{costumerName}/inquires" modelAttribute="inquireForm"--%>
        <sf:form  method="post" action="/customers/{costumerName}/inquires" modelAttribute="inquireForm" accept-charset="UTF-8">
            Description<br/>
            <sf:input  path="description" name="description" type="text" required="true" /><br/>
            Costumer Name<br/>
            <sf:input  path="costumerName" name="costumerName" type="text" required="true" /><br/>
            </br></br>
            <sf:input path="" type="submit" name="submit_button" value="Confirm"/>
        </sf:form>
</body>
</html>
