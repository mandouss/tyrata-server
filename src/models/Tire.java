package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * XML implementation class XML Tire
 * Author: Yiwei
 * */

@XmlRootElement
public class Tire {
	String sensorid;
	String manufacturer;
	String model;
	String sku;
	String vin;
	int axisindex;
	String axisside;
	int axisrow;
<<<<<<< HEAD
	double initthickness;

	public String getSensorid() {
=======
    //	int init_ss_id;
	double initthickness;
    //	int cur_ss_id;
	
	
	
	public String getSensor_id() {
>>>>>>> 3111ad04ddd03ef2cbf7f96e3c6b75c5c077ac4a
		return sensorid;
	}
	@XmlElement
	public void setSensorid(String sensorid) {
		this.sensorid = sensorid;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	@XmlElement
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}
	@XmlElement
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getSku() {
		return sku;
	}
	@XmlElement
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getVin() {
		return vin;
<<<<<<< HEAD
	}
	@XmlElement
	public void setVin(String v) {
		this.vin = v;
	}
	
	public int getAxisrow() {
		return axisrow;
	}
	@XmlElement
	public void setAxisrow(int axisrow) {
		this.axisrow = axisrow;
	}

	public String getAxisside() {
		return axisside;
=======
	}
	@XmlElement
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public int getAxis_row() {
		return axisrow;
	}
    
	@XmlElement
	public void setAxisrow(int axisrow) {
		this.axisrow = axisrow;
	}

	public String getAxis_side() {
		return axisside;
	}
	@XmlElement
	public void setAxisside(String axisside) {
		this.axisside = axisside;
	}
	
	public int getAxis_index() {
		return axisindex;
	}
	@XmlElement
	public void setAxisindex(int axisindex) {
		this.axisindex = axisindex;
	}
    /*
	public int getInit_ss_id() {
		return init_ss_id;
>>>>>>> 3111ad04ddd03ef2cbf7f96e3c6b75c5c077ac4a
	}
	@XmlElement
	public void setAxisside(String axisside) {
		this.axisside = axisside;
	}
	
	public int getAxisindex() {
		return axisindex;
	}
	@XmlElement
	public void setAxisindex(int axisindex) {
		this.axisindex = axisindex;
	}
<<<<<<< HEAD

	public double getInitthickness() {
=======
    */
	public double getInit_thickness() {
>>>>>>> 3111ad04ddd03ef2cbf7f96e3c6b75c5c077ac4a
		return initthickness;
	}
	@XmlElement
	public void setInitthickness(double initthickness) {
		this.initthickness = initthickness;
	}
	
}


