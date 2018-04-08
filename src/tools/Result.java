package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import models.*;

public abstract class Result{
    public static String dbToXml(Message m){
	String type = m.getType();
	if(type.equals("User")){
	    return userToXml(m);
	}
	if(type.equals("Vehicle")){
	    return vehicleToXml(m);
   	}
	if(type.equals("Snapshot")){
	    return snapshotToXml(m);
	}
	if(type.equals("Authentication")){
	    return AuthToXml(m);
	}
	if(type == null){
	    //throw exception
	}	
    }

    public static String AuthToXml(Message m){
	String ans;
	ans = "<message><authentication>"
	if(m.getAuthentication().haveHash()){
	    boolean auth = Printer.authenticate(m.getAuthentication().getEmail(),m.getAuthentication().getHash());
	    if(auth){
		ans = ans + "success";
	    }else{
		ans = ans + "failure";
	    }

	}else{
	    ans = ans +	Printer.getSalt(m.getAuthentication().getEmail());
	}
	ans = ans + "</message></authentication>";	    
	}
    }

}
