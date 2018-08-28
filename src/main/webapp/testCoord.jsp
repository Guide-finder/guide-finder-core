
Message List
1 new message since 12:32 AM on August 28th


Дмитрий Кудрявцев [3:54 AM]
Untitled
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
​
<html>
<head>
    <script src="http://api-maps.yandex.ru/2.1/?load=package.full&lang=ru-RU" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <% String coords = (String) request.getAttribute("coordList"); %>
    <title>Title</title>
</head>
<body>
​
<div id="map" style="width:600px; height:400px"></div>
​
<button type="button" id="active_geo_button">Button</button>
​
<p id="demo"></p>
​
</body>
​
<script>
    ​
    ​
  $( document ).ready(function() {
  ​
    $('#active_geo_button').on('click', function () {
        alert("test")
​
      var x = document.getElementById("demo");
​
      getLocation();
        showPosition();
​
      function getLocation() {
          if (navigator.geolocation) {
              navigator.geolocation.getCurrentPosition(showPosition);
          } else {
              x.innerHTML = "Geolocation is not supported by this browser.";
          }
      }
​
      function showPosition(position) {
          var lat = position.coords.latitude;
          var lon = position.coords.longitude;
​
        x.innerHTML = "Latitude: " + position.coords.latitude +
            "<br>Longitude: " + position.coords.longitude;
​
      ​
        xt(lat, lon)
      }
​
    ​
    ​
    ​
    });
​
  });
​
    ​
    ​
    ​
  function xt(latitude, longitude) {
      alert("x init " + latitude + " " + longitude);
      var socket = new WebSocket("ws://localhost:8080/echo?latitude=" + latitude + "&longitude=" + longitude);
​
    socket.onopen = function() {
        alert("Соединение установлено.");
    };
​
    socket.onclose = function(event) {
        if (event.wasClean) {
            alert('Соединение закрыто чисто');
        } else {
            alert('Обрыв соединения'); // например, "убит" процесс сервера
        }
        alert('Код: ' + event.code + ' причина: ' + event.reason);
    };
​
    socket.onmessage = function(event) {
        document.getElementById("map").innerHTML = "";
        y(event.data, latitude, longitude);
        //alert(event.data);
    };
​
    socket.onerror = function(error) {
        alert("Ошибка " + error.message);
    };
​
  }
​
  function y(data, latitude, longitude) {
      alert("y init " + latitude + " " + longitude);
      console.log(data[0]['id']);
​
    var obj = JSON.parse(data);
      alert(obj[0].latitude);
​
    ymaps.ready(init);
​
    function init() {
    ​
        //alert("init");
    ​
      var myMap = new ymaps.Map('map', {
          center: [obj[0].latitude, obj[0].longitude],
​
        zoom: 13,
            controls: ['zoomControl']
    });
​
      var myLocation = new ymaps.Placemark(
          // Координаты метки
          [latitude, longitude],
          {
              // Свойства
              // Текст метки
              iconContent: 'Я'
          }, {
              preset: 'islands#redIcon'
          });
​
      myMap.geoObjects.add(myLocation);
​
    ​
    ​
    ​
    ​
    ​
    ​
        // Создаем коллекцию, в которую будем добавлять метки
        myCollection = new ymaps.GeoObjectCollection();
​
      for (var i = 0; i < obj.length; i++) {
          /*        console.log(coords[i].latitude);*/
      ​
        var myPlacemark = new ymaps.Placemark(
            // Координаты метки
            [obj[i].latitude, obj[i].longitude], {
                balloonContentBody: '<a href=/user/profile?id=' + obj[i].id + '>' + obj[i].firstname + ' ' + obj[i].lastname + '</a>\n'
            }
        );
​
        myCollection.add(myPlacemark);
          // myMap.geoObjects.add(myPlacemark);
      }
​
        // Создаем шаблон для отображения контента балуна
        var myBalloonLayout = ymaps.templateLayoutFactory.createClass(
            // '<h3>$[properties.name]</h3>' +
            // '<p><strong>Адрес:</strong> $[properties.address]</p>' +
            '<div align="center"><p align="center"><strong></strong><h3> <a rel="nofollow" href="$[properties.link]" align="center" target="_blank">$[properties.name]</a></h3></p></div>'
        );
​
        // Помещаем созданный шаблон в хранилище шаблонов. Теперь наш шаблон доступен по ключу 'my#theaterlayout'.
        ymaps.layout.storage.add('my#theaterlayout', myBalloonLayout);
​
        // Задаем наш шаблон для балунов геобъектов коллекции.
        myCollection.options.set({
            balloonContentBodyLayout:'my#theaterlayout',
            // Максимальная ширина балуна в пикселах
            balloonMaxWidth: 300
        });
        // Добавление метки на карту
        myMap.geoObjects.add(myCollection);
​
    ​
    ​
    ​
    ​
    ​
    ​
    ​
        /*for (var i = 0; i < data.length; i++) {
  ​
          var myPlacemark = new ymaps.Placemark(
            // Координаты метки гида
            [obj[i].latitude, obj[i].longitude]
          );
  ​
          myMap.geoObjects.add(myPlacemark);
        }*/
    ​
    }
  }
</script>
​
</html>
