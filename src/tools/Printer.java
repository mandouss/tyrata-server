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
		PreparedStatement psmt = null;
		connectDatabase();
		return null;
	}
	
	public static List<Tire> getTires(String email) {
		PreparedStatement psmt = null;
		connectDatabase();
		return null;
	}
	
	public static List<Vehicle> getVehicles(String email) {
		PreparedStatement psmt = null;
		connectDatabase();
		
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
}
