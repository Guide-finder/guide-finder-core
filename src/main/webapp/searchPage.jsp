<%--
  Created by IntelliJ IDEA.
  User: Diko
  Date: 26.08.2018
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
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
    <script src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
        body {
            padding: 30px;
        }
    </style>
</head>
<body id="test">
<!-- Наша шапка -->
<div class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Guide finder</a>
        </div>
    </div>
</div>
<div class="container"><h1>Search guide</h1></div>
<br><br><br><br>
<%--******************************************************************************************************************--%>
<div class="container">
    <div class="row">
        <form align="center" role="form" class="form-inline" method="POST">
            <div class="col-md-1"></div>
            <div class="col-md-2">
                <select name="country" class="form-control" id="country">
                </select>
            </div>
            <div class="col-md-2">
                <select name="city" class="form-control" id="city">
                </select>
            </div>
            <div class="col-md-2">
                <a class="btn btn-primary btn-block dropdown-toggle" data-toggle="dropdown">Language <b
                        class="caret"></b></a>
                <ul class="dropdown-menu" id="language">
                    <li>
                        <input type="checkbox" class="checkbox" value="1">Russian
                    </li>
                    <li><input type="checkbox" class="checkbox" name="language" value="2">English</li>
                    <li><input type="checkbox" class="checkbox" name="language" value="3">Spanish</li>
                    <li><input type="checkbox" class="checkbox" name="language" value="4">Tarabarskiy</li>
                    <li><input type="checkbox" class="checkbox" name="language" value="5">Java</li>
                </ul>
            </div>
            <div class="col-md-2">
                <div class="bd-example bd-example-padded-bottom">
                    <button type="button" class="btn btn-primary btn-block" data-toggle="modal"
                            data-target="#gridSystemModal" id="myBtn">
                        <span id="nameBtn" class="catBtn">Interests</span>
                    </button>
                </div>
            </div>
            <div class="col-md-2">
                <input type="button" value="Найти" class="btn btn-success btn-block" id="search">
            </div>
        </form>
    </div>
</div>
<br><br>
<%--******************************************************************************************************************--%>
<br><br>
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thread>
                        <tr class="active">
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Options</th>
                        </tr>
                    </thread>
                    <tbody id="user2">
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td align="center">
                                <div class="btn-group">
                                    <a href="/user/profile?id=${user.id}">
                                        <button type="button" class="btn btn-primary">Guide page</button>
                                    </a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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

<script>
    var currentCategory;
    var currentCity;
    var currentLanguage = [];
    var sendArray = [];

    $('#data_list').on('click', '.myClass', function () {
        $('#gridSystemModal').modal('hide');
        document.getElementById('nameBtn').innerHTML = '';
        document.getElementById('data_list').innerHTML = '';
        currentCategory = this.querySelector(".nameCat").textContent;
        $('#nameBtn').append(currentCategory);

//        alert(this.getElementsByClassName('nameCat'));
    });

    $('#search').on('click', function () {
//        $("input:checkbox[name=language]:checked").each(function(){
//            currentLangage.push($(this).val());
//        });
//        currentLanguage.forEach()
//        {
//            alert($(this).val());
//        }
        currentLanguage = $('input:checkbox:checked.checkbox').map(function () {
            return this.value;
        }).get();
        currentCity = $('#city').find(':selected').val();
        currentCategory = document.querySelector(".catBtn").textContent;

        sendArray = [];
        sendArray.push(currentCity, currentCategory, currentLanguage);


        var json = JSON.stringify(sendArray);


        $("#user2").children().remove();

        $.ajax({
            type: 'POST',
            dataType: 'json',
//            data: {json:json},

            data: {currentCity: currentCity, currentCategory: currentCategory, currentLanguage: currentLanguage},
//            data: "json=" + JSON.stringify(sendArray),
            url: '/guideSearch'

        }).done(function (result) {
            $(result).each(function () {
                $("#user2").append('<tr>' + '<td>' + this.firstName + '</td>' + '<td>' + this.lastName + '</td>' + '<td align="center">'
                    + '<div class="btn-group">'
                    + '<a href="/user/profile?id='
                +this.id
                +'">'
                    + '<button type="button" class="btn btn-primary">Guide page</button>'
                + '</a>'
                + '</div>'
                + '</td></tr>')
            })
        });


    });


    $("#myBtn").click(function () {
        $.get("/user/category", function (data) {
            for (var key in data) {               //цикл, который проходится по массиву data
                                                  //добавиьть отображение size
                $('#data_list').append(
                    '<a class="myClass" href="#" style="display: block">'
                    + '<div class="col-md-4">'
                    + '<div class="card mb-4 shadow-sm">'
                    + '<img class="card-img-top" style="height: 225px; width: 100%; display: block;"'
                    + ' src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22534%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20534%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_165544c5def%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A27pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_165544c5def%22%3E%3Crect%20width%3D%22534%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22176.0078125%22%20y%3D%22124.80000000000001%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">'
                    + '<div class="card-body">'
                    + '<p class="card-text nameCat" style="text-align: center">' + data[key]['name'] + '</p>'
                    + '<p class="card-text" style="text-align: left">' + data[key]['description'] + '</p>'
                    + '</div> ' +
                    '</div> ' +
                    '</div>' +
                    '</a>'
                );   //добавляем в список новые элементы
            }
        });
    });
    $('#gridSystemModal').on('hidden.bs.modal', function (e) {
        document.getElementById('data_list').innerHTML = '';
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


</script>

<%--********************************************************************************--%>

</body>