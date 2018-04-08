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
        Vehicle v = new Vehicle();
        Tire t = new Tire();
        Snapshot s = new Snapshot();
        
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
            
            v.setId(1);
            v.setAxis_num(4);
            v.setMake("MAKE");
            v.setModel("MODEL");
            v.setTire_num(3);
            v.setUser_id(1);
            v.setYear(2016);
            v.setVin("71223");
            Inserter.insertVehicle(v, conn);
            
            t.setId(1);
            t.setSensor_id("TEST_SENSORID");
            t.setManufacturer("TEST_manufacturer");
            t.setModel("test_model");
            t.setSku("test_sku");
            t.setVehicle_id(1);
            t.setAxis_row(994);
            t.setAxis_side("test_axis_side");
            t.setAxis_index(119);
            t.setInit_ss_id(8888);
            t.setCur_ss_id(0273);
            t.setInit_thickness(44.23);
            Inserter.insertTire(t, conn);
            
            s.setId(1);
            s.setS11(111.22);
            s.setTimestamp("test_timestamp");
            s.setMileage(342.33);
            s.setPressure(732.2);
            s.setTire_id(1);
            s.setOutlier(true);
            s.setThickness(88.123);
            s.setEol("test_eol");
            s.setTime_to_replacement("test_time_replace");
            s.setLongtitude(643.33);
            s.setLatitude(3424.3423);
            Inserter.insertSnapshot(s, conn);
            
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
