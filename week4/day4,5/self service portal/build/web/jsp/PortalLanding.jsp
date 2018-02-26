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
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <style>
        .content{
    margin-top: 215px;
    align-items: center;
    display: flex;
    flex-direction: column;
    }
    #Header{
        display: flex;
        height: 24px;
        flex-direction: row;
        align-items: center;
        width: 100%;
        margin: 0px;
        padding: 15px;
        background-color: #8888ff;
        font-size: 17px;
        color:white;
        margin-top: -10px;
    margin-left: -7px;
    } 
    .right{
        right: 0;
        top: 19px;
        position:absolute;
    }
    .title{
         font-size: 16px;
            flex-grow: 1;
            font-color: #9E9E9El;
    }
    a:link{
            color: white;
    text-decoration: none;
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
    .subheading {
    color: #9E9E9E;
    font-size: 14px;
    float: right;
}
    </style>
    <body>
        <div id="Header">
            Self Service Portal     
            <div class="right title">
                Hi <%=session.getAttribute("fName")%> &nbsp;       
                <a href="/self_service_portal/deactivate">Deactivate Account</a> &nbsp;    
                <a href="/self_service_portal/jsp/logout.jsp">Logout</a>
            </div>
        </div>
                <div class="content">
        <h1>Welcome to service portal</h1>
        <table style="border-spacing: 16px;">
            <tr>
                <td>
                    <div class="subheading" >NAME</div>
                </td>
                <td>
                    <% out.print(session.getAttribute("fName")); %>  <% out.print(session.getAttribute("lName")); %> 
                </td>
            </tr>
            <tr>
                <td class="subheading">EMAIL</td>
                <td> <% out.print(session.getAttribute("email")); %> </td>
            </tr>
            <tr>
                <td class="subheading">
                    Address
                </td>
                <td>
                    <% out.print((session.getAttribute("Address") != null)?
                session.getAttribute("line1")+","+session.getAttribute("line2")+","+session.getAttribute("city")+","+session.getAttribute("state")
                        :"N/A"); %> 
                </td>
            </tr>
        </table>

        
                        <a href="editDetails.jsp"><button class="editbutton">Edit Details</button></a>
        </div>
    <script>
        //var edit_details
    </script>
    </body>
</html>
