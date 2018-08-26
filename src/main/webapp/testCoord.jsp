<%@ page import="java.util.List" %>
<%@ page import="com.guide_finder.dto.UserCoordsDto" %><%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 24.08.2018
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <script src="http://api-maps.yandex.ru/2.1/?load=package.full&lang=ru-RU" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <% String coords = (String) request.getAttribute("coordList"); %>
    <title>Title</title>
</head>
<body>

<div id="map" style="width:600px; height:400px"></div>

<button type="button" onclick="x()">Button</button>

</body>

<script>

    function x() {
        //alert("x init");
        var socket = new WebSocket("ws://localhost:8080/echo?push=TIME");

        socket.onopen = function() {
            alert("Соединение установлено.");
        };

        socket.onclose = function(event) {
            if (event.wasClean) {
                alert('Соединение закрыто чисто');
            } else {
                alert('Обрыв соединения'); // например, "убит" процесс сервера
            }
            alert('Код: ' + event.code + ' причина: ' + event.reason);
        };

        socket.onmessage = function(event) {
            document.getElementById("map").innerHTML = "";
            y(event.data);
            //alert(event.data);
        };

        socket.onerror = function(error) {
            alert("Ошибка " + error.message);
        };

    }
</script>

<script>

function y(data) {
    alert("y init");
    console.log(data[0]['id']);

    <%--var coords = <%= coords%>--%>
        <%--console.log(JSON.stringify(coords));--%>


    var obj = JSON.parse(data);

    // console.log(obj);
    // console.log(obj["UserCoordsDto"]["latitude"]);
    // console.log(obj["UserCoordsDto"]["longitude"]);

    ymaps.ready(init);

    function init() {

        //alert("init");

        var myMap = new ymaps.Map('map', {
            center: [obj[0].latitude, obj[0].longitude], // Нижний Новгород
            zoom: 13,
            controls: ['zoomControl']
        });

        for (var i = 0; i < data.length; i++) {
            //console.log(coords[i].latitude);

            var myPlacemark = new ymaps.Placemark(
                // Координаты метки
                [obj[i].latitude, obj[i].longitude]
            );

            myMap.geoObjects.add(myPlacemark);
        }

        var myLocation = new ymaps.Placemark(
            // Координаты метки
            [60.67429839472416, 28.51392690887258],
            {
                // Свойства
                // Текст метки
                iconContent: 'Я'
            }, {
                preset: 'islands#redIcon'
            });

        myMap.geoObjects.add(myLocation);

    }
}
</script>

</html>
