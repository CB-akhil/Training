package PhoneBook;
import java.sql.*;

/**
 *
 * @author cb-akhil
 */
public class DBConnection {
    static Connection con = null;
    public static Connection getConnection(){
        if(con==null){
            con=DBConnection.createConnection();
        }
        return con;
    }
    static Connection createConnection(){
        String url = "jdbc:mysql://localhost:3306/phonebook"; //MySQL URL and followed by the database name
        String username = "root"; //MySQL username
        String password = ""; //MySQL password
        try{
                try{
                    Class.forName("com.mysql.jdbc.Driver"); //loading mysql driver 
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                } 
                con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
                System.out.println("Printing connection object "+con);
            } catch (Exception e) {
                e.printStackTrace();
        }
        return con; 
    }
}
