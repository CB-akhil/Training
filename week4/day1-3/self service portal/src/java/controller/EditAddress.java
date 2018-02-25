/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cb-akhil
 */
@WebServlet(name = "EditAddress", urlPatterns = {"/EditAddress"})
public class EditAddress extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditAddress</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session=request.getSession(false);
            session.setAttribute("line1", request.getParameter("addLine1"));
            session.setAttribute("line2", request.getParameter("addLine2"));
            session.setAttribute("city", request.getParameter("city"));
            session.setAttribute("country", request.getParameter("country"));
            session.setAttribute("zip",request.getParameter("zip"));
            try{
                Connection con = DBConnection.getConnection();
                int id = 0;
                String query = "insert into address(line1,line2,city,state,zip,country) valu,es (?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(query,id);
                stmt.setString(1,request.getParameter("addLine1"));
                stmt.setString(2,request.getParameter("addLine2"));
                stmt.setString(3,request.getParameter("city"));
                stmt.setString(5,request.getParameter("country"));
                stmt.setInt(4,Integer.parseInt(request.getParameter("zip")));
                stmt.executeUpdate();
                query="update users set address = ? where email = ?";
                stmt=con.prepareStatement(query);
                stmt.setString(2, (String) request.getSession().getAttribute("email"));
                stmt.setInt(1,id);
                stmt.executeUpdate();
                response.sendRedirect("/");
            }catch(Exception e){
                out.print(e.getMessage());
            }
            out.println("<h1>Servlet EditAddress at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
