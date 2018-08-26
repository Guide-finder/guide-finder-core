<%@ page import="com.guide_finder.model.user.User" %>
<%@ page session="true" language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<%--<%--%>
    <%--String firstname = request.getParameter("firstName");--%>
<%--%>--%>
<% User username = (User) request.getSession().getAttribute("user"); %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User menu</title>
    <link rel="stylesheet" href="css/styleAdmin.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">


            <ul class="nav navbar-nav navbar-right">

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">${user.getFirstName()}<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li id="user"><a href="#">Другое действие</a></li>
                        <li><a href="#">Другое действие</a></li>
                        <li><a href="#">Что-то еще</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Отдельная ссылка</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="form-box">
    <%--<p>Welcome, <%=firstname%></p>--%>
    <p>Welcome, ${firstName}</p>
</div>
<a href="/logout">logout</a>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>