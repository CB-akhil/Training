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
        <link rel="stylesheet" type="text/css" href="./styleSheet.css">
        <title>Login</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <style>
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
        .register{
            width: 300px;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 24px 17px;
            text-align: center;
            text-decoration: none;
            text-align: center;
            background: #8888ff;
            color: #FFFFFF;
            font-weight: 600;
            font-size: 12px;
            border-radius: 0px 0px 4px 4px;
        }
        .loginBox{
            width: 300px;
            padding: 16px;
            border-radius: 4px 4px 0px 0px;
            border: 1px solid #AAAAAA;
            background-color: #FDFDFD;
        }
        .error-text{
            width: 300px;
            margin-top: 4px;
            margin-right: 54px;
            text-align: right;
        }
        .textboxline {
                width: 250px;
                padding: 8px;
                border: none;
                border-bottom: 1px solid #727272;
                outline: none;
                background-color: #FDFDFD;
                font-size: 14px;
}
.centre{
    text-align: center;
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
        <div class='loginBox'>
        <h1 class="centre"> Self Service Portal</h1>
        <h3 class="centre">Login</h3>
        <!-- action="/self_service_portal/login" method="post" -->
        <form action="/self_service_portal/login" method="post" > 
            <input name="email" id="email" type='text' placeholder='username' class="textboxline" required><br>
            <input name="pwd" id="passoword"   class="textboxline" placeholder="password" type='password' required>
            <div id="message" class="error-text"></div><br>
            <input id="submit" class="editbutton"  type='submit' value='login'>
        </form>
        <script>
           /* var sub=document.getElementById("submit");
            sub.onclick=function(){
                var request = new XMLHttpRequest();
                request.onreadystatechange=function(){
                    var message = document.getElementById("message");
                    message.innerHTML = response;
                }
                request.open('post','/self_service_portal/login',true);
                request.setRequestHeader('Content-Type', 'application/json');
                var username = document.getElementById('email').value;
                var password = document.getElementById('password').value;
                console.log(username);
                console.log(password);
                request.send(JSON.stringify({email: username, pwd: password}));
            }
            */
           /*$("#submit").click(function (){
            var email = $("#email").val();
            var pass = $("#password").val();
            $.post("/self_service_portal/login", {email: email, pwd: password}, function(res){
                if(res==="SUCCESS"){
                    $(location).attr('href', 'details.jsp');
                }else{
                    $("#message").html(res);
                }
            });
        });*/
        </script>
        </div>
        <a class="register" href="signup.jsp">New around here?</a>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </body>
</html>
