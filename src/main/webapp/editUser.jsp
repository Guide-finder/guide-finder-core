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
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery.min.js"></script>--%>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

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
                    <input type="hidden" name="userId" value="${user.id}">
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
                    <div class="form-group">
                        <select name="country" class="form-control" id="country">
                        </select>
                    </div>
                    <div class="form-group">
                        <select name="city" class="form-control" id="city">
                        </select>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-primary btn-block dropdown-toggle" data-toggle="dropdown">Language <b
                                class="caret"></b></a>
                        <ul class="dropdown-menu" id="language"></ul>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-primary btn-block dropdown-toggle" data-toggle="dropdown">Categories <b
                                class="caret"></b></a>
                        <ul class="dropdown-menu" id="categories"></ul>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-primary btn-block dropdown-toggle" data-toggle="dropdown">Roles <b
                                class="caret"></b></a>
                        <ul class="dropdown-menu" id="roles"></ul>
                    </div>
                    <button type="submit" class="btn btn-primary" id="sendBtn">Submit</button>
                </form>
            </div>


        </div>

    </div>
</div>

<%--категории модальное окно****************************************************************************************************--%>
<div id="gridSystemModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="gridModalLabel">Categories</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid bd-example-row">
                    <div class="row" id="data_list">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>


<%--********************************************************************************************************************************************************--%>
<script>
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '/language'
    }).done(function (result) {
        $(result).each(function () {
            $('#language').append('<li><input type="checkbox" class="checkboxLang" name="language" value="' + this.id + '">' + this.name + '</li>');
        })
    });

    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '/saveCategories'
    }).done(function (result) {
        $(result).each(function () {
            $('#categories').append('<li><input type="checkbox" class="checkboxCat" name="categories" value="' + this.id + '">' + this.name +'</li>');
        })
    });

    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '/saveRoles'
    }).done(function (result) {
        $(result).each(function () {
            $('#roles').append('<li><input type="checkbox" class="checkboxRol" name="roles" value="' + this.id + '">' + this.name + '</li>');
        })
    });
    loadCountry();
    loadCity(0);
    $('#country').change(function () {
        loadCity($(this).find(':selected').val())
    });

    function loadCountry() {
        $.ajax({
            type: "GET",
            url: "/location"
        }).done(function (result) {
            $(result).each(function () {
                $("#country").append($('<option>', {
                    value: this.id,
                    text: this.name
                }));
            })
        });
    }


    function loadCity(country) {
        $("#city").children().remove();
        $.ajax({
            type: "GET",
            url: "/location",
            data: "country=" + country
        }).done(function (result) {
            $(result).each(function () {
                $("#city").append($('<option>', {
                    value: this.id,
                    text: this.name
                }));
            })
        });
    }

    $('#sendBtn').on('click', function () {
        var userId = ${user.id};
        var currentCity;
        var currentLanguage = [];
        var currentRole = [];
        var currentCategory = [];

        currentLanguage = $('input:checkbox:checked.checkboxLang').map(function () {
            return this.value;
        }).get();
        currentCategory = $('input:checkbox:checked.checkboxCat').map(function () {
            return this.value;
        }).get();
        currentRole = $('input:checkbox:checked.checkboxRol').map(function () {
            return this.value;
        }).get();
        currentCity = $('#city').find(':selected').val();
        $.ajax({
            type: "GET",
            url: "/toolsEditUser",
            dataType: 'json',
            data: {id: userId, currentLanguage: currentLanguage, currentCity: currentCity, currentRole:currentRole, currentCategory:currentCategory}
        })
    })


</script>

</body>
</html>