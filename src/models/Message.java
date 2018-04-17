package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import tools.LogRecorder;
/*
 * XML implementation class XML Message
 * Author: Yiwei
 * */
@XmlRootElement
public class Message {
	int id;
    String method;
    User user;
    Vehicle vehicle;
    Tire tire;
    Snapshot snapshot;
    Authentication authentication;
    Accident accident;
    String original_info;
 

    public Accident getAccident(){
	return accident;
    }
    @XmlElement
    public void setAccident(Accident accident){
	this.accident = accident;
    }
    
    public String getOriginal_info(){
	return original_info;
    }

    @XmlElement
    public void setOriginal_info(String original_info){
    	this.original_info = original_info;
    }
    
    
    
    public int getId() {
    	return id;
    }
    @XmlElement
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getMethod() {
    	return method;
    }
        
    @XmlElement
    public void setMethod(String method) {
    	this.method = method;
    }
    
    public User getUser() {
	return user;
    }
     
    @XmlElement
    public void setUser(User user) {
	this.user = user;
    }
    
    public Vehicle getVehicle() {
    	return vehicle;
    }
       
        
    @XmlElement
    public void setVehicle(Vehicle vehicle) {
    	this.vehicle = vehicle;
    }
    
    public Tire getTire() {
	return tire;
    }
    @XmlElement
    public void setTire(Tire tire) {
	this.tire = tire;
    }
    
    
    public Snapshot getSnapshot() {
	return snapshot;
    }
    @XmlElement
    public void setSnapshot(Snapshot snapshot) {
	this.snapshot = snapshot;
    }
    
    

    
    public Authentication getAuthentication(){
    	return authentication;
    }

    @XmlElement
    public void setAuthentication(Authentication authentication){
    	this.authentication = authentication;
    }

    public String getType(){
	if( user != null && vehicle == null && tire == null && snapshot == null  && authentication == null && accident == null){
	    return "User";
	}
	if(user == null && vehicle != null && tire == null && snapshot == null  && authentication == null && accident == null){
	    return "Vehicle";
	}
	if(user == null && vehicle == null && tire != null && snapshot == null  && authentication == null && accident == null){
	    return "Tire";
	}
	if(user == null && vehicle == null && tire == null && snapshot != null  && authentication == null && accident == null){
	    return "Snapshot";
	}
	if(user == null && vehicle == null && tire == null && snapshot == null  && authentication != null && accident == null){
	    return "Authentication";
	}
	if(user == null && vehicle == null && tire == null && snapshot == null  && authentication == null && accident != null){
	    return "Accident";
	}
	return null;
    }
    
 
}

