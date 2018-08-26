<%--
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


    <c:out value="${latitude}"></c:out>
    <c:out value="${longitude}"></c:out>


    la <% double latitude = (Double) request.getAttribute("latitude"); %>
    lo <% double longitude = (Double) request.getAttribute("longitude"); %>


    <title>Title</title>

    <c:forEach items="${coord}" var="coord">

        <c:out value="${latitude}"></c:out>
        <c:out value="${longitude}"></c:out>




    </c:forEach>
</head>
<body>


<div id="map" style="width:600px; height:400px"></div>


</body>



<script>

    var latitude =<%= latitude%>
    var longitude =<%= longitude%>





    ymaps.ready(init);

    function init() {



        // Создание экземпляра карты и его привязка к контейнеру с
        // заданным id ("map")
        var myMap = new ymaps.Map('map', {
            // При инициализации карты, обязательно нужно указать
            // ее центр и коэффициент масштабирования
            center: [latitude, longitude], // Нижний Новгород
            zoom: 13
        });

        // Создание метки
        var myGeoObject = new ymaps.GeoObject({
            // Геометрия.
            geometry: {
                // Тип геометрии - точка
                type: "Point",
                // Координаты точки.
                coordinates: [latitude, longitude]
            }
        });

        // Добавление метки на карту
        myMap.geoObjects.add(myGeoObject);

    }

</script>



</html>
