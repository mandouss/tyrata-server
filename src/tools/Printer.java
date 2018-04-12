package tools;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.*;

/**
 * Servlet implementation class Printer
 * Author : @aicmez & Da Xue & Zizhao Fang
 */

public abstract class Printer {
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
	
	public static String getSalt(String email) {
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
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<Snapshot> getSnapshots(String email) {
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
		    snaphot.setTime_to_replacement(rs.getString("TIME_TO_REPLACEMENT"));
		    snaphot.setLatitude(rs.getDouble("LATITUDE"));
		    snaphot.setLongtitude(rs.getDouble("LONGITUDE"));
		    list.add(snaphot);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	    }catch(SQLException se){
		se.printStackTrace();
	    }catch(Exception e){
		e.printStackTrace();
	    }
	    return null;
	}
	
	public static List<Tire> getTires(String email) {
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
		    tire.setSensor_id(rs.getString("SENSOR_ID"));
		    tire.setManufacturer(rs.getString("MANUFACTURER"));
		    tire.setModel(rs.getString("MODEL"));
		    tire.setSku(rs.getString("SKU"));
		    tire.setVehicle_id(rs.getInt("VEHICLE_ID")) ;
		    tire.setAxis_index(rs.getInt("AXIS_INDEX"));
		    tire.setAxis_side(rs.getString("AXIS_SIDE")); 
		    tire.setAxis_row(rs.getInt("AXIS_ROW"));
		    tire.setInit_ss_id(rs.getInt("INIT_SS_ID"));
		    tire.setInit_thickness(rs.getDouble("INIT_THICKNESS"));
		    tire.setCur_ss_id(rs.getInt("CUR_SS_ID"));
		    list.add(tire);
		}
		rs.close();
		psmt.close();
		conn.close();
		return list;
	    }catch(SQLException se){
		se.printStackTrace();
	    }catch(Exception e){
		e.printStackTrace();
	    }
	    return null;
	}
	
	public static List<Vehicle> getVehicles(String email) {
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
		    v.setUser_id(rs.getInt("USER_ID"));
		    list.add(v);
		}
		rs.close();
		psmt.close();
		conn.close();
		return list;
	    }catch(SQLException se){
		se.printStackTrace();
	    }catch(Exception e){
		e.printStackTrace();
	    }

	    return null;
	}
	
	public static boolean authenticate(String email, String hash) {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	public static User getUser(String email) {
				
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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
