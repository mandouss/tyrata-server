package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import tools.*;
import models.*;
import java.sql.*;

/**
 * Servlet implementation class XmlAction
 * Author : Zizhao Fang
 */

@WebServlet("/XmlAction")
public class XmlAction extends HttpServlet {  // JDK 1.6 and above only

	// The doGet() runs once per HTTP GET request to this servlet.
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       String DB_URL = "jdbc:mysql://localhost:3306/Tyrata";
       final String USER = "mynewuser";
       final String PASS = "passw0rd";
       
       String xml_data = request.getParameter("xml_data");
       //LogRecorder.recordLog(xml_data, "/home/vcm/Tyrata.log");  // PERMISSION DENIED
       Message msg = new Message();
       msg = XmlParser.doParse(xml_data);
       User u = new User();
       u = msg.getUser();
       Connection conn = null;
       try{
           // register JDBC 
           Class.forName(JDBC_DRIVER);
           System.out.println("connect db");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);
           Inserter.insertUser(u);
           out.println( "<h1>User addition "+ u.getemail() + " </h1>" );
           //LogRecorder.recordLog("insert to database successfully", "/home/vcm/Tyrata.log");// PERMISSION DENIED
       }catch(SQLException se){
           se.printStackTrace();
       }catch(Exception e){
           e.printStackTrace();
       }
       
	}
	   
	   
	  
    
}
