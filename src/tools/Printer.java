package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import models.*;

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
	    List<Snapshot> list = new List<Snapshot>();
	    try{
		String sql;
		sql = "SELECT SNAPSHOT.* FROM VEHICLE,TIRE,SNAPSHOT WHERE USER.EMAIL=? and VEHICLE.USER_ID=USER.ID and VEHICLE.ID=TIRE.VEHICLE_ID and SNAPSHOT.TIRE_ID=TIRE.ID";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
		    Snapshot snaphot = new Snapshot();
		    snaphot.id  = rs.getInt("ID");
		    snaphot.s11 = rs.getInt("S11");
		    snaphot.timestamp = rs.getString("TIMESTAMP");
		    double mileage = rs.getDouble("MILEAGE");
		    double pressure = rs.getDouble("PRESSURE");
		    int tire_id = rs.getInt("TIRE_ID");
		    boolean outlier = rs.getBoolean("OUTLIER");
		    double thickness = rs.getDouble("THICKNESS");
		    snaphot.eol = rs.getString("EOL");
		    snaphot.time_to_replacement = rs.getString("TIME_TO_REPLACEMENT");
		    double longtitude = rs.getDouble("LONGITUDE");
		    double latitude = rs.getDouble("LATITUDE");
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
	    List<Tire> list = new List<Tire>();
	    try{
		String sql;
		sql = "SELECT TIRE.* FROM VEHICLE,TIRE,USER WHERE USER.EMAIL=? and VEHICLE.USER_ID=USER.ID and VEHICLE.ID=TIRE.VEHICLE_ID";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);

		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
		    Tire tire = new Tire();
		    tire.id  = rs.getInt("ID");
		    tire.sensor_id = rs.getString("SENSOR_ID");
		    tire.manufacturer = rs.getString("MANUFACTURER");
		    tire.model = rs.getString("MODEL");
		    tire.sku = rs.getString("SKU");
		    tire.vehicle_id = rs.getInt("VEHICLE_ID");
		    tire.axis_index = rs.getInt("AXIS_INDEX");
		    tire.axis_side = rs.getString("AXIS_SIDE");
		    tire.axis_row = rs.getInt("AXIS_ROW");
		    tire.init_ss_id = rs.getInt("INIT_SS_ID");
		    tire.init_thickness = rs.getDouble("INIT_THICKNESS");
		    tire.cur_ss_id = rs.getInt("CUR_SS_ID");
		    list.add(tire);
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
	
	public static List<Vehicle> getVehicles(String email) {
	    PreparedStatement psmt = null;
	    connectDatabase();

	    List<Vehicle> list = new List<Vehicle>();
	    try{
		String sql;
		sql = "SELECT VEHICLE.* FROM VEHICLE,USER WHERE USER.EMAIL=? and USER.ID=VEHICLE.USER_ID";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);

		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
		    Vehicle v = new Vehicle();
		    v.vin = rs.getString("VIN");
		    v.id = rs.getInt("ID");
		    v.make = rs.getString("MAKE");
		    v.model = rs.getString("MODEL");
		    v.year = rs.getInt("YEAR");
		    v.tire_num = rs.getInt("TIRE_NUM");
		    v.axis_num = rs.getInt("AXIS_NUM");
		    v.user_id = rs.getInt("USER_ID");
		    list.add(v);
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
	
	public static boolean authenticate(String email, String hash, String salt) {
		PreparedStatement psmt = null;
		connectDatabase();
		String query= "SELECT SALT FROM USER"
	            + " WHERE EMAIL=? AND HASH=? AND SALT=?;";
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, email);
			psmt.setString(2, hash);
			psmt.setString(3, salt);
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
}
