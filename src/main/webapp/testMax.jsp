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
<script src="http://api-maps.yandex.ru/2.0/?load=package.full&lang=ru-RU" type="text/javascript"></script>


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
            zoom: 13
        });



        for (var i = 0; i < coords.length; i++) {
            console.log(coords[i].latitude);

            var myPlacemark = new ymaps.Placemark(
                // Координаты метки
                [coords[i].latitude, coords[i].longitude],{
                    name: 'Нижегородский театр «Комедія»',
                    address: 'ул. Грузинская, д. 23',
                    websayt: 'comedia.nnov.ru'

                }
            );

            myMap.geoObjects.add(myPlacemark);
        }

        // Создаем шаблон для отображения контента балуна
        var myBalloonLayout = ymaps.templateLayoutFactory.createClass(
            '<h3>$[properties.name]</h3>' +
            '<p><strong>Адрес:</strong> $[properties.address]</p>' +
            '<p><strong>Веб-сайт:</strong> <a rel="nofollow" href="http://$[properties.websayt]" target="_blank">перейти</a></p>'
        );

        // Помещаем созданный шаблон в хранилище шаблонов. Теперь наш шаблон доступен по ключу 'my#theaterlayout'.
        ymaps.layout.storage.add('my#theaterlayout', myBalloonLayout);

        // Задаем наш шаблон для балунов геобъектов коллекции.
        myCollection.options.set({
            balloonContentBodyLayout:'my#theaterlayout',
            // Максимальная ширина балуна в пикселах
            balloonMaxWidth: 300
        });
        // Добавление метки на карту
    }

</script>


</html>
