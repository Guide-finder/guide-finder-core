<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maximus
  Date: 20.08.2018
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login form</title>
    <%--<link rel="stylesheet" href="css/style.css">--%>
</head>
<body>

<%--<div class="form-all">
    <h1>Guide Finder. Let's travel</h1>
    <form class="auth-form" action="/AuthFilter" method="POST">
        <div class="form-row">
            <label for="login">Login:</label>
            <input type="text" id="login" name="login"/>
        </div>
        <div class="form-row">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"/>
        </div>
        <div class="clearfix">
            <input type="submit" value="Login"/>
            <input type="button" value="Register"
                   onclick="window.location='registration.jsp';"/>
        </div>
    </form>
</div>--%>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">

    <div class="row" style="margin-top:20px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form class="auth-form" action="/login" method="POST">
                <fieldset>
                    <h2>Please Sign In</h2>
                    <hr class="colorgraph">
                    <div class="form-group">
                        <input type="login" name="login" value="${firstName}" id="login" class="form-control input-lg" placeholder="Login">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
                    </div>
                    <span class="button-checkbox">
					<button type="button" class="btn" data-color="info">Remember Me</button>
                    <input type="checkbox" name="remember_me" id="remember_me" checked="checked" class="hidden">
					<a href="" class="btn btn-link pull-right">Forgot Password?</a>
				    </span>

                    <c:if test="${isRegister}">
                        <div>
                            <p class="btn btn-link pull-center">Registration succesfull, please login.</p>
                        </div>
                    </c:if>
                    <c:if test="${isInvalid}">
                        <div>
                            <p class="btn btn-link pull-center">Login failed. Try again.</p>
                        </div>
                    </c:if>
                    <c:if test="${isInvalidRole}">
                        <div>
                            <p class="btn btn-link pull-center">Role is invalid.</p>
                        </div>
                    </c:if>


                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <a href="/registration" class="btn btn-lg btn-primary btn-block">Register </a>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

</div>

</body>
</html>