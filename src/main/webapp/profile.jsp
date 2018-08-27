        <!DOCTYPE html>
        <head>
            <meta charset="UTF-8">
            <title>guideFinder</title>

            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

            <script src="http://code.jquery.com/jquery-latest.min.js"></script>

            <%--<script--%>
                    <%--src="https://code.jquery.com/jquery-3.3.1.min.js"--%>
                    <%--integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="--%>
                    <%--crossorigin="anonymous">--%>

            <%--</script>--%>

            <meta name="viewport" content="width=device-width, initial-scale=1">

            <!-- Latest compiled and minified CSS -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
                  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

            <!-- Optional theme -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
                  integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
            <!-- jQuery -->
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
            <!-- Latest compiled and minified JavaScript -->
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

            <style>
                body {
                    padding: 0px;
                }
                .name-font{
                    font-family: "Agency FB";
                    font-size: 20px;
                }
            </style>

        </head>
        <body>

        <!-- Наша шапка -->

        <jsp:include page="fragment/header.jsp"/>

        <div class="container-fluid">

            <input id="sender_id" type="hidden" value="${sessionScope.user.id}">

            <div class="row" align="center">
                <div class="col-sm-4" style="background-color: #ffffff" >
                    <br>
                    <div>
                        <img src="/photo/Default_image.jpg" class="img-circle" alt="Photo">
                    </div>
                    <br>
                    <div class="name-font" >
                        <p> ${phone}</p>
                        <p> ${mail}</p>

                    </div>

                <ul style="list-style: none">
                    <li style="padding-right: 40px"> <a href="${socialcontacts.vk}">Vkontakte</li>
                    <li style="padding-right: 40px"> <a href="${socialcontacts.ok}">Odnoklassniki</a></li>
                    <li style="padding-right: 40px"> <a href="${socialcontacts.fb}">Facebook</a></li>
                    <li style="padding-right: 40px"> <a href="${socialcontacts.tg}">Telegram</a></li>
                </ul>
                </div>
                <div class="col-sm-6 name-font" align="left">
                    <br>
                    <br>
                    <div class="col-sm-2" align="left">${userFirstName}</div>
                    <div class="col-sm-6" align="left">${userLastName}</div>
                </div>
                <div class="col-sm-6 name-font" align="left">
                    <hr>
                    ${description}
                    <hr>
                </div>

                <div id="comment_container" class="col-sm-6" align="left"  style="background-color: #ff3fff">

                </div>
                <div>

                </div>
                <div class="col-sm-6" style="margin-top: 50px" align="right">
                    <input id="hidden_input" type="hidden" >
                    <input id="Comment_field" type="text" size="60">
                    <input id="Add_button" type="submit" class="btn btn-primary" value="Add">
                    <input type="submit" class="btn btn-primary" value="Previous">
                    <input type="submit" class="btn btn-primary" value="Next">

                </div>
            </div>
            <hr>
        </div>
        </div>

        <script>
                $('#Add_button').on('click', function () {
                    let comment = (document).getElementById("Comment_field").value;
                    let senderId = (document).getElementById('sender_id').value;
                    let recipientId = window.location.search.split('id=')[1];

                    let url = "/user/profile";

                    $.ajax({
                        url: url,
                        method: "POST",
                        data: {senderId: senderId, recipientId: recipientId, comment: comment},
                        success: function(data) {
                            $('#comment_container').append('<div>' + data.authorName + ':  ' + data.message + '</div>');
                        },
                        error: function(error) {
                            console.log(error.message);
                        }
                    })
                });

                $(document).ready(function() {
                    let recipientId = window.location.search.split('id=')[1];

                    let url = "/user/comments";

                    $.ajax({
                        url: url,
                        method: "post",
                        data: {recipientId: recipientId},
                    success: function(data) {
                            for(let key in data){
                                $('#comment_container').append('<div class="">' + data[key]['authorName'] + '   ' + data[key]['message'] + '</div>');
                            };
                    },
                    error: function(error) {
                        console.log(error.message);
                    }
                });
            });

        </script>

        </body>
        </html>
