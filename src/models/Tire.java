package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 * XML implementation class XML Tire
 * Author: Yiwei
 * */
@XmlRootElement
public class Tire {
	int id;
	String sensor_id;
	String manufacturer;
	String model;
	String sku;
	int vehicle_id;
	int axis_index;
	String axis_side;
	int axis_row;
	int init_ss_id;
	double init_thickness;
	int cur_ss_id;
	
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSensor_id() {
		return sensor_id;
	}
	@XmlElement
	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
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
	
	public int getVehicle_id() {
		return vehicle_id;
	}
	@XmlElement
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	
	public int getAxis_row() {
		return axis_row;
	}
	@XmlElement
	public void setAxis_row(int axis_row) {
		this.axis_row = axis_row;
	}

	public String getAxis_side() {
		return axis_side;
	}
	@XmlElement
	public void setAxis_side(String axis_side) {
		this.axis_side = axis_side;
	}
	
	public int getAxis_index() {
		return axis_index;
	}
	@XmlElement
	public void setAxis_index(int axis_index) {
		this.axis_index = axis_index;
	}

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

	public double getInit_thickness() {
		return init_thickness;
	}
	@XmlElement
	public void setInit_thickness(double init_thickness) {
		this.init_thickness = init_thickness;
	}
	
}


