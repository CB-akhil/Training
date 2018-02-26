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
        <link rel="stylesheet" type="text/css" href="/self_service_portal/styles.css">
        <title>Edit Details Page</title>
    </head>
    <style>
         .subheading {
    color: #9E9E9E;
    font-size: 14px;
    float: right;
}
        .content{
    margin-top: 215px;
    align-items: center;
    display: flex;
    flex-direction: column;
    }
        .a{
    font-size: 12px;
    color: #343434 !important;
}
        a:link{
            color: white;
    text-decoration: none;
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
    .row{
    display: flex;
    flex-direction: row;
    align-items: center;
    padding: 8px;
    width: 273px;
}
 .row1{

    flex-direction: row;
    align-items: center;
    padding: 8px;
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
            <h1>Edit Details</h1>
        
            <form action="/self_service_portal/EditAddresss">
                <table>
                    <tr>
                        <td class="subheading">NAME</td>
                        <td >  <input class="row1"   name="fname" type="text" value=<%=session.getAttribute("fName")%>>
                            <input class="row1"  name='lname' type="text" value=<%=session.getAttribute("lName")%>
                        </td>
                    </tr>
                    <tr>
                        <td class="subheading">
                            Email
                        </td>
                        <td>
                            <input class="row" name="email" type="text"   value=<%=session.getAttribute("email")%>>
                        </td>
                    </tr>
                    <tr>
                        <td class="subheading">ADDRESS</td>
                        <td >   <input class="row" type="text" name="addLine1" placeholder="Address line 1"> </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input class="row" type="text" name="addline2" placeholder="Address line 2">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input  class="row1" type="text" name="city" placeholder="city">
                            <select  class="row1" style="height: 33px;width: 142px;" name="State" placeholer="state">
                                 <option value="Tamil Nadu">Tamil-Nadu</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input class="row1" type="text" name="zip" placeholder="zip">
                            <select class="row1" style="height: 33px;width: 142px;" name="Country" plceholder="country">
                                <option value="India">india</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <input  class="editbutton" type="submit" value="save changes">
                <a class="a" href="editDetails.jsp">Discard</a>
            </form>
        </div>
                <script>
                    
                </script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </body>
</html>
