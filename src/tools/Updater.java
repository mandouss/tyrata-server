package tools;
import java.io.FileNotFoundException;
import java.sql.*;
import models.*;
/**
 * Servlet implementation class Updater
 * Author : Weiyu Yan & Zizhao Fang
 * Bug fixer: Zizhao Fang
 */
public class Updater {
	private static Connection conn = null;
	private static void connectDatabase () throws FileNotFoundException {
		final String USER = "mynewuser";
	    final String PASS = "passw0rd";
	    String DB_URL = "jdbc:mysql://localhost:3306/Tyrata";
	    try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			e.printStackTrace();
			LogRecorder.recordLog("updateTire fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
		}
	}
	public static boolean updateTire(Message m) throws FileNotFoundException {
		Tire t = m.getTire();
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "UPDATE TIRE "
					+"SET SENSOR_ID=?, MANUFACTURER=?, MODEL=?, SKU=?, VEHICLE_ID=?, AXIS_ROW=?, AXIS_SIDE=?, AXIS_INDEX=?, INIT_SS_ID=?, CUR_SS_ID=?, INIT_THICKNESS=? "
					+"WHERE SENSOR_ID=? ;";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, t.getSensorid());
			psmt.setString(2, t.getManufacturer());
			psmt.setString(3, t.getModel());
			psmt.setString(4, t.getSku());
			psmt.setString(5, t.getVin());
			psmt.setInt(6,  t.getAxisrow());
			psmt.setString(7, t.getAxisside());
			psmt.setInt(8, t.getAxisindex());
			//psmt.setInt(9, t.getInit_ss_id());
			//psmt.setInt(10, t.getCur_ss_id());
			psmt.setDouble(11, t.getInitthickness());
			psmt.setString(12, m.getOrigial_info());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogRecorder.recordLog("updateTire fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
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
		
	}
	public static boolean updateVehicle(Message m) throws FileNotFoundException {
		Vehicle v = m.getVehicle();
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "UPDATE VEHICLE "
		            + "SET VIN=?, MAKE=?, MODEL=?, YEAR=?, AXIS_NUM=?, TIRE_NUM=?, USER_ID=? "
		            + "WHERE VIN=? ;";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, v.getVin());
			psmt.setString(2, v.getMake());
			psmt.setString(3, v.getModel());
			psmt.setInt(4, v.getYear());
			psmt.setInt(5, v.getAxis_num());
			psmt.setInt(6, v.getTire_num());
			psmt.setString(7, v.getEmail());
			psmt.setString(8, m.getOrigial_info());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogRecorder.recordLog("updateVehicle fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
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
	public static boolean updateUser(Message m) throws FileNotFoundException {
		User u = m.getUser();
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "UPDATE USER "
		            + "SET NAME=?, EMAIL=?, PHONE_NUMBER=?, SALT=?, HASH=? "
		            + "WHERE EMAIL=?;";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, u.getName());
			psmt.setString(2, u.getEmail());
			psmt.setString(3, u.getPhone_num());
			psmt.setString(4, u.getSalt());
			psmt.setString(5, u.getHash());
			psmt.setString(6, m.getOrigial_info());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogRecorder.recordLog("updateUser fail:::"+ e.getMessage(), "/home/vcm/Tyrata.log");
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
