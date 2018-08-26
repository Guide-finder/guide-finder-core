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
<script src="http://api-maps.yandex.ru/2.1/?load=package.full&lang=ru-RU" type="text/javascript"></script>

<html>
<head>
    <% String coords = (String) request.getAttribute("coordList"); %>
    <title>Title</title>


</head>
<body>

<div id="map" style="width:600px; height:400px"></div>

</body>


<script>

    var coords = <%= coords%>

        console.log(JSON.stringify(coords));


    ymaps.ready(init);

    function init() {


        var myMap = new ymaps.Map('map', {
            center: [coords[0].latitude, coords[0].longitude], // Нижний Новгород
            zoom: 13,
            controls: ['zoomControl']
        });



        for (var i = 0; i < coords.length; i++) {
            console.log(coords[i].latitude);

            var myPlacemark = new ymaps.Placemark(
                // Координаты метки
                [coords[i].latitude, coords[i].longitude]
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


        // Добавление метки на карту
    }

</script>


</html>
