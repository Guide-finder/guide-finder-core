
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
<div class="container"><h1>Admin roles edit</h1>
    <br><br><br><br>
</div>
<div class="container" align="center">
    <div class="container">

        <form role="form" class="form-inline" action="/admin/roles" method="POST">

            <label for="newRole">New role</label>
            <input type="text" class="form-control" id="newRole" placeholder="Input new role" name = "newRole">

            <input type="submit" value = "Save role" class="btn btn-success"></input>
        </form>

    </div>
</div>
<div class="container">
    <div class="row">

        <div class="col-md-10">
            <br><br>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thread>
                        <tr class="active">
                            <th>id</th>
                            <th>name</th>
                            <th>Options</th>
                        </tr>
                    </thread>
                    <tbody>
                    <c:forEach items="${roles}" var="role">
                        <tr>
                            <td>${role.id}</td>
                            <td>${role.name}</td>
                            <td align="center">
                                <div class="btn-group">
                                    <a href="/admin/editRole?id=${role.id}"><button type="button" class="btn btn-primary">Edit</button></a>
                                    <a href="/admin/deleteRole?id=${role.id}"><button type="button" class="btn btn-primary">Delete</button></a>
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