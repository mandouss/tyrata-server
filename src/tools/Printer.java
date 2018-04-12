package tools;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.*;

/**
 * Servlet implementation class Printer
 * Author : Arda & Da Xue & Zizhao Fang
 */

public abstract class Printer {
	private static Connection conn = null;
	private static void connectDatabase () throws FileNotFoundException {
		final String USER = "mynewuser";
	    final String PASS = "passw0rd";
	    String DB_URL = "jdbc:mysql://localhost:3306/Tyrata";
	    try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			LogRecorder.recordLog("connectDatabase fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
			e.printStackTrace();
		}
	}
	
	public static String getSalt(String email) throws FileNotFoundException {
		PreparedStatement psmt = null;
		connectDatabase();
		String query= "SELECT SALT FROM USER"
	            + " WHERE EMAIL=?;";
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, email);
			psmt.addBatch();
			ResultSet rs = psmt.executeQuery();
			String saltstring = "";
			if (rs.next()) {
				saltstring = rs.getString("SALT");
			}
			conn.close();
			return saltstring;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogRecorder.recordLog("getSalt fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<Snapshot> getSnapshots(String email) throws FileNotFoundException {
	    connectDatabase();
	    PreparedStatement pstmt = null;
	    List<Snapshot> list = new ArrayList<Snapshot>();
	    try{
		String sql;
		sql = "SELECT SNAPSHOT.* FROM VEHICLE,TIRE,SNAPSHOT WHERE USER.EMAIL=? and VEHICLE.USER_ID=USER.ID and VEHICLE.ID=TIRE.VEHICLE_ID and SNAPSHOT.TIRE_ID=TIRE.ID";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		
		ResultSet rs = pstmt.executeQuery(sql);
		while(rs.next()){
		    Snapshot snaphot = new Snapshot();
		    snaphot.setTire_id(rs.getInt("ID"));
		    snaphot.setS11( rs.getInt("S11") );
		    snaphot.setTimestamp(rs.getString("TIMESTAMP")); 
		    snaphot.setMileage(rs.getDouble("MILEAGE"));
		    snaphot.setPressure(rs.getDouble("PRESSURE"));
		    snaphot.setOutlier(rs.getBoolean("OUTLIER"));
		    snaphot.setThickness(rs.getDouble("THICKNESS"));
		    snaphot.setEol(rs.getString("EOL"));
		    snaphot.setReplacetime(rs.getString("TIME_TO_REPLACEMENT"));
		    snaphot.setLatitude(rs.getDouble("LATITUDE"));
		    snaphot.setLongtitude(rs.getDouble("LONGITUDE"));
		    list.add(snaphot);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	    }catch(SQLException se){
	    	LogRecorder.recordLog("insertAccident fail:::"+ se.getMessage(), "/home/vcm/Tyrata.log");
	    	se.printStackTrace();
	    } catch(Exception e) {	    	
	    	LogRecorder.recordLog("insertAccident fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
	    }
	    return null;
	}
	
	public static List<Tire> getTires(String email) throws FileNotFoundException {
	    PreparedStatement psmt = null;
	    connectDatabase();
	    List<Tire> list = new ArrayList<Tire>();
	    try{
		String sql;
		sql = "SELECT TIRE.* FROM VEHICLE,TIRE,USER WHERE USER.EMAIL=? and VEHICLE.USER_ID=USER.ID and VEHICLE.ID=TIRE.VEHICLE_ID";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, email);

		ResultSet rs = psmt.executeQuery(sql);
		while(rs.next()){
		    Tire tire = new Tire();
		    tire.setSensorid(rs.getString("SENSOR_ID"));
		    tire.setManufacturer(rs.getString("MANUFACTURER"));
		    tire.setModel(rs.getString("MODEL"));
		    tire.setSku(rs.getString("SKU"));
		    tire.setVin(rs.getString("VEHICLE_ID")) ;
		    tire.setAxisindex(rs.getInt("AXIS_INDEX"));
		    tire.setAxisside(rs.getString("AXIS_SIDE")); 
		    tire.setAxisrow(rs.getInt("AXIS_ROW"));
		    //tire.setInit_ss_id(rs.getInt("INIT_SS_ID"));
		    tire.setInitthickness(rs.getDouble("INIT_THICKNESS"));
		    //tire.setCur_ss_id(rs.getInt("CUR_SS_ID"));
		    list.add(tire);
		}
		rs.close();
		psmt.close();
		conn.close();
		return list;
	    }catch(SQLException se){
	    	LogRecorder.recordLog("insertAccident fail:::"+ se.getMessage(), "/home/vcm/Tyrata.log");
	    }catch(Exception e){
	    	LogRecorder.recordLog("insertAccident fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
	    }
	    return null;
	}
	
	public static List<Vehicle> getVehicles(String email) throws FileNotFoundException {
	    PreparedStatement psmt = null;
	    connectDatabase();

	    List<Vehicle> list = new ArrayList<Vehicle>();
	    try{
		String sql;
		sql = "SELECT VEHICLE.* FROM VEHICLE,USER WHERE USER.EMAIL=? and USER.ID=VEHICLE.USER_ID";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, email);
		ResultSet rs = psmt.executeQuery(sql);
		while(rs.next()){
		    Vehicle v = new Vehicle();
		    v.setVin(rs.getString("VIN"));	    
		    v.setMake(rs.getString("MAKE"));
		    v.setModel(rs.getString("MODEL"));
		    v.setYear(rs.getInt("YEAR"));
		    v.setTire_num(rs.getInt("TIRE_NUM"));
		    v.setAxis_num(rs.getInt("AXIS_NUM"));
		    v.setEmail(rs.getString("EMAIL"));
		    list.add(v);
		}
		rs.close();
		psmt.close();
		conn.close();
		return list;
	    }catch(SQLException se){
	    	LogRecorder.recordLog("insertAccident fail:::"+ se.getMessage(), "/home/vcm/Tyrata.log");
	    }catch(Exception e){
	    	LogRecorder.recordLog("insertAccident fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
	    }

	    return null;
	}
	
	public static boolean authenticate(String email, String hash) throws FileNotFoundException {
		PreparedStatement psmt = null;
		connectDatabase();
		String query= "SELECT SALT FROM USER"
	            + " WHERE EMAIL=? AND HASH=?;";		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, email);
			psmt.setString(2, hash);
			psmt.addBatch();
			ResultSet rs = psmt.executeQuery();
			boolean is_authenticated = rs.next();
			conn.close();
			return is_authenticated;
		 }catch(SQLException se){
		    	LogRecorder.recordLog("insertAccident fail:::"+ se.getMessage(), "/home/vcm/Tyrata.log");
		    }catch(Exception e){
		    	LogRecorder.recordLog("insertAccident fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
		  }
		return false;
	}


	public static User getUser(String email) throws FileNotFoundException {
				
		try {
			PreparedStatement psmt = null;
			connectDatabase();
			String query= "SELECT * FROM USER"
		            + " WHERE EMAIL=?;";
			User u = new User();
			psmt = conn.prepareStatement(query);
			psmt.setString(1, email);
			psmt.addBatch();
			ResultSet rs = psmt.executeQuery();
			u.setName(rs.getString("NAME"));
			u.setEmail(rs.getString("EMAIL"));
			u.setHash("HASH ");
			u.setPhone_num(rs.getString("PHONE_NUMBER"));
			u.setSalt(rs.getString("SALT"));
			conn.close();
			return u;

		}catch(SQLException se){
	    	LogRecorder.recordLog("insertAccident fail:::"+ se.getMessage(), "/home/vcm/Tyrata.log");
	    }catch(Exception e){
	    	LogRecorder.recordLog("insertAccident fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
	    }
		return null;
	}
}
