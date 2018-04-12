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

/**
 * Servlet implementation class XmlAction
 * Author : Zizhao Fang
 */

@WebServlet("/XmlAction")
public class XmlAction extends HttpServlet {  

// JDK 1.6 and above only

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// The doGet() runs once per HTTP GET request to this servlet.
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   
	   String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       String xml_data = request.getParameter("xml_data");
       LogRecorder.recordLog(xml_data, "/home/vcm/Tyrata.log");  // PERMISSION DENIED
       Message msg = new Message();
       msg = XmlParser.doParse(xml_data);
 
       
       try{
    	   
           // register JDBC 
           Class.forName(JDBC_DRIVER);
           System.out.println("connect db");
           //Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);        
           out.println(Result.dbToXml(msg));
           LogRecorder.recordLog("insert to database successfully", "/home/vcm/Tyrata.log");// PERMISSION DENIED
       }catch(Exception e){
           e.printStackTrace();
       }
       
	}
	   
	   
	  
    
}
