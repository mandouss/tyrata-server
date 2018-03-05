import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LoadDriver {
    public static void main(String[] args) {
        //String databaseURL = "jdbc:mysql://localhost:3306/demodb?user=root&password=XAFEG-TYRATA-18";
        String databaseURL = "jdbc:mysql://localhost:3306/demodb?user=test&password=password";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
	    Class.forName("com.mysql.jdbc.Driver");
	    // Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    
        try {
            conn = DriverManager.getConnection(databaseURL);
            if (conn != null) {
                System.out.println("Connected to the database");
                stmt = conn.createStatement();
                stmt.executeUpdate("DROP TABLE IF EXISTS autoIncTutorial");
                stmt.executeUpdate(
                        "CREATE TABLE autoIncTutorial ("
                        + "priKey INT NOT NULL AUTO_INCREMENT, "
                        + "dataField VARCHAR(64), PRIMARY KEY (priKey))");
            
                //
                // Insert one row that will generate an AUTO INCREMENT
                // key in the 'priKey' field
                //
            
                stmt.executeUpdate(
                        "INSERT INTO autoIncTutorial (dataField) "
                        + "values ('Can I Get the Auto Increment Field?')",
                        Statement.RETURN_GENERATED_KEYS);
                int autoIncKeyFromApi = -1;

                rs = stmt.getGeneratedKeys();
            
                if (rs.next()) {
                    autoIncKeyFromApi = rs.getInt(1);
                } else {
            
                    // throw an exception from here
                }
            
                System.out.println("Key returned from getGeneratedKeys():"
                    + autoIncKeyFromApi);
                
    // or alternatively, if you don't know ahead of time that
    // the query will be a SELECT...

                
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }  finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
