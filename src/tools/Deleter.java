package tools;
import src/tools/Deleter.java;
import java.io.FileNotFoundException;
import java.sql.*;
import models.*;

/**
 * Servlet implementation class Deleter
 * author : @Zizhao @Yiwei
 */

public class Deleter {
    private static Connection conn = null;
    private static void connectDatabase () throws FileNotFoundException {
	    final String USER = "mynewuser";
	    final String PASS = "passw0rd";
	    String DB_URL = "jdbc:mysql://localhost:3306/Tyrata";
	    try {
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        LogRecorder.recordLog("connectDatabase fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
	    }
    }
    
	static boolean deleteTire(Tire t) throws FileNotFoundException {
	    PreparedStatement psmt = null;
	    connectDatabase();
	    try{
		conn.setAutoCommit(false);
		String query = "DELETE FROM TIRE WHERE SENSOR_ID=?";
		psmt = conn.prepareStatement(query);
		psmt.setString(1, t.getSensorid());
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
			LogRecorder.recordLog("deleteTire fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
		    e1.printStackTrace();
		}
		return false;
	    }
		return true;
	}

	static boolean deleteVehicle(Vehicle v ) throws FileNotFoundException {
	    PreparedStatement psmt = null;
	    connectDatabase();
	    try{
		conn.setAutoCommit(false);
		String query = "DELETE FROM VEHICLE WHERE VIN=?";
		psmt = conn.prepareStatement(query);
		psmt.setString(1,v.getVin());
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
			LogRecorder.recordLog("deleteVehicle fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
		    e1.printStackTrace();
		}
		return false;
	    }
		return true;
	}
        
}
