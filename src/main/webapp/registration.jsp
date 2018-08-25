<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<%--<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">--%>
<%--<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>--%>
<%--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
<!------ Include the above in your HEAD tag ---------->

<form class="form-horizontal" action='/register' method="POST">
    <fieldset>
        <div id="legend">
            <legend class="">Register</legend>
        </div>


        <div class="control-group">
            <!-- E-mail -->
            <label class="control-label" for="email">email</label>
            <div class="controls">
                <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
                <p class="help-block">Please provide your E-mail</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">password</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                <p class="help-block">Password should be at least 4 characters</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Name-->
            <label class="control-label"  for="firstname">firstname</label>
            <div class="controls">
                <input type="text" id="firstname" name="firstname" placeholder="" class="input-xlarge">
                <p class="help-block">Your name</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Name-->
            <label class="control-label"  for="lastname">lastname</label>
            <div class="controls">
                <input type="text" id="lastname" name="lastname" placeholder="" class="input-xlarge">
                <p class="help-block">Your lastname</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Name-->
            <label class="control-label"  for="age">age</label>
            <div class="controls">
                <input type="number" id="age" name="age" placeholder="" class="input-xlarge">
                <p class="help-block">Your age</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Name-->
            <label class="control-label"  for="sex">sex</label>
            <div class="controls">
                <select id="sex" name="sex">
                    <option value="MAN">Мужской</option>
                    <option value="WOMAN">Женский</option>
                </select>
                <p class="help-block">Your sex</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Name-->
            <label class="control-label"  for="phone">phone</label>
            <div class="controls">
                <input type="text" id="phone" name="phone" placeholder="" class="input-xlarge">
                <p class="help-block">Your phone</p>
            </div>
        </div>


        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button type="submit" class="btn btn-success">Register</button>
            </div>
        </div>
    </fieldset>
</form>