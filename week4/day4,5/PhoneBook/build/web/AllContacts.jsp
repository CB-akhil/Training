
<%-- 
    Document   : AllContacts
    Created on : Feb 26, 2018, 2:19:08 PM
    Author     : cb-akhil
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="PhoneBook.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    ResultSet rs=null;
    try{
    Connection con=DBConnection.getConnection();
    String query="select * from data";
    rs=con.prepareStatement(query).executeQuery();
    }catch(Exception e){
        out.println("exception cought");
        out.println(e.getMessage());
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .theader{
            background-color: slateblue !important;
    border-radius: 8px;
        }
        tr,th,td,h3{
            padding: 16px;
        }
        tr:nth-child(even) {background: #CCC}
tr:nth-child(odd) {background: #FFF}
#Header{
        display: flex;
        height: 24px;
        flex-direction: row;
        //align-items: center;
        width: 100%;
        margin: 0px;
        padding: 15px;
        background-color: mediumseagreen;
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
    a{
        color: white;
        text-decoration: none;
    }
    </style>
    <body>
        <div id="Header">
            Phone Book     
            <div class="right title">
                <a href="AllContacts.jsp">All Contacts</a> &nbsp;
                <a href="/self_service_portal/jsp/logout.jsp">Logout</a>
            </div>
        </div>
        <h3 style="margin-left: 33px;">All Contacts</h3>
        <table style="border-collapse: collapse;margin-left: 50px;">
            <thead>
            <tr class="theader">
                <th >NAME</th>
                <th >ADDRESS</th>
                <th colspan="3" style="text-align: left">PHONE</th>
            </tr>      
            </thead>
            <tbody>
    <%
        String query;
 
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>");
                out.println(rs.getString("name"));
                out.println("</td>");
                out.println("<td>");
                if(rs.getString("address1")!=null){
                    try{
                        query="select * from address where id=?";
                        Connection con = DBConnection.getConnection();
                        PreparedStatement stmt =con.prepareStatement(query);
                        stmt.setInt(1,rs.getInt("address1"));
                        ResultSet irs=stmt.executeQuery();
                        while(irs.next()){
                            out.println(irs.getString("line1")+", "+irs.getString("line2")+", "+irs.getString("city")+", "+irs.getString("state")+", "+irs.getString("country")+", "+irs.getInt("zip")+".");
                        }
                    }catch(Exception e){
                        out.print(e.getMessage());
                    }
                }else{
                    out.print("N/A");
                }
                out.println("</td>");
                out.println("<td>");
                out.println(rs.getLong("mobile") + "(Mobile)");
                out.println("</td>");
                out.println("<td>");
                out.println(rs.getLong("home") + "(Home)");
                out.println("</td>");
                out.println("<td>");
                out.println(rs.getLong("work") + "(Work)");
                out.println("</td>");
                out.print("</tr>");
            }
    %>
       </tbody>
        </table>
    </body>
</html>
