package tools;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 * XML implementation class XML Vehicle
 * Author: Yiwei
 * */
@XmlRootElement
public class Vehicle {
	int vin;
	int id;
	String make;
	String model;
	int year;
	int tire_num;
	int axis_num;
	int user_id;
	
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModel() {
		return model;
	}
	@XmlElement
	public void setModel(String model) {
		this.model = model;
	}

	
	
	public int getUser_id() {
		return user_id;
	}
	@XmlElement
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTire_num() {
		return tire_num;
	}
	@XmlElement
	public void setTire_num(int tire_num) {
		this.tire_num = tire_num;
	}

	
	public int getVin() {
		return vin;
	}
	@XmlElement
	public void setVin(int vin) {
		this.vin = vin;
	}
	public int getYear() {
		return year;
	}
	@XmlElement
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getAxis_num() {
		return axis_num;
	}
	@XmlElement
	public void setAxis_num(int axis_num) {
		this.axis_num = axis_num;
	}

	public String getMake() {
		return make;
	}
	@XmlElement
	public void setMake(String make) {
		this.make = make;
	}

}
