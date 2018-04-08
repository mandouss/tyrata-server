package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public static boolean authenticate(String email, String hash, String salt) {
		PreparedStatement psmt = null;
		connectDatabase();
		return false;
	}
	
}	//Get salt - Do Authentication - Get email and get the all the vehicle, tire, snapshot
