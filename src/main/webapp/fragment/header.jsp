
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-inverse">
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown" >
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">${sessionScope.user.firstName}<b class="caret"></b></a>
                <ul class="dropdown-menu" >
                    <li id="user"><a href="/user/profile?id=${sessionScope.user.id}"> profile</a></li>
                    <li><label><input type="checkbox" value="">active</label></li>
                    <li class="divider"></li>
                    <li><a href="/logout">logout</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>