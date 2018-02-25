<%-- 
    Document   : editDetails
    Created on : Feb 22, 2018, 5:13:49 PM
    Author     : cb-akhil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(session.getAttribute("email") ==  null)
        request.getRequestDispatcher("login.jsp").forward(request, response);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
        <title>Edit Details Page</title>
    </head>
    <body>
        <div id="Header">
            <h1>Service Portal</h1>
            <div>
                Hi <%=request.getAttribute("fName") %>
                <a href="/">Deactivate Account</a>
                <a href="logout.jsp">Logout</a>
            </div>
        </div>
        <div>
            <h1>Edit Details</h1>
        
            <form action="/self_service_portal/EditAddresss">
                NAME:<input name="fname" type="text" value=<%=session.getAttribute("fName")%>>
                <input name='lname' type="text" value=<%=session.getAttribute("lName")%>><br>
                Email:<input name="email" type="text"   value=<%=session.getAttribute("email")%>><br>
                Address:<input type="text" name="addLine1"><br>
                <input type="text" name="addline2"><br>
                <input type="text" name="city">
                <select name="State">
                    <option value="Tamil Nadu">Tamil-Nadu</option>
                </select><br>
                <input type="text" name="zip">
                <select name="Country">
                    <option value="India">india</option>
                </select><br>
                <input type="submit" value="save changes">
            </form>
        </div>
                <script>
                    
                </script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </body>
</html>
