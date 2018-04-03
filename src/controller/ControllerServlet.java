package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;
import tools.Inserter;
/**
 * Servlet implementation class ControllerServlet
 * Author : Arda Icmez
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControllerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter printWriter  = response.getWriter();
        printWriter.println("<h1>User addition to DB!</h1>");
        User u = new User();
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost:3306/Tyrata";
     
        //db user and password
        final String USER = "mynewuser";
        final String PASS = "passw0rd";
        Connection conn = null;
        try{
            // registre JDBC 
            Class.forName("com.mysql.jdbc.Driver");
        
            System.out.println("connect db");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            u.setemail("blabla");
            u.setName("User bla bla");
            u.setPhone_num("phone");
            Inserter.insertUser(u, conn);
            Vehicle v = new Vehicle();
            v.setAxis_num(4);
            v.setMake("MAKE");
            v.setModel("MODEL");
            v.setTire_num(3);
            v.setUser_id(5);
            v.setYear(2016);
            v.setVin(71223);
            Inserter.insertVehicle(v, conn);
            
            //insert
            //String sql = String.format("INSERT INTO USER(NAME,EMAIL,PHONE_NUMBER) //VALUES('%s','%s','%s')","test","test@126.com","123456");
//            insert(conn,sql);

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
