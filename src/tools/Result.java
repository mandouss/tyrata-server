package tools;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import models.*;

/**
 * Servlet implementation class Result
 * Author : Yiwei Li & Zizhao Fang
 */
public abstract class Result{
    public static String dbToXml(Message m) throws FileNotFoundException{
		String type = m.getType();
		if(type.equals("User")){
		    return userToXml(m);
		}
		if(type.equals("Authentication")){
		    return AuthToXml(m);
		}
		LogRecorder.recordLog("uer or auth failed", "/home/vcm/Tyrata.log");
		return null;
		
		/*todo
		
		if(type.equals("Vehicle")){
		    return vehicleToXml(m);
	   	}
		if(type.equals("Snapshot")){
		    return snapshotToXml(m);
		}

		if(type == null){
		    //throw exception
		}	
		*/
    }
    
    public static String userToXml(Message m) throws FileNotFoundException {
    	String ans, type;
    	if( Inserter.insertUser(m.getUser()) ) {
    		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
    	} else {
    		type = "<error>This user already exits</error>";
    	}
		ans = "<message>" + type + "</message>";	 
		return ans;
    }
    
    
    public static String AuthToXml(Message m){
		String ans;
		ans = "<message><authentication>";
		if(m.getAuthentication().haveHash()) {
		    boolean auth = Printer.authenticate(m.getAuthentication().getEmail(),m.getAuthentication().getHash());
		    if(auth){
			ans = ans + "success";
		    }else{
			ans = ans + "failure";
		    }
	
		}else{
		    ans = ans +	Printer.getSalt(m.getAuthentication().getEmail());
		}
		
		ans = ans + "</authentication></message>";	 
		return ans;
	
    }
    
    

}
