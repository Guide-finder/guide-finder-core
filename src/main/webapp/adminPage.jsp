<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>guideFinder</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>

<body>
<!-- Наша шапка -->
<jsp:include page="fragment/header.jsp"/>


<div class="container"><h1>Admin page</h1>
    <br><br><br><br>

    <c:if test="${userRole == 'all'}">
        <form align="center" role="form" class="form-inline" action="/admin" method="POST">

            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Input email">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Input password">
            <label for="firstname">First name</label>
            <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Input First name">
            <br><br>
            <label for="lastname">Last name</label>
            <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Input Last name">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="Input phone">
            <input type="submit" value="Save user" class="btn btn-success"></input>
            <br><br>
            <p align="center">All Users</p>
        </form>
    </c:if>


    <c:if test="${userRole == 'user'}">
        <form align="center" role="form" class="form-inline" action="/admin" method="POST">

            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Input email">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Input password">
            <label for="firstname">First name</label>
            <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Input First name">
            <br><br>
            <label for="lastname">Last name</label>
            <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Input Last name">
            <label for="phone">Phone</label>
            <input type="number" class="form-control" id="phone" name="phone" placeholder="Input phone">
            <input type="submit" value="Save user" class="btn btn-success"></input>
            <br><br>
            <p align="center">Guides</p>
        </form>
    </c:if>


    <c:if test="${userRole == 'admin'}">
        <form align="center" role="form" class="form-inline" action="/admin?role=admin" method="POST">

            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Input email">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Input password">
            <label for="firstname">First name</label>
            <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Input First name">
            <br><br>
            <label for="lastname">Last name</label>
            <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Input Last name">
            <label for="phone">Phone</label>
            <input type="number" class="form-control" id="phone" name="phone" placeholder="Input phone">
            <input type="submit" value="Save user" class="btn btn-success"></input>
            <br><br>
            <p align="center">Admins</p>
        </form>
    </c:if>
    <%--<form align="center" role="form" class="form-inline" action="/admin" method="POST">--%>

        <%--<label for="email">Email</label>--%>
        <%--<input type="email" class="form-control" id="email" name="email" placeholder="Input email">--%>
        <%--<label for="password">Password</label>--%>
        <%--<input type="password" class="form-control" id="password" name="password" placeholder="Input password">--%>
        <%--<label for="firstname">First name</label>--%>
        <%--<input type="text" class="form-control" id="firstname" name="firstname" placeholder="Input First name">--%>
        <%--<br><br>--%>
        <%--<label for="lastname">Last name</label>--%>
        <%--<input type="text" class="form-control" id="lastname" name="lastname" placeholder="Input Last name">--%>
        <%--<label for="phone">Phone</label>--%>
        <%--<input type="number" class="form-control" id="phone" name="phone" placeholder="Input phone">--%>
        <%--<input type="submit" value="Save user" class="btn btn-success"></input>--%>
                <%----%>
    <%--</form>--%>
</div>

<div class="container" align="center">
    <div class="container">

        </form>
    </div>
</div>


<div class="container">
    <div class="row">


        <div class="col-md-2">
            <br><br>
            <%--<input type="submit" class="btn btn-primary btn-block" value="Guides">--%>
            <a href="/admin"><button type="button" class="btn btn-primary btn-block">All Users</button></a>
            <br>
            <a href="/admin?role=user"><button type="button" class="btn btn-primary btn-block">Guides</button></a>
            <br>
            <%--<input type="submit" class="btn btn-primary btn-block" value="Stuff">--%>
            <a href="/admin?role=admin"><button type="button" class="btn btn-primary btn-block">Stuff</button></a>
            <br>
            <a href="/admin/roles"><button type="button" class="btn btn-primary btn-block">Edit ROLE</button></a>
        </div>


        <div class="col-md-10">
            <br><br>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thread>
                        <tr class="active">
                            <th>id</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Password</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Options</th>
                        </tr>
                    </thread>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.password}</td>
                            <td>${user.phone}</td>
                            <td>${user.email}</td>
                            <td align="center">
                                <div class="btn-group">
                                    <a href="/editUser?userId=${user.id}"><button type="button" class="btn btn-primary">Edit</button></a>
                                    <a href="/admin/delete?id=${user.id}"><button type="button" class="btn btn-primary">Delete</button></a>
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
</body>