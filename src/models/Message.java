package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 * XML implementation class XML Message
 * Author: Yiwei
 * */

@XmlRootElement
public class Message {
	String method;
	User user;
	Vehicle vehicle;
	Tire tire;
	Snapshot snapshot;
	
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
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	@XmlElement
	public void setUser(User user) {
		this.user = user;
	}
	
	@XmlElement
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
