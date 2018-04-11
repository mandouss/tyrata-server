package tools;

public class Updater {
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
	public static boolean updateTire(Tire t) {
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "UPDATE TIRE "
					+" SET SENSOR_ID=?, MANUFACTURER=?, MODEL=?, SKU=?, VEHICLE_ID=?, AXIS_ROW=?, AXIS_SIDE=?, AXIS_INDEX=?, INIT_SS_ID=?, CUR_SS_ID=?, INIT_THICKNESS=? "
					+" WHERE ID=? ;";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, t.getSensor_id());
			psmt.setString(2, t.getManufacturer());
			psmt.setString(3, t.getModel());
			psmt.setString(4, t.getSku());
			psmt.setInt(5, t.getVehicle_id());
			psmt.setInt(6,  t.getAxis_row());
			psmt.setString(7, t.getAxis_side());
			psmt.setInt(8, t.getAxis_index());
			psmt.setInt(9, t.getInit_ss_id());
			psmt.setInt(10, t.getCur_ss_id());
			psmt.setDouble(11, t.getInit_thickness());
			psmt.setInt(12, t.getId());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
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
	public static boolean updateVehicle(Vehicle v) {
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "UPDATE VEHICLE "
		            + " SET VIN=?, MAKE=?, MODEL=?, YEAR=?, AXIS_NUM=?, TIRE_NUM=?, USER_ID=? "
		            + " WHERE ID=? ;";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, v.getVin());
			psmt.setString(2, v.getMake());
			psmt.setString(3, v.getModel());
			psmt.setInt(4, v.getYear());
			psmt.setInt(5, v.getAxis_num());
			psmt.setInt(6, v.getTire_num());
			psmt.setInt(7, v.getUser_id());
			psmt.setInt(8, v.getId());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
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
	public static boolean insertUser(User u) {
		PreparedStatement psmt = null;
		connectDatabase();
		try {
			conn.setAutoCommit(false);
			String query= "UPDATE USER SET "
		            + "NAME=?, EMAIL=?, PHONE_NUMBER=?, SALT=?, HASH=? "
		            + "WHERE ID=?;";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, u.getName());
			psmt.setString(2, u.getEmail());
			psmt.setString(3, u.getPhone_num());
			psmt.setString(4, u.getSalt());
			psmt.setString(5, u.getHash());
			psmt.setInt(6, u.getId());
			psmt.addBatch();
			psmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
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
