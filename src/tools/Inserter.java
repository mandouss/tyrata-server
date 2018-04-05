package tools;
import java.sql.*;
import models.*;
/***
 * 
 * 
 * @author aicmez
 *
 */
public abstract class Inserter {
	
	public static boolean insertSnapshot(Snapshot ss, Connection con) {
		PreparedStatement psmt = null;
		try {
			con.setAutoCommit(false);
			String query = "INSERT INTO SNAPSHOT("
		            + "MILEAGE, S11, TIMESTAMP, MODEL, PRESSURE,"
		            + "OUTLIER, THICKNESS, EOL, TIME_TO_REPLACEMENT,"
		            + "LONG_, LAT, TIRE_ID) VALUES ("
		            + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			psmt = con.prepareStatement(query);
			psmt.setDouble(1, ss.getMileage());
			psmt.setDouble(2, ss.getS11());
			psmt.setString(3, ss.getTimestamp());
			psmt.setString(4, "MODEL HERE");
			psmt.setDouble(5, ss.getPressure());
			psmt.setBoolean(6,  ss.isOutlier());
			psmt.setDouble(7, ss.getThickness());
			psmt.setString(8, ss.getEol());
			psmt.setString(9, ss.getTime_to_replacement());
			psmt.setDouble(10, ss.getLongtitude());
			psmt.setDouble(11, ss.getLatitude());
			psmt.setInt(12, ss.getTire_id());
			psmt.addBatch();
			psmt.executeBatch();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
				psmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		return true;
	}
	public static boolean insertTire(Tire t, Connection con) {
		PreparedStatement psmt = null;
		try {
			con.setAutoCommit(false);
			String query= "INSERT INTO TIRE("
		            + "INIT_SS_ID, CUR_SS_ID, MANUFACTURER,"
		            + "MODEL, SKU, AXIS_ROW, AXIS_SIDE, AXIS_INDEX,"
		            + "VEHICLE_ID) VALUES ("
		            + " ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, t.getInit_ss_id());
			psmt.setInt(2, t.getCur_ss_id());
			psmt.setString(3, t.getManufacturer());
			psmt.setString(4, t.getModel());
			psmt.setString(5, t.getSku());
			psmt.setInt(6,  t.getAxis_row());
			psmt.setString(7, t.getAxis_side());
			psmt.setInt(8, t.getAxis_index());
			psmt.setInt(9, t.getVehicle_id());
			psmt.addBatch();
			psmt.executeBatch();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
				psmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		return true;
	}
	public static boolean insertVehicle(Vehicle v, Connection con) {
		PreparedStatement psmt = null;
		try {
			con.setAutoCommit(false);
			String query= "INSERT INTO VEHICLE("
		            + "VIN, MAKE, MODEL, YEAR, AXIS_NUM, TIRE_NUM, USER_ID)"
		            + "VALUES (?, ?, ?, ?, ?, ?, ?);";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, v.getVin());
			psmt.setString(2, v.getMake());
			psmt.setString(3, v.getModel());
			psmt.setInt(4, v.getYear());
			psmt.setInt(5, v.getAxis_num());
			psmt.setInt(6, v.getTire_num());
			psmt.setInt(7,  v.getUser_id());
			psmt.addBatch();
			psmt.executeBatch();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
				psmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		return true;
	}
	public static boolean insertUser(User u, Connection con) {
		PreparedStatement psmt = null;
		try {
			con.setAutoCommit(false);
			String query= "INSERT INTO USER("
		            + "NAME, EMAIL, PHONE_NUMBER)"
		            + "VALUES ( ?, ?, ?);";
			psmt = con.prepareStatement(query);
			psmt.setString(1, u.getName());
			psmt.setString(2, u.getemail());
			psmt.setString(3, u.getPhone_num());
			psmt.addBatch();
			psmt.executeBatch();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
				psmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		return true;
		
	}
}