package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * XML implementation class XML Vehicle
 * Author: Yiwei
 * */


@XmlRootElement
public class Vehicle {
	public String vin;
	public String make;
	public String model;
	public int year;
	public int tire_num;
	public int axis_num;
	public String email;
	

	
	public String getModel() {
		return model;
	}
	@XmlElement
	public void setModel(String model) {
		this.model = model;
	}

	
	
	public String getEmail() {
		return email;
	}
	@XmlElement
	public void setEmail(String em) {
		this.email = em;
	}

	public int getTire_num() {
		return tire_num;
	}
	@XmlElement
	public void setTire_num(int tire_num) {
		this.tire_num = tire_num;
	}

	
	public String getVin() {
		return vin;
	}
	@XmlElement
	public void setVin(String vin) {
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
