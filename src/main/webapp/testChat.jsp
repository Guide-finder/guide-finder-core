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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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

    <div>
        <input type="text" id="user_id" size="20"/>
        <input type="text" id="user_name" size="50"/>
    </div>
    <div>
        <input type="text" id="user_to_id" size="20"/>
    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">your messages</label>
        <textarea class="form-control" id="message_box" rows="20"></textarea>
    </div>
    <div>
        <input class="form-control form-control-sm" id="message" type="text" placeholder="enter message...">
    </div>
    <div align="center">
        <input type="button" class="btn btn-primary" value="send" onclick="sendMessage()">
    </div>

    <script type="text/javascript">
        var ws;

        $(document).ready(function() {
            init();
        });

        function init() {
            ws = new WebSocket("ws://localhost:8080/chat?user_id=23");

            // ws.on('connect', function () {
            //     ws.send(document.getElementById("user_to_name"));
            // });

            ws.onopen = function (event) {
                alert("Connection is on");
            }
            ws.onmessage = function (event) {
                var $mes_box = document.getElementById("message_box");
                $mes_box.value = $mes_box.value + event.data + "\n";
                alert("Message is recieved");
            }
            ws.onclose = function (event) {
                if (event.wasClean) {
                    alert('Соединение закрыто');
                } else {
                    alert('Обрыв соединения');
                }
                alert('Код: ' + event.code + ' причина: ' + event.reason);
            }
        };

        function sendMessage() {
            alert("sending message...");
            var messageField = document.getElementById("message");
            var userNameField = document.getElementById("user_name");
            var message = userNameField.value + ": " + messageField.value;
            ws.send(message);
            messageField.value = '';
            alert("Message is sended");
        }

        <%--function initSocket() {--%>
            <%--//alert("x init");--%>
            <%--var socket = new WebSocket("ws://localhost:8080/echo?push=TIME");--%>

            <%--socket.onopen = function() {--%>
                <%--alert("Соединение установлено.");--%>
            <%--};--%>

            <%--socket.onclose = function(event) {--%>
                <%--if (event.wasClean) {--%>
                    <%--alert('Соединение закрыто чисто');--%>
                <%--} else {--%>
                    <%--alert('Обрыв соединения'); // например, "убит" процесс сервера--%>
                <%--}--%>
                <%--alert('Код: ' + event.code + ' причина: ' + event.reason);--%>
            <%--};--%>

            <%--socket.onmessage = function(event) {--%>
                <%--document.getElementById("map").innerHTML = "";--%>
                <%--y(event.data);--%>
                <%--//alert(event.data);--%>
            <%--};--%>

            <%--socket.onerror = function(error) {--%>
                <%--alert("Ошибка " + error.message);--%>
            <%--};--%>

        <%--}--%>

        <%--function y(data) {--%>
            <%--alert("y init");--%>
            <%--console.log(data[0]['id']);--%>

            <%--&lt;%&ndash;var coords = <%= coords%>&ndash;%&gt;--%>
            <%--&lt;%&ndash;console.log(JSON.stringify(coords));&ndash;%&gt;--%>


            <%--var obj = JSON.parse(data);--%>

            <%--// console.log(obj);--%>
            <%--// console.log(obj["UserCoordsDto"]["latitude"]);--%>
            <%--// console.log(obj["UserCoordsDto"]["longitude"]);--%>

            <%--ymaps.ready(init);--%>

            <%--function init() {--%>

                <%--//alert("init");--%>

                <%--var myMap = new ymaps.Map('map', {--%>
                    <%--center: [obj[0].latitude, obj[0].longitude], // Нижний Новгород--%>
                    <%--zoom: 13,--%>
                    <%--controls: ['zoomControl']--%>
                <%--});--%>

                <%--for (var i = 0; i < data.length; i++) {--%>
                    <%--//console.log(coords[i].latitude);--%>

                    <%--var myPlacemark = new ymaps.Placemark(--%>
                        <%--// Координаты метки--%>
                        <%--[obj[i].latitude, obj[i].longitude]--%>
                    <%--);--%>

                    <%--myMap.geoObjects.add(myPlacemark);--%>
                <%--}--%>

                <%--var myLocation = new ymaps.Placemark(--%>
                    <%--// Координаты метки--%>
                    <%--[60.67429839472416, 28.51392690887258],--%>
                    <%--{--%>
                        <%--// Свойства--%>
                        <%--// Текст метки--%>
                        <%--iconContent: 'Я'--%>
                    <%--}, {--%>
                        <%--preset: 'islands#redIcon'--%>
                    <%--});--%>

                <%--myMap.geoObjects.add(myLocation);--%>

            <%--}--%>
        <%--}--%>

    </script>

</body>