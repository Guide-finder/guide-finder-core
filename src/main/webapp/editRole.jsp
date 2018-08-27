<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 22.08.2018
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>guideFinder</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- jQuery -->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>



</head>
<body>

<!-- Наша шапка -->
<jsp:include page="fragment/header.jsp"/>


<!-- Разбиение колонок -->
<div class="container">
    <h1>Role edit</h1>
    <div class="row">
        <div class="col-md-4">

            <!-- Форма с кнопкой и чекбоксом -->
            <div class="container">
                <form action="/admin/editRole" method="post">
                    <input type="hidden" name="roleId" value="${role.id}">


                    <div class="form-group">
                        <label for="name">New name</label>
                        <input type="text" name="name" class="form-control" id="name" placeholder="Enter name" value="${role.name}">
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>

        </div>

    </div>
</div>

</body>
</html>
