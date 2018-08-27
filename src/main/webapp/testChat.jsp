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


    <div>
        <label>from_id:</label><input type="text" id="from_id" size="20"/>
        <label>to_id:</label><input type="text" id="to_id" size="20"/>
    </div>
    <div>
        <label>name_from:</label><input type="text" id="user_from_name" size="50"/>
    </div>
    <div align="center">
        <input type="button" class="btn btn-primary" value="connect" onclick="init()">
    </div>

    <div class="form-group">
        <label for="exampleFormControlTextarea1">your messages</label>
        <textarea class="form-control" id="message_box" rows="20"></textarea>
    </div>
    <div>
        <input class="form-control form-control-sm" id="message" type="text" placeholder="enter message...">
    </div>
    <div align="center">
        <input type="button" class="btn btn-primary" value="send" onclick="sendMessage()">
    </div>

    <script type="text/javascript">
        var ws;

        // $(document).ready(function() {
        //     init();
        // });

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
            var from_id = document.getElementById("from_id").value;
            var to_id = document.getElementById("to_id").value;

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
            var userNameField = document.getElementById("user_from_name");
            var message = userNameField.value + ": " + messageField.value;

            var from_id = document.getElementById("from_id").value;
            var to_id = document.getElementById("to_id").value;

            var jsonMess = '{ "from_id": "'+from_id+'", "to_id": "'+to_id+'", "message": "'+message+'" }';

            ws.send(jsonMess);
            messageField.value = '';
            // alert("Message is sended");
        }

    </script>

</body>