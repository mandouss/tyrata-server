package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

    public String getType( ){
	if(user != null && vehicle == null && tire == null && snapshot == null  && authentication == null){
	    return "User";
	}
	if(user == null && vehicle != null && tire == null && snapshot == null  && authentication == null){
	    return "Vehicle";
	}
	if(user == null && vehicle == null && tire != null && snapshot == null  && authentication == null){
	    return "Tire";
	}
	if(user == null && vehicle == null && tire == null && snapshot != null  && authentication == null){
	    return "Snapshot";
	}
	if(user == null && vehicle == null && tire == null && snapshot == null  && authentication != null){
	    return "Authentication";
	}
	return null;
    }
    
 
}

