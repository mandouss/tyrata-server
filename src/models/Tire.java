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
	double initthickness;

	public String getSensorid() {
		return sensorid;
	}
	@XmlElement
	public void setSensorid(String sensor_id) {
		this.sensorid = sensor_id;
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
	public void setVin(String v) {
		this.vin = v;
	}
	
	public int getAxisrow() {
		return axisrow;
	}
	@XmlElement
	public void setAxisrow(int axis_row) {
		this.axisrow = axis_row;
	}

	public String getAxisside() {
		return axisside;
	}
	@XmlElement
	public void setAxisside(String axis_side) {
		this.axisside = axis_side;
	}
	
	public int getAxisindex() {
		return axisindex;
	}
	@XmlElement
	public void setAxisindex(int axis_index) {
		this.axisindex = axis_index;
	}

	public double getInitthickness() {
		return initthickness;
	}
	@XmlElement
	public void setInitthickness(double init_thickness) {
		this.initthickness = init_thickness;
	}
	
}


