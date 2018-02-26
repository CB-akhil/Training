<%-- 
    Document   : login.jsp
    Created on : Feb 21, 2018, 4:41:42 PM
    Author     : cb-akhil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>Login</title>
    </head>
    <body>
        <div id="Header">
            
        </div>
        <h1> Self Service Portal</h1>
        <form action="/self_service_portal/login" method="post">
            <input name="email" id="txtEmail" type='text' placeholder='Email' required><br>
            <input name="pwd" type='password' required><br>
            <input type='submit' value='login'>
        </form>
        <!---
        <script>
            $.get('/login',{email:)
        </scr<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>ipt>
        -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <a href="signup.jsp"><button>New around here?</button></a>
    </body>
</html>
