<%-- 
    Document   : signup
    Created on : Feb 21, 2018, 1:50:22 PM
    Author     : cb-akhil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sign up</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <div id="Header">
            
        </div>
        
        <h1>Register To Self Service Portal</h1>
        <form action="/self_service_portal/signup">
            <input name="fName" type='text' placeholder="First name" required>
            <input name="lname" type='text' placeholder="last name" required><br>
            <input name="email" type='text' placeholder="Email" required>
            <input name="cemail" type="text"    placeholder="Confirm email" required><br>
            <input name="pwd" type='password' placeholder="password" required>
            <input name="cpwd" type="text"  placeholder="confirm password" required><br>
            <input type="submit" value='signup'>
        </form>
    </body>
</html>
