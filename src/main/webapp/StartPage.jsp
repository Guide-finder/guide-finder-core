<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maximus
  Date: 20.08.2018
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- Button trigger modal -->

    <div class="container">
        <div class="jumbotron">
            <h1>Guide Finder</h1>
            <p>Find your dream and let's travel ...</p>
        </div>
        <p>This is search panel</p>
        <p>This is categories panel</p>
    </div>


    <%--<h1> Started page. Welcome to our new service!!! Find your dream. Guide Finder. </h1>--%>
    <%--<p>Country id: ${description}</p>--%>

    <c:if test="${!showCat}">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" name = "country" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${description}
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
            </div>
        </div>
    </c:if>


    <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">--%>
        <%--Launch demo modal--%>
    <%--</button>--%>

    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document" data-width="75%">
            <div class="modal-content">
                <form class="select_location" action="/start" method="GET">

                    <div class="modal-header">
                        <!--<h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>-->
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="bs-docs-example">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group">
                                        <label>Страна:</label>
                                        <select class="selectpicker form-control" name="country" data-width="auto">

                                            <c:forEach items="${countries}" var="country" varStatus="status">
                                                <option value="${country.getKey()}">${country.getValue()}</option>
                                            </c:forEach>

                                            <%--<option value="РОССИЯ">РОССИЯ</option>--%>
                                            <%--<option value="Германия">Германия</option>--%>
                                            <%--<option value="Италия">Италия</option>--%>
                                            <%--<option>Уругвай</option>--%>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group">
                                        <label>Регион:</label>
                                        <select class="selectpicker form-control" name="region" data-width="fit">
                                            <option value="Сицилия">Сицилия</option>
                                            <option value="Штат Калифорния">Штат Калифорния</option>
                                            <option value="Московская область">Московская область</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group">
                                        <label>Город:</label>
                                        <select class="selectpicker form-control" name="city" data-width="fit">
                                            <option value="Москва">Москва</option>
                                            <option value="Берлин">Берлин</option>
                                            <option value="Милан">Милан</option>
                                            <option value="Монтевидео">Монтевидео</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="text-center">
                            <!--<input type="submit">-->
                            <button type="submit" class="btn btn-primary">Let's find your guide</button>
                            <!--<button type="button" class="btn btn-primary">Let's travel</button>-->

                        </div>
                        <!--<input type="submit" class="btn btn-lg btn-success btn-block" value="Let's travel">-->
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Скрипт, вызывающий модальное окно после загрузки страницы -->
    <c:if test="${showCat}">
        <script>
            $(document).ready(function() {
                $("#exampleModalCenter").modal('show');
            });
        </script>
    </c:if>

</body>
</html>
