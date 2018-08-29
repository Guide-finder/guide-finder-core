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
    <script src="http://api-maps.yandex.ru/2.1/?load=package.full&lang=ru-RU" type="text/javascript"></script>
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
        .inline-block {
            display: inline-block;
            padding: 0 7px;
        }
        #language {
            padding: 10px 5px;
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
<div id="map" style="width:100%; height:250px "></div>
<br />
<br />
<%--******************************************************************************************************************--%>
<div class="container">
    <div class="row">
        <form align="center" role="form" class="form-inline" method="POST">
            <div class="inline-block">
                <select name="country" class="form-control" id="country">
                </select>
            </div>
            <div class="inline-block">
                <select name="city" class="form-control" id="city">
                </select>
            </div>
            <div class="inline-block" style="width: 110px; position: relative">
                <a class="btn btn-primary btn-block dropdown-toggle" data-toggle="dropdown">Language <b
                        class="caret"></b></a>
                <ul class="dropdown-menu" id="language" style="left: 7px">
                    <li>
                        <input type="checkbox" class="checkbox" value="1">Russian
                    </li>
                    <li><input type="checkbox" class="checkbox" name="language" value="2">English</li>
                    <li><input type="checkbox" class="checkbox" name="language" value="3">Spanish</li>
                    <li><input type="checkbox" class="checkbox" name="language" value="4">Tarabarskiy</li>
                    <li><input type="checkbox" class="checkbox" name="language" value="5">Java</li>
                </ul>
            </div>
            <div class="inline-block">
                <div class="bd-example bd-example-padded-bottom">
                    <button type="button" class="btn btn-primary btn-block" data-toggle="modal"
                            data-target="#gridSystemModal" id="myBtn">
                        <span id="nameBtn" class="catBtn">Interests</span>
                    </button>
                </div>
            </div>
            <div class="inline-block" style="width: 110px">
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
                    + this.id
                    + '">'
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
                    + ' src="' + data[key]['link'] + '" data-holder-rendered="true">'
                    + '<div class="card-body">'
                    + '<br />'
                    + '<p class="card-text nameCat" style="text-align: center; color:#000000; font-weight:bold">' + data[key]['name'] + '</p>'
                    + '<p class="card-text" style="text-align: center">' + data[key]['description'] + '</p>'
                    + '<p><br /></p>'
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
<script>

    window.onload(getCoord());

    function getCoord() {

        document.getElementById("map").innerHTML = "";
        //var me = document.getElementById("me").value;
        //var guide = document.getElementById("guide").value;

        // var url = "/getCoords";
        //
        //
        // var userObj = {
        //     "me": me,
        //     "guide": guide
        // };
        //
        //
        // $.ajax({
        //     url: url,
        //     method: "post",
        //     data: userObj,
        //     error: function (message) {
        //         console.log(message);
        //     },
        //     success: function (data) {
                ymaps.ready(init);

                function init() {

                    //alert("init");

                    var myMap = new ymaps.Map('map', {
                        center: [60.67033840000000, 28.51223280000000],

                        zoom: 11,
                        controls: ['zoomControl']
                    });

                    var myLocation = new ymaps.Placemark(
                        // Координаты метки
                        [60.67033840000000, 28.51223280000000],
                        {
                            // Свойства
                            // Текст метки
                            iconContent: 'Я'
                        }, {
                            preset: 'islands#redIcon'
                        });

                    var guideLocation = new ymaps.Placemark(
                        // Координаты гида
                        [60.63043840000000, 28.55323280000000],
                        {
                            // Свойства
                            iconContent: 'G',
                            balloonContentBody : '<a href="/user/profile?id=2">Oksana Morozova</a>'
                        }, {

                            preset: 'islands#blueIcon'

                        });
                    var guideLocation1 = new ymaps.Placemark(
                        // Координаты гида
                        [60.64243840000000, 28.57323280000000],
                        {
                            // Свойства
                            // Текст метки
                            iconContent: 'G',
                            balloonContentBody : '<a href="/user/profile?id=3">Georgiy Maksimov</a>'
                        }, {

                            preset: 'islands#blueIcon'

                        });
                    var guideLocation2 = new ymaps.Placemark(
                        // Координаты гида
                        [60.63743840000000, 28.51323280000000],
                        {
                            // Свойства
                            // Текст метки
                            iconContent: 'G',
                            balloonContentBody : '<a href="/user/profile?id=4">Aleksandr Rahitov</a>'
                        }, {

                            preset: 'islands#blueIcon'

                        });

                    myMap.geoObjects.add(myLocation);
                    myMap.geoObjects.add(guideLocation);
                    myMap.geoObjects.add(guideLocation1);
                    myMap.geoObjects.add(guideLocation2);
                }
        //     }
        // });
    }
</script>