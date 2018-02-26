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
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
    </head>
    <style>
        .row1{

    flex-direction: row;
    align-items: center;
    padding: 14px;
    border-radius: 4px;
    border: 1px solid;
}
.editbutton{
        background-color: #ff6666;
    border: none;
    color: #FFFFFF;
    padding: 16px 40px;
    box-shadow: 0 1px 2px rgba(0,0,0,0.4);
    border-radius: 4px;
    outline: none;
    cursor: pointer;
    font-weight: 600;
    }
    body{
    margin-top: 215px;
    align-items: center;
    display: flex;
    flex-direction: column;
}
    </style>
    <body>
        <div id="Header">
            
        </div>
        
        <h4>Register To</h4><h1> Self Service Portal</h1>
        <form action="/self_service_portal/signup">
            <input  class="row1" name="fName" type='text' placeholder="First name" required>
            <input   class="row1" name="lname" type='text' placeholder="last name" required><br>
            <p></p>
            <input class="row1" name="email" type='text' placeholder="Email" required>
            <input class="row1" name="cemail" type="text"    placeholder="Confirm email" required><br>
            <p></p>
            <input class="row1" name="pwd" type='password' placeholder="password" required>
            <input class="row1" name="cpwd" type="text"  placeholder="confirm password" required><br>
            <p></p>
            <input class="editbutton" style="margin-left: 100px" type="submit" value='signup'><br>
            <a href="login.jsp" style="margin-left: 100px;font-size: 12px">already have an account</a>
        </form>
    </body>
</html>
