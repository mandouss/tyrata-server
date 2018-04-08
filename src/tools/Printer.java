package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}	//Get salt - Do Authentication - Get email and get the all the vehicle, tire, snapshot
