import java.sql.*;
public class GetConnection {
    public static void main(String[] args){
	try{
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("success");
	}catch(ClassNotFoundException e1){
	    System.out.println("cannot find drive");
	    e1.printStackTrace();
	}

	String url="jdbc:mysql://localhost:3306/demodb";
	Connection conn;
	try {
	    conn = DriverManager.getConnection(url,"root","XAFEG-TYRATA-18");
	    Statement stmt = conn.createStatement(); 
	    System.out.print("connect to the db");
	    stmt.close();
	    conn.close();
	} catch (SQLException e){
	    e.printStackTrace();
	}
    }
}
