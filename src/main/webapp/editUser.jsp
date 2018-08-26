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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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

    <script src="js/script.js"></script>

    <style>
        body {
            padding: 30px;
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


<!-- Разбиение колонок -->
<div class="container">
    <h1>Tables</h1>
    <div class="row">
        <div class="col-md-4">

            <!-- Форма с кнопкой и чекбоксом -->
            <div class="container">
                <form action="/editUser" method="post">
                    <input type="hidden" id="userId" name="userId" value="${user.id}">
                    <input type="hidden" id="latitude" name="latitude">
                    <input type="hidden" id="longitude" name="longitude">
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <input type="email" name="email" class="form-control" id="email" placeholder="Email"
                               value="${user.email}">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control" id="password" placeholder="Password"
                               value="${user.password}">
                    </div>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" name="firstname" class="form-control" id="name" placeholder="Enter name"
                               value="${user.firstName}">
                    </div>
                    <div class="form-group">
                        <label for="lastname">Lastname</label>
                        <input type="text" name="lastname" class="form-control" id="lastname" placeholder="Lastname"
                               value="${user.lastName}">
                    </div>
                    <div class="form-group">
                        <label for="age">Age</label>
                        <input type="number" name="age" class="form-control" id="age" placeholder="Age"
                               value="${user.age}">
                    </div>
                    <div class="form-group">
                        <label for="age">Phone</label>
                        <input type="number" name="phone" class="form-control" id="phone" placeholder="Phone"
                               value="${user.phone}">
                    </div>
                    <div class="form-group">
                        <label for="age">Sex</label>

                        <select name="sex" class="form-control" name="sex">
                            <c:forEach items="${sexList}" var="sex">
                                <option value="${sex}" ${sex == sexSelected ? 'selected' : ''}>${sex}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-check">
                        <input onchange="isChecked()" type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Активировать</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>


        </div>

    </div>
</div>

</body>

</html>
