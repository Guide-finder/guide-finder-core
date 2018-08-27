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
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery.min.js"></script>--%>
    <script src="script/script.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
    <script src="http://api-maps.yandex.ru/2.0/?load=package.full&lang=ru-RU" type="text/javascript"></script>
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
                        <input type="text" name="phone" class="form-control" id="phone" placeholder="Phone"
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

<%--
                    <button type="button" class="form-control" onclick="getLocation()">Active</button>
--%>

                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1" onchange="getLocation()">
                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>


        </div>

    </div>
</div>

</body>
</html>
