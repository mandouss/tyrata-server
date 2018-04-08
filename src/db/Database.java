package db;

import java.sql.*;

public class Database {
	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/Tyrata";
 
    //db user and password
    static final String USER = "mynewuser";
    static final String PASS = "passw0rd";

    static boolean create(Connection conn,String sql){
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(sql) == 0; 
        }catch (SQLException e) {  
            e.printStackTrace();  
            return false;
        }  
    }

    static boolean insert(Connection conn,String sql){
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(sql) > 0;
        }catch (SQLException e) {  
            e.printStackTrace();  
            return false;
        }  
    }

    ResultSet query(Connection conn,String sql) {  
        ResultSet rs = null;  
        try {  
            Statement stmt = conn.createStatement(); 
            rs = stmt.executeQuery(sql);  
        }catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rs;  
    }  

    static String USER_sql = "CREATE TABLE IF NOT EXISTS USER("
            + "NAME VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci' UNIQUE,"
            + "EMAIL VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "PHONE_NUMBER VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "PRIMARY KEY(EMAIL)"
            + ")charset=utf8;";
    
    static String ACCIDENT_sql = "CREATE TABLE IF NOT EXISTS ACCIDENT("
    		+ "ACC_ID INT(11) NOT NULL AUTO_INCREMENT,"
    		+ "EMAIL VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
    		+ "DESCRIPTION VARCHAR(500) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "PRIMARY KEY(ACC_ID),"
    		+ "FOREIGN KEY(EMAIL) REFERENCES USER(EMAIL) "
            + "ON UPDATE CASCADE ON DELETE RESTRICT"
            + ")charset=utf8;";

    static String VEHICLE_sql = "CREATE TABLE IF NOT EXISTS VEHICLE("
            + "VIN VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci' UNIQUE,"
            + "ID  INT(11) NOT NULL AUTO_INCREMENT,"
      	    + "MAKE VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "MODEL VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "YEAR INT(11) NOT NULL,"
            + "AXIS_NUM INT(11) NOT NULL,"
            + "TIRE_NUM INT(11) NOT NULL,"
            + "USER_EMAIL VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "PRIMARY KEY(ID),"
            + "FOREIGN KEY(USER_EMAIL) REFERENCES USER(EMAIL) "
            + "ON UPDATE CASCADE ON DELETE RESTRICT"
            //+ "CONSTRAINT `VIN_USER_ID_fk_USER_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`USER_ID`)"
            + ")charset=utf8;";

    static String TIRE_sql = "CREATE TABLE IF NOT EXISTS TIRE("
	    + "ID INT(11) NOT NULL AUTO_INCREMENT,"
            + "SENSOR_ID VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci' UNIQUE,"
            + "INIT_SS_ID INT(11) NOT NULL,"
            + "CUR_SS_ID INT(11) NOT NULL,"
            + "MANUFACTURER VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "MODEL VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "SKU VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "AXIS_ROW INT(11) NOT NULL,"
            + "AXIS_SIDE CHAR(20) NOT NULL,"
            + "AXIS_INDEX INT(11) NOT NULL,"
            + "VEHICLE_ID VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "INIT_THICKNESS DOUBLE NOT NULL,"
            + "PRIMARY KEY(ID)"
            //+ "CONSTRAINT `TIRE_VEHICLE_ID_fk_VEHICLE_VIN` FOREIGN KEY (`VEHICLE_ID`) REFERENCES `VEHICLE` (`VIN`)"
            + ")charset=utf8;";

    static String SNAPSHOT_sql = "CREATE TABLE IF NOT EXISTS SNAPSHOT("
            + "ID INT(11) NOT NULL AUTO_INCREMENT,"
            + "MILEAGE DOUBLE NOT NULL,"
            + "S11 DOUBLE NOT NULL,"
            + "TIMESTAMP VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "PRESSURE DOUBLE NOT NULL,"
            + "OUTLIER BOOL NOT NULL,"
            + "THICKNESS DOUBLE NOT NULL,"
            + "EOL VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "TIME_TO_REPLACEMENT VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',"
            + "LONGITUDE DOUBLE NOT NULL,"
            + "LATITUDE DOUBLE NOT NULL,"
            + "TIRE_ID INT(11) NOT NULL,"
            + "PRIMARY KEY(ID)"
            //+ "CONSTRAINT `SNAPSHOT_ID_fk_TIRE_SENSOR_ID` FOREIGN KEY (`TIRE_ID`) REFERENCES `TIRE` (`SENSOR_ID`)"
            + ")charset=utf8;";
 
    public static void main(String[] args) {
        Connection conn = null;
        try{
            // registre JDBC 
            Class.forName("com.mysql.jdbc.Driver");
        
            System.out.println("connect db");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            //create table
            create(conn,USER_sql);
            create(conn,VEHICLE_sql);
            create(conn,TIRE_sql);
            create(conn,SNAPSHOT_sql);
            create(conn, ACCIDENT_sql);
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
