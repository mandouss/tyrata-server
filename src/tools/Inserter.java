package tools;
import java.io.FileNotFoundException;
import java.sql.*;
import models.*;
/***
 * 
 * 
 * @author aicmez class Inserter
 *
 */

public abstract class Inserter {
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
	public static boolean insertSnapshot(Snapshot ss) throws FileNotFoundException {
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query = "INSERT INTO SNAPSHOT("
		            + "MILEAGE, S11, TIMESTAMP, PRESSURE,"
		            + "OUTLIER, THICKNESS, EOL, TIME_TO_REPLACEMENT,"
		            + "LONGITUDE, LATITUDE, TIRE_ID) VALUES ("
		            + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
			psmt = conn.prepareStatement(query);
			psmt.setDouble(1, ss.getMileage());
			psmt.setDouble(2, ss.getS11());
			psmt.setString(3, ss.getTimestamp());
			psmt.setDouble(4, ss.getPressure());
			psmt.setBoolean(5,  ss.isOutlier());
			psmt.setDouble(6, ss.getThickness());
			psmt.setString(7, ss.getEol());
			psmt.setString(8, ss.getReplacetime()); // TODO
			psmt.setDouble(9, ss.getLongtitude());
			psmt.setDouble(10, ss.getLatitude());
			psmt.setInt(11, ss.getTire_id());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			LogRecorder.recordLog("insertSnapshot fail::::"+ e.getMessage(), "~/Tyrata.log");
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
				psmt.close();
				conn.close();
			} catch (SQLException e1) {
				LogRecorder.recordLog("inserter user fail:::"+ e.getMessage(), "~/Tyrata.log");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		return true;
	}
	public static boolean insertTire(Tire t) throws FileNotFoundException {
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "INSERT INTO TIRE("
		            + "INIT_SS_ID,SENSOR_ID, CUR_SS_ID, MANUFACTURER,"
		            + "MODEL, SKU, AXIS_ROW, AXIS_SIDE, AXIS_INDEX,"
		            + "VEHICLE_ID, INIT_THICKNESS) VALUES ("
		            + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, 0); // TODO: rewrite init_ss_id
			psmt.setString(2, t.getSensorid());
			psmt.setInt(3, 0); // TODO: rewrite cur_ss_id
			psmt.setString(4, t.getManufacturer());
			psmt.setString(5, t.getModel());
			psmt.setString(6, t.getSku());
			psmt.setInt(7,  t.getAxisrow());
			psmt.setString(8, t.getAxisside());
			psmt.setInt(9, t.getAxisindex());
			psmt.setString(10, t.getVin());
			psmt.setDouble(11, t.getInitthickness());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			LogRecorder.recordLog("insertTire fail:::"+ e.getMessage(), "~/Tyrata.log");
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
				psmt.close();
				conn.close();
			} catch (SQLException e1) {
				LogRecorder.recordLog("insertTire fail:::"+ e.getMessage(), "~/Tyrata.log");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		return true;
	}
	public static boolean insertVehicle(Vehicle v) throws FileNotFoundException {
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "INSERT INTO VEHICLE("
		            + "VIN, MAKE, MODEL, YEAR, AXIS_NUM, TIRE_NUM, USER_EMAIL)"
		            + "VALUES (?, ?, ?, ?, ?, ?, ?);";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, v.getVin());
			psmt.setString(2, v.getMake());
			psmt.setString(3, v.getModel());
			psmt.setInt(4, v.getYear());
			psmt.setInt(5, v.getAxis_num());
			psmt.setInt(6, v.getTire_num());
			psmt.setString(7,  v.getEmail());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			LogRecorder.recordLog("insertVehicle fail:::"+ e.getMessage(), "~/Tyrata.log");
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
				psmt.close();
				conn.close();
			} catch (SQLException e1) {
				LogRecorder.recordLog("insertVehicle fail:::"+ e.getMessage(), "~/Tyrata.log");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		return true;
	}
	public static boolean insertUser(User u) throws FileNotFoundException {
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "INSERT INTO USER("
		            + "NAME, EMAIL, PHONE_NUMBER, SALT, HASH)"
		            + "VALUES ( ?, ?, ?, ?, ?);";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, u.getName());
			psmt.setString(2, u.getEmail());
			psmt.setString(3, u.getPhone_num());
			psmt.setString(4, u.getSalt());
			psmt.setString(5, u.getHash());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			LogRecorder.recordLog("insertUser fail:::"+ e.getMessage(), "~/Tyrata.log");
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
				psmt.close();
				conn.close();
			} catch (SQLException e1) {
				LogRecorder.recordLog("insertUser fail:::"+ e.getMessage(), "~/Tyrata.log");
				// TODO Auto-generated catch block
				e1.printStackTrace();
		    }
		    return false;
	    }
	    return true;
	}
	
	public static boolean insertAccident(Accident a) throws FileNotFoundException {
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "INSERT INTO ACCIDENT("
		            + "EMAIL, DESCRIPTION)"
		            + "VALUES (?, ?);";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, a.getEmail());
			psmt.setString(2, a.getDescription());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			LogRecorder.recordLog("insertAccident fail:::"+ e.getMessage(), "~/Tyrata.log");
			// TODO Auto-generated catch block
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
