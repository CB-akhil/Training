import java.sql.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.util.*;
class PhoneDirectory{
    static void loadCsvToDb(Connection conn){
        String query = " insert into data (name,address,mobile,home,work)"
        + " values (?, ?, ?, ?, ?)";
        
        try (
			Reader csvData = new FileReader("./input.csv");
            CSVParser parser = CSVParser.parse(csvData,CSVFormat.RFC4180);
		){
            PreparedStatement preparedStmt = conn.prepareStatement(query);
			//System.out.print("inside try");
			Iterable<CSVRecord> csvRecords = parser.getRecords();
			for(CSVRecord c:csvRecords){
				preparedStmt.setString(1,c.get(0));
				preparedStmt.setString(2,c.get(1));
				int type=Integer.parseInt(c.get(3));
				switch(type){
                    case 1:
                        preparedStmt.setLong(3,Long.parseLong(c.get(2)));
                        preparedStmt.setNull(4,java.sql.Types.INTEGER);
                        preparedStmt.setNull(5,java.sql.Types.INTEGER);
                        break;
                    case 2:
                        preparedStmt.setLong(4,Long.parseLong(c.get(2)));
                        preparedStmt.setNull(3,java.sql.Types.INTEGER);
                        preparedStmt.setNull(5,java.sql.Types.INTEGER);
                        break;
                    case 3:
                        preparedStmt.setLong(5,Long.parseLong(c.get(2)));
                        preparedStmt.setNull(4,java.sql.Types.INTEGER);
                        preparedStmt.setNull(3,java.sql.Types.INTEGER);
                        break;
                    default:
                        System.out.print("Error in Mobile Type");
                }
                preparedStmt.executeUpdate();
			}
            System.out.print("Loaded Sucessfull");
		}catch (Exception e) {
			e.printStackTrace();
            System.out.print(e.getMessage());
		}
    }
    static void search(Connection conn) throws Exception{
        System.out.println("Enter Name to search:");
        Scanner in = new Scanner(System.in);
        String name=in.next();
        String query = " select * form data where name = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1,name);
        int rows = preparedStmt.executeUpdate();
        System.out.println("Rows impacted : " + rows );
        ResultSet rs = preparedStmt.executeQuery(query);
        while(rs.next()){
            //Display values
            System.out.println("name: " + name);
            System.out.println("address: " + rs.getString("address"));
            if(rs.getString("mobile")!=null) System.out.println("address: " + rs.getString("mobile"));
            if(rs.getString("home")!=null) System.out.println("Home: " + rs.getString("home"));
            if(rs.getString("work")!=null) System.out.println("work: " + rs.getString("work"));
        }

    }
    void update(Connection con) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name which you want to update:");
        String name=in.next();
        System.out.print("which Information you want to update:");
        String col=in.next();
        System.out.print("value:");
        String update=in.next();
        String query = "update data set ? = ? where name=?";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,name);
            preparedStmt.setString(2,col);
            preparedStmt.setString(1,update);
            int rows = preparedStmt.executeUpdate();
            System.out.println("Rows impacted : " + rows );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void add(Connection con) throws Exception{
        Scanner in = new Scanner(System.in);
        String name,address,type,mobile;
        name=in.next();
        mobile=in.next();
        address=in.next();
        type=in.next();
        String query= " insert into data (name,address,mobile,home,work)"
        + " values (?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,name);
            preparedStmt.setString(2,address);
            switch(type){
                    case "mobile:":
                        preparedStmt.setString(3,mobile);
                        break;
                    case "home":
                        preparedStmt.setString(4,mobile);
                        break;
                    case "work":
                        preparedStmt.setString(5,mobile);
                        break;
                    default:
                        System.out.print("Error in Mobile Type");
                }
            preparedStmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Connection con;
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/phonebook","root","");   
            Statement stmt=con.createStatement();  
            if(stmt != null){
                System.out.println("connected");
            }  
            //PhoneDirectory.loadCsvToDb(con);
            PhoneDirectory.add(con);
            PhoneDirectory.update(con);
        }catch(Exception e){
                System.out.println(e);
        }
    }
}