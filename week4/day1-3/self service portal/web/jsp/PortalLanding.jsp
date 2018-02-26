<%-- 
    Document   : PortalLanding
    Created on : Feb 22, 2018, 5:33:11 PM
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
        <title>Service Portal</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <div id="Header">
            <h1>Service Portal</h1>
            <div>
                Hi <%=session.getAttribute("fName")%>
                <a href="/self_service_portal/deactivate">Deactivate Account</a>
                <a href="/self_service_portal/jsp/logout.jsp">Logout</a>
            </div>
        </div>
        <h1>Welcome to service portal</h1>
        <h6>Name  <% out.print(session.getAttribute("fName")); %>  <% out.print(session.getAttribute("lName")); %> </h6>
        <h6>Email <% out.print(session.getAttribute("email")); %>  </h6>
        <h6>Address <% out.print((session.getAttribute("Address") != null)?
                session.getAttribute("line1")+","+session.getAttribute("line2")+","+session.getAttribute("city")+","+session.getAttribute("state")
                        :"N/A"); %>  </h6>
        <a href="editDetails.jsp"><button>Edit Details</button></a>
    <script>
        //var edit_details
    </script>
    </body>
</html>
