
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
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

//@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet {

    public static boolean isEmailValid(String email){
        Pattern pattern= Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");
        return pattern.matcher(email).matches();
    }
    private String message;
    private String password;
    private String email;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            String pwd="";
            email=request.getParameter("email");
            password = request.getParameter("pwd");
            /*if(email.length()==0){
                message="please enter email";
            }else if(!isEmailValid(email))
                message= "enter valid email";
            if(password.length()==0){
                message = "you didn't ener any password";
            }*/
            try{
                Connection con = DBConnection.getConnection();
                String query="select * from users where email=?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1,email);
                ResultSet table = stmt.executeQuery();
                if(table.next()){
                    pwd = table.getString("password");
                }/*else{
                    //message="user doesn't exits";
                    return;
                }*/
                out.println(pwd);
                out.println(request.getParameter("pwd"));
                //out.write(message);
                if(pwd.equals(password)){
                    out.print("password matches");
                    HttpSession session = request.getSession();
                    session.setAttribute("email",request.getParameter("email"));
                    session.setMaxInactiveInterval(30*60);
                    session.setAttribute("fName",table.getString("first_name"));
                    session.setAttribute("lName",table.getString("last_name"));
                    session.setAttribute("address",table.getInt("address"));
                    if(session.getAttribute("address")==null){
                        session.setAttribute("address", "N/A");
                    }else{
                        query="select * from address where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1,email);
                        table = stmt.executeQuery();
                        if(table.next()){
                            session.setAttribute("line1",table.getString("line1"));
                            session.setAttribute("line2",table.getString("line2"));
                            session.setAttribute("city",table.getString("city"));
                            session.setAttribute("state",table.getString("state"));
                            session.setAttribute("zip",table.getInt("zip"));
                        }
                    }
                    request.getRequestDispatcher("/").forward(request,response);
                    //response.sendRedirect("jsp/PortalLanding.jsp");
                }
            }catch(Exception e){
                out.print(e.getMessage());
            }
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<h1>Servlet login failed at " + request.getContextPath() + "</h1>");
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
