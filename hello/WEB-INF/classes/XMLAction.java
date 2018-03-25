// To save as "<TOMCAT_HOME>\webapps\hello\WEB-INF\classes\QueryServlet.java".
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class XMLAction extends HttpServlet {  // JDK 1.6 and above only

    // The doGet() runs once per HTTP GET request to this servlet.
       @Override
       public void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	   // Set the MIME type for the response message
	   response.setContentType("text/html");
	   // Get a output writer to write the response message into the network socket
	   PrintWriter out = response.getWriter();
	   String databaseURL = "jdbc:mysql://localhost:3306/ebookshop?user=tyrata&password=zf29zf29";
	   Connection conn = null;
	   Statement stmt = null;
	   try {
	       // Step 1: Allocate a database Connection object
	       Class.forName("com.mysql.jdbc.Driver");  // Needed for JDK9/Tomcat9
	       conn = DriverManager.getConnection(databaseURL);
	       // conn = DriverManager.getConnection(
	       //				  "jdbc:mysql://localhost:3306/ebookshop?useSSL=false", "tyrata", "zf29zf29"); // <== Check!
	       // database-URL(hostname, port, default database), username, password

	       // Step 2: Allocate a Statement object within the Connection
	       stmt = conn.createStatement();

	       // Step 3: Execute a SQL SELECT query
	                String recStr = request.getParameter("xml_data") ;

			// Print an HTML page as the output of the query
			out.println(recStr);

			// Step 4: Process the query result set
	   } catch (SQLException ex) {
	       ex.printStackTrace();
	   } catch (ClassNotFoundException ex) {
	       ex.printStackTrace();
	   } finally {
	       out.close();  // Close the output writer
	       try {
		   // Step 5: Close the resources
		   if (stmt != null) stmt.close();
		   if (conn != null) conn.close();
	       } catch (SQLException ex) {
		   ex.printStackTrace();
	       }
	   }
       }
}
