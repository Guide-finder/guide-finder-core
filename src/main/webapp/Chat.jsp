<!DOCTYPE html>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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

    <input id="sender_id" type="hidden" value="${sessionScope.user.id}">
    <input id="recipient_id" type="hidden" value="${user_id}">
    <input id="sender_name" type="hidden" value="${sessionScope.user.firstName}">



    <%--<div>--%>
        <%--<label>from_id:</label><input type="text" id="from_id" size="20"/>--%>
        <%--<label>to_id:</label><input type="text" id="to_id" size="20"/>--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<label>name_from:</label><input type="text" id="user_from_name" size="50"/>--%>
    <%--</div>--%>
    <%--<div align="center">--%>
        <%--<input type="button" class="btn btn-primary" value="connect" onclick="init()">--%>
    <%--</div>--%>

    <div class="form-group" align="center" style="margin-left: 30%; margin-right: 30%">
        <label for="exampleFormControlTextarea1" style="font-size: x-large; color: #337AB7">MESSENGER</label>
        <textarea class="form-control" id="message_box" rows="10" readonly style="font-size: x-large"></textarea>
    </div>
    <div align="center" style="margin-left: 30%; margin-right: 30%">
        <div style="text-align: left; font-size: 40px">
            <p>${sessionScope.user.firstName}</p>
        </div>
        <div style="height: 20px">
            <input class="form-control form-control-sm" id="message" type="text" placeholder="enter message..." style="font-size: large">
        </div>

    </div>
    <div align="center">
        <br>
        <input type="button" class="btn btn-primary btn-lg" value="send" onclick="sendMessage()" style="width: 200pt; height: 50pt; font-size: x-large">
    </div>

    <script type="text/javascript">
        var ws;

        $(document).ready(function() {
            init();
        });

        $("#message").keyup(function(event){
            if(event.keyCode == 13){
                sendMessage();
            }
        });

        // $(document).ready(function() {
        //     $('message').keydown(function(e) {
        //         if(e.keyCode === 13) {
        //             sendMessage();
        //         }
        //     });
        // });

        function init() {
            var from_id = document.getElementById("sender_id").value;
            var to_id = document.getElementById("recipient_id").value;

            ws = new WebSocket("ws://localhost:8080/chat?from_id="  +from_id+ "&to_id=" +to_id);

            // ws.on('connect', function () {
            //     ws.send(document.getElementById("user_to_name"));
            // });

            ws.onopen = function (event) {
                // alert("Connection is on");
            }
            ws.onmessage = function (event) {
                var $mes_box = document.getElementById("message_box");
                $mes_box.value = $mes_box.value + event.data + "\n";
                // alert("Message is recieved");
            }
            ws.onclose = function (event) {
                if (event.wasClean) {
                    alert('Соединение закрыто');
                } else {
                    alert('Обрыв соединения');
                }
                alert('Код: ' + event.code + ' причина: ' + event.reason);
            }
        };

        function sendMessage() {
            // alert("sending message...");
            var messageField = document.getElementById("message");
            var userNameField = document.getElementById("sender_name");
            var message = userNameField.value + ": " + messageField.value;

            var from_id = document.getElementById("sender_id").value;
            var to_id = document.getElementById("recipient_id").value;

            var jsonMess = '{ "from_id": "'+from_id+'", "to_id": "'+to_id+'", "message": "'+message+'" }';

            ws.send(jsonMess);
            messageField.value = '';
            // alert("Message is sended");
        }

    </script>

</body>