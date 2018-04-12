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
    //	int init_ss_id;
	double initthickness;
    //	int cur_ss_id;
	
	
	
	public String getSensor_id() {
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
	}
	@XmlElement
	public void setInit_ss_id(int init_ss_id) {
		this.init_ss_id = init_ss_id;
	}
	
	public int getCur_ss_id() {
		return cur_ss_id;
	}
	@XmlElement
	public void setCur_ss_id(int cur_ss_id) {
		this.cur_ss_id = cur_ss_id;
	}
    */
	public double getInit_thickness() {
		return initthickness;
	}
	@XmlElement
	public void setInitthickness(double initthickness) {
		this.initthickness = initthickness;
	}
	
}


