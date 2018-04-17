package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Snapshot;
import models.Tire;
import models.User;
import models.Vehicle;
import tools.Deleter;
import tools.Inserter;
import tools.Printer;

/**
 * Servlet implementation class ControllerServlet
 * @author aicmez
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try{
            /*out.println("Connected to database!");
            Tire t = new Tire();
            t.setAxisindex(5);
            t.setAxisrow(5);
            t.setAxisside("side booo");
            t.setInitthickness(1.2);
            t.setManufacturer("ARDA");
            t.setModel("BARDA");
            t.setSku("Now");
            t.setVin("HAHEHAHEH");
            t.setSensorid("123arbc");*/
            //Inserter.insertTire(t);
            //Deleter.deleteTire(t);
			List<User> uList = Printer.getAllUsers();
			List<Vehicle> vList = Printer.getVehicles("ALL");
			List<Tire> tList = Printer.getTires("ALL");
			List<Snapshot> sList = Printer.getSnapshots("ALL");
			request.setAttribute("users", uList);
			request.setAttribute("vehicles", vList);
			request.setAttribute("tires", tList);
			request.setAttribute("snapshots", sList);
			RequestDispatcher rd = request.getRequestDispatcher("users.jsp");
			rd.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void init() throws ServletException {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Database including libraries");
			e.printStackTrace();
		}
	}

}
