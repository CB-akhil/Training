package PhoneBook;


import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cb-akhil
 */
@WebServlet(urlPatterns = {"/EditContact"})
public class AddContact extends HttpServlet {
    private String query;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditContact</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                Connection con = DBConnection.getConnection();
                query="insert into address(line1,line2,city,state,zip,country) values (?,?,?,?,?,?);";
                int id=0;
                PreparedStatement stmt = con.prepareStatement(query,id);
                stmt.setString(1, (String) request.getAttribute("addLine1"));
                stmt.setString(1, (String) request.getAttribute("addline2"));
                stmt.setString(3, (String) request.getAttribute("addline2"));
                stmt.setString(4, (String) request.getAttribute("addline2"));
                stmt.setString(6, (String) request.getAttribute("addline2"));
                stmt.setInt(5,Integer.parseInt((String) request.getAttribute("zip")));
                stmt.executeUpdate();
                query="inset into data(name,address1,home,mobile,work) values (?,id,?,?,?);";
                stmt=con.prepareStatement(query);
                stmt.setString(1,request.getAttribute("fName")+" "+request.getAttribute("fName"));
                stmt.setInt(2, (int) request.getAttribute("phone home"));
                stmt.setInt(3, (int) request.getAttribute("phone mobile"));
                stmt.setInt(4, (int) request.getAttribute("phone work"));
                stmt.executeUpdate();
            }catch(Exception e){
                  out.print(e.getMessage());
                  e.printStackTrace(out);
            }
            out.println("<h1>Servlet EditContact at " + request.getContextPath() + "</h1>");
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
