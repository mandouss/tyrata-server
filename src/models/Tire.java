package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * XML implementation class XML Tire
 * Author: Yiwei
 * */

@XmlRootElement
public class Tire {
	public String sensorid;
	public String manufacturer;
	public String model;
	public String sku;
	public String vin;
	public int axisindex;
	public String axisside;
	public int axisrow;
	public double initthickness;

	public String getSensorid() {
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

	public double getInitthickness() {
		return initthickness;
	}
	@XmlElement
	public void setInitthickness(double initthickness) {
		this.initthickness = initthickness;
	}
	
}


