package tools;
import java.io.FileNotFoundException;
import models.*;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;


/**
 * Servlet implementation class Result
 * Author : Yiwei Li & Zizhao Fang
 */
public abstract class Result{
    public static String dbToXml(Message m) throws FileNotFoundException, JAXBException{
	String type = m.getType();
	if(type == null  && m.getMethod().equals("get")){
	    return getAll(m);
	}
	else if(type.equals("User")){
	    return userToXml(m);
	} 
	else if(type.equals("Authentication")){
	    return AuthToXml(m);
	}
	else if(type.equals("Vehicle")){
	    return vehicleToXml(m);
	}
	else if(type.equals("Tire")){
	    return tireToXml(m);
	}
	else if(type.equals("Snapshot")){
	    return snapshotToXml(m);
	}
	else if(type.equals("Accident")){
	    return accidentToXml(m);
	} else {
		//throw exception
	}
	
	LogRecorder.recordLog("dbToXml failed", "/home/vcm/Tyrata.log");
	return null;	
    }

    public static String getAll(Message m) throws JAXBException, FileNotFoundException{
	String ans;
	String email = m.getUser().getEmail();
	User user = Printer.getUser(email);
	if(user == null){
	    return "<message><error>This user does not exist<error><message>";
	}
	ans = "<user><name>" + user.getName() + "</name><email>"
	    +user.getEmail()+"</email><phone_num>"
	    +user.getPhone_num()+"</phone_num></user>";
	
	List<Vehicle> vehicles = Printer.getVehicles(email);
	for (int i = 0; i < vehicles.size(); i++) {
	    ans = ans + getVehicleXML(vehicles.get(i));
	}
	List<Tire> tires = Printer.getTires(email);
	for (int i = 0; i < tires.size(); i++) {
	    ans = ans + getTireXML(tires.get(i));
	}
	List<Snapshot> snapshots = Printer.getSnapshots(email);
	for (int i = 0; i < snapshots.size(); i++) {
	    ans = ans + getSnapshotXML(snapshots.get(i));
	}
	ans = "<message><download>" + ans + "</download></message>";
	return ans;
    }

    public static String getVehicleXML(Vehicle v) throws JAXBException{
	    JAXBContext context = JAXBContext.newInstance(Vehicle.class);
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
	    StringWriter sw = new StringWriter();
	    m.marshal(v, sw);
	    return sw.toString();
    }

     public static String getTireXML(Tire t) throws JAXBException{
	    JAXBContext context = JAXBContext.newInstance(Tire.class);
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
	    StringWriter sw = new StringWriter();
	    m.marshal(t, sw);
	    return sw.toString();
    }

     public static String getSnapshotXML(Snapshot s) throws JAXBException{
	    JAXBContext context = JAXBContext.newInstance(Snapshot.class);
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
	    StringWriter sw = new StringWriter();
	    m.marshal(s, sw);
	    return sw.toString();
    }
    
    public static String userToXml(Message m) throws FileNotFoundException {
    	String ans, type="";
	if(m.getMethod().equals("create")){
	    if( Inserter.insertUser(m.getUser()) ) {
    		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    } else {
    		type = "<error>cannot create this user</error>";
	    }
	}
	else if(m.getMethod().equals("update")){
	    if(Updater.updateUser(m)){	
		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    }else{
    		type = "<error>cannot update this user</error>";
	    }
	}
	ans = "<message>" + type + "</message>";	 
	return ans;    
    }

    
    public static String accidentToXml(Message m) throws FileNotFoundException{
	String ans, type="";
	if(m.getMethod().equals("create")){
	    if(Inserter.insertAccident(m.getAccident())){
		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    }else{
		type = "<error>connot create this accident</error>";
	    }
	}
	ans = "<message>" + type + "</message>";
	return ans;
    }
    
    public static String tireToXml(Message m) throws FileNotFoundException{
	String ans, type="";
	if(m.getMethod().equals("create")){
	    if(Inserter.insertTire(m.getTire())){
		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    }else{
		type = "<error>connot create this tire</error>";
	    }
	}
	else if(m.getMethod().equals("update")){
	    if(Updater.updateTire(m)){
		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    }else{
		type = "<error>cannot update this tire</error>";
	    }
	}
	else if(m.getMethod().equals("delete")){
	    if(Deleter.deleteTire(m.getTire())){
		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    }else{
		type = "<error>cannot delete this tire</error>";
	    }
	}
	ans = "<message>" + type + "</message>";
	return ans;
    }	    
    
    public static String snapshotToXml(Message m) throws FileNotFoundException{
	String ans, type="";
	if(m.getMethod().equals("create")){
	    if(Inserter.insertSnapshot(m.getSnapshot())){
		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    }else{
		type = "<error>cannot create this sanpshot</error>";
	    }
	}
	ans = "<message>" + type + "</message>";
	return ans;
    }

    
    public static String vehicleToXml(Message m) throws FileNotFoundException{
	String ans, type="";
	if(m.getMethod().equals("create")){
	    if(Inserter.insertVehicle(m.getVehicle())){
		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    }else{
		type = "<error>cannot create this vehicle</error>";
	    }
	}
	else if(m.getMethod().equals("update")){
	    if(Updater.updateVehicle(m)){
		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    }else{
		type = "<error>cannot update this vehicle</error>";
	    }
	}
	else if(m.getMethod().equals("delete")){
	    if(Deleter.deleteVehicle(m.getVehicle())){
		type = "<ack>" + Integer.toString(m.getId()) + "</ack>";
	    }else{
		type = "<error>cannot delete this vehicle</error>";
	    }
	}
	ans = "<message>" + type + "</message>";
	return ans;
    }
	    

    
    public static String AuthToXml(Message m) throws FileNotFoundException{
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
