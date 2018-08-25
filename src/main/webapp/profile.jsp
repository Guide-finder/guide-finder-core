<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>guideFinder</title>

    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%--<script src="http://code.jquery.com/jquery-1.8.3.js"></script>--%>

    <%--<!-- Latest compiled and minified CSS -->--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"--%>
          <%--integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

    <%--<!-- Optional theme -->--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"--%>
          <%--integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>
    <%--<!-- jQuery -->--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery.min.js"></script>--%>
    <%--<!-- Latest compiled and minified JavaScript -->--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"--%>
            <%--integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>

    <style>
        body {
            padding: 0px;
        }
        .name-font{
            font-family: "Agency FB";
            font-size: 20px;
        }
    </style>

</head>
<body>

<!-- Наша шапка -->
<div class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Guide finder</a>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row" align="center">
        <div class="col-sm-4" style="background-color: #ffffff" >
            <br>
            <div>
                <img src="/photo/Default_image.jpg" class="img-circle" alt="Photo">
            </div>
            <br>
                <input type="submit" class="btn btn-primary" align="center" value="START CHAT">
            <br>
            <br>
            <p> ${phone}</p>
            <p> ${mail}</p>

        <ul style="list-style: none">
            <li style="padding-right: 40px"> <a href="${socialcontacts.vk}">Vkontakte</li>
            <li style="padding-right: 40px"> <a href="${socialcontacts.ok}">Odnoklassniki</a></li>
            <li style="padding-right: 40px"> <a href="${socialcontacts.fb}">Facebook</a></li>
            <li style="padding-right: 40px"> <a href="${socialcontacts.tg}">Telegram</a></li>
        </ul>
        </div>
        <div class="col-sm-8 name-font" align="left">
            <br>
            <br>
            <div class="col-sm-4" align="left">${userFirstName}</div>
            <div class="col-sm-6" align="left">${userLastName}</div>
        </div>
        <div class="col-sm-8" align="left">
            <hr>
            ${description}
            <hr>
        </div>

        <div class="col-sm-8" align="left" style="background-color: #ffffff">
            <c:forEach items="${comments}" var="com">
                <p> <span style="font-weight: bold">${com.authorName}</span>${com.message}</p>
            </c:forEach>
        </div>
        <div>

        </div>
        <div class="col-sm-6" style="margin-top: 50px" align="right">

            <input type="submit" class="btn btn-primary" value="Add">
            <input type="submit" class="btn btn-primary" value="Previous">
            <input type="submit" class="btn btn-primary" value="Next">

        </div>
    </div>
    <hr>
</div>
</div>
</body>
</html>
