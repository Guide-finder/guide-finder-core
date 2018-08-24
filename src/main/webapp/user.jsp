<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<%--<%--%>
    <%--String firstname = request.getParameter("firstName");--%>
<%--%>--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User menu</title>
    <link rel="stylesheet" href="css/styleAdmin.css">
</head>
<div class="form-box">
    <%--<p>Welcome, <%=firstname%></p>--%>
    <p>Welcome, ${firstName}</p>
</div>
<a href="/logout">logout</a>
</body>
</html>