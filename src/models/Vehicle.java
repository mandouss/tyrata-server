package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * XML implementation class XML Vehicle
 * Author: Yiwei
 * */


@XmlRootElement
public class Vehicle {
	String vin;
	String make;
	String model;
	int year;
<<<<<<< HEAD
	int tire_num;
	int axis_num;
=======
	int numtires;
	int numaxis;
>>>>>>> 3111ad04ddd03ef2cbf7f96e3c6b75c5c077ac4a
	String email;
	

	
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
<<<<<<< HEAD
	public void setEmail(String em) {
		this.email = em;
=======
	public void setEmail(String email) {
		this.email = email;
>>>>>>> 3111ad04ddd03ef2cbf7f96e3c6b75c5c077ac4a
	}

	public int getTire_num() {
		return numtires;
	}
	@XmlElement
	public void numtires(int numtires) {
		this.numtires = numtires;
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
		return numaxis;
	}
	@XmlElement
	public void setNumaxis(int numaxis) {
		this.numaxis = numaxis;
	}

	public String getMake() {
		return make;
	}
    
	@XmlElement
	public void setMake(String make) {
		this.make = make;
	}

}
