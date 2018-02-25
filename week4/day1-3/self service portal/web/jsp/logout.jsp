<%-- 
    Document   : logout
    Created on : Feb 23, 2018, 2:02:07 PM
    Author     : cb-akhil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
           if(request.getSession(false)!=null){ 
               request.getSession(false).invalidate();
               out.print("You have been successfully Loged Out");
           }
           response.sendRedirect("/self_service_portal/");
           //request.getRequestDispatcher("/").forward(request, response);
        %>
        <h1></h1>
    </body>
</html>
