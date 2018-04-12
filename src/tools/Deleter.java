package tools;
import models.*;

/**
 * Servlet implementation class Deleter
 * Author : Zizhao Fang & Yiwei Li
 */

public class Deleter {
    private static Connection conn = null;
    private static void connectDatabase () {
	final String USER = "mynewuser";
	final String PASS = "passw0rd";
	String DB_URL = "jdbc:mysql://localhost:3306/Tyrata";
	try {
	    conn = DriverManager.getConnection(DB_URL,USER,PASS);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
	static boolean deleteTire(Tire t) {
	    PreparedStatement psmt = null;
	    connectDatabase();
	    try{
		conn.setAutoCommit(false);
		String query = "DELETE FROM TIRE WHERE SENSOR_ID=?";
		psmt.connprepareStatement(sql);
		psmt.setString(1,t.getSensor_id());
		psmt.addBatch();
		psmt.executeBatch();
		conn.commit();
		conn.close();
	    }catch(SQLException e){
		e.printStackTrace();
		try {
		    conn.rollback();
		    psmt.close();
		    conn.close();
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		return false;
	    }
		return true;
	}

	static boolean deleteVehicle(Vehicle v ) {
	    PreparedStatement psmt = null;
	    connectDatabase();
	    try{
		conn.setAutoCommit(false);
		String query = "DELETE FROM VEHICLE WHERE VIN=?";
		psmt.connprepareStatement(sql);
		psmt.setString(1,v.getVin());
		psmt.addBatch();
		psmt.executeBatch();
		conn.commit();
		conn.close();
	    }catch(SQLException e){
		e.printStackTrace();
		try {
		    conn.rollback();
		    psmt.close();
		    conn.close();
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		return false;
	    }
		return true;
	}
        
}
