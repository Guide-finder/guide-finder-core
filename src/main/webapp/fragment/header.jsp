
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="script/script.js"></script>
<div class="navbar navbar-inverse">
<input type="hidden" id="userId" name="userId" value= ${sessionScope.user.id}>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <div class="navbar-header">
                <a class="navbar-brand" href="/guideSearch">Guide finder</a>
            </div>

        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown" >
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">${sessionScope.user.firstName}<b class="caret"></b></a>
                <ul class="dropdown-menu" >
                    <li id="user"><a href="/user/profile?id=${sessionScope.user.id}"> profile</a></li>
                    <%--<li><label><input type="checkbox" value="">active</label></li>--%>
                    <input type="checkbox" class="form-check-input" id="exampleCheck1" onchange="getLocation()">
                    <label class="form-check-label" for="exampleCheck1">active</label>
                    <li class="divider"></li>
                    <li><a href="/logout">logout</a></li>
                </ul>
            </li>
        </ul>

        <%--<c:set var="isActive" value="${sessionScope.user.id}"/>--%>

        <script>
            $( document ).ready(function() {
                console.log( "ready!" );

                $.ajax({
                    url: "/rest",
                    method: "get",
                    success: function(data) {
                        var checkbox = document.getElementById('exampleCheck1');

                        if (data === 1) {
                            checkbox.checked = true;
                        } else {
                            checkbox.checked = false;
                        }
                    },
                    error: function(error) {
                        console.log(error.message);
                    }
                });
            });





            $(document).on('change', '#exampleCheck1', function() {
                if(this.checked) {
                    console.log( "checked!" );
                    $.ajax({
                        url: "/rest",
                        method: "post",
                        data: {state: 1},
                        success: function(data) {
                        },
                        error: function(error) {
                            console.log(error.message);
                        }
                    });
                } else {
                    if(this.checked) {
                        console.log( "uncheked!" );
                        $.ajax({
                            url: "/rest",
                            method: "post",
                            data: {state: 0},
                            success: function (data) {
                            },
                            error: function (error) {
                                console.log(error.message);
                            }
                        });
                    }
                }
            });


        </script>

    </div>
</div>


