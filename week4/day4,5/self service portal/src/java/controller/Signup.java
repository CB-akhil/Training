
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cb-akhil
 */
public class Signup extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                Connection con = DBConnection.getConnection();
                String query="insert into users(first_name,last_name,email,password) values (?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, request.getParameter("fName"));
                stmt.setString(2, request.getParameter("lname"));
                stmt.setString(3, request.getParameter("email").toLowerCase());
                stmt.setString(4, request.getParameter("pwd"));
                if(stmt.executeUpdate() != 0) {
                    HttpSession session = request.getSession();
                    session.setAttribute("email",request.getParameter("email").toLowerCase());
                    session.setMaxInactiveInterval(30*60);
                    session.setAttribute("fName",request.getParameter("fName"));
                    session.setAttribute("lName",request.getParameter("lname"));
                    session.setAttribute("email",request.getParameter("email"));
                    session.setAttribute("address",null);
                    request.getRequestDispatcher("/").forward(request, response);
                }else{
                    out.print("signup failed");
                }
            }catch(Exception e){
                out.print("signup failed");
                //out.print(e.getMessage());
                
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signup at " + request.getContextPath() + "</h1>");
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
