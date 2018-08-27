<%--
  Created by IntelliJ IDEA.
  User: Polyvianov
  Date: 24.08.18
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
            <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
            <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
            <%--<!--<meta charset="utf-8">-->--%>
            <%--<!--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
            <%--&lt;!&ndash; Tell the browser to be responsive to screen width &ndash;&gt;--%>
            <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
            <%--<meta name="description" content="">--%>
            <%--<meta name="author" content="">-->--%>
            <%--<!-- Favicon icon -->--%>
            <%--<link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">--%>
            <%--<title>Material Pro Admin Template - The Most Complete & Trusted Bootstrap 4 Admin Template</title>--%>
            <%--<!-- Bootstrap Core CSS -->--%>
            <%--<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
            <%--<!-- chartist CSS -->--%>
            <%--<link href="assets/plugins/chartist-js/dist/chartist.min.css" rel="stylesheet">--%>
            <%--<link href="assets/plugins/chartist-js/dist/chartist-init.css" rel="stylesheet">--%>
            <%--<link href="assets/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">--%>
            <%--<!--This page css - Morris CSS -->--%>
            <%--<link href="assets/plugins/c3-master/c3.min.css" rel="stylesheet">--%>
            <%--<!-- Custom CSS -->--%>
            <%--<link href="css/style.css" rel="stylesheet">--%>
            <%--<!-- You can change the theme colors from here -->--%>
            <%--<link href="css/colors/blue.css" id="theme" rel="stylesheet">--%>
            <%--<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->--%>
            <%--<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->--%>
            <%--<!--[if lt IE 9]>--%>
            <%--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>--%>
            <%--<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>--%>
            <%--<![endif]-->--%>
        </head>

        <html>
        <head>
            <title>Title</title>
        </head>
<body>
<jsp:include page="fragment/header.jsp"/>

<form action="/userFilter" method="post">
    <input type="text" name="city">
    <input type="submit">
</form>

<table class="table">
    <thead>
    <tr>
        <th>Automatic Serial number</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>id</th>

    </tr>
    </thead>
    <c:set var="count" value="0" scope="page" />
    <c:forEach items="${users}" var="user">
        <tr>
            <c:set var="count" value="${count + 1}" scope="page"/>
            <td><c:out value="${count}"/></td>
            <td><c:out value="${user.getFirstName()}"/></td>
            <td><c:out value="${user.getLastName()}"/></td>
            <td><a href ="#"><c:out value="${user.getId()}"/></a></td>
        </tr>

    </c:forEach>

</table>

</body>
</html>

