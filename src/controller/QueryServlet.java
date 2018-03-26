package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class QueryServlet\
 * Author : Zizhao Fang
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {  // JDK 1.6 and above only
//To save as "<TOMCAT_HOME>\webapps\hello\WEB-INF\classes\QueryServlet.java".
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
	                String sqlStr = "select * from books where author = "
			    + "'" + request.getParameter("author") + "'"
			    + " and qty > 0 order by price desc";

			// Print an HTML page as the output of the query
			out.println("<html><head><title>Query Response</title></head><body>");
			out.println("<h3>Thank you for your query.</h3>");
			out.println("<p>You query is: " + sqlStr + "</p>"); // Echo for debugging
			ResultSet rset = stmt.executeQuery(sqlStr);  // Send the query to the server

			// Step 4: Process the query result set
			int count = 0;
			while(rset.next()) {
			    // Print a paragraph <p>...</p> for each record
			    out.println("<p>" + rset.getString("author")
					+ ", " + rset.getString("title")
					+ ", $" + rset.getDouble("price") + "</p>");
			    count++;
			}
			out.println("<p>==== " + count + " records found =====</p>");
			out.println("</body></html>");
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