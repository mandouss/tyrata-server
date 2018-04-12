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
    Accident accident;
    int id;
    String original_info;
 

    public Accident getAccident(){
	return accident;
    }
    @XmlElement
    public void setAccident(Accident accident){
	this.accident = accident;
    }
    
    public String getOrigial_info(){
	return original_info;
    }

    @XmlElement
    public void setOrigial_info(Sting original_info){
	this.original_info = original_info;
    }
    
    public Authentication getAuthentication(){
	return authentication;
    }

    @XmlElement
    public void setAuthentication(Authentication authentication){
	this.authentication = authentication;
    }
    
    public Tire getTire() {
	return tire;
    }
    @XmlElement
    public void setTire(Tire tire) {
	this.tire = tire;
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

    public static String getType(){
	if(user != NULL && vehicle == NULL && tire == NULL && snapshot == NULL  && authentication == NULL && accident == NULL){
	    return "User";
	}
	if(user == NULL && vehicle != NULL && tire == NULL && snapshot == NULL  && authentication == NULL && accident == NULL){
	    return "Vehicle";
	}
	if(user == NULL && vehicle == NULL && tire != NULL && snapshot == NULL  && authentication == NULL && accident == NULL){
	    return "Tire";
	}
	if(user == NULL && vehicle == NULL && tire == NULL && snapshot != NULL  && authentication == NULL && accident == NULL){
	    return "Snapshot";
	}
	if(user == NULL && vehicle == NULL && tire == NULL && snapshot == NULL  && authentication != NULL && accident == NULL){
	    return "Authentication";
	}
	if(user == NULL && vehicle == NULL && tire == NULL && snapshot == NULL  && authentication == NULL && accident != NULL){
	    return "accident";
	}
	return null;
    }
    
 
}

