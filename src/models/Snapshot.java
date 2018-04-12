package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * XML implementation class XML Snapshot
 * Author: Yiwei
 * */

@XmlRootElement
public class Snapshot {
	double s11;
	String timestamp;
	double mileage;
	double pressure;
	int tire_id;
	boolean outlier;
	double thickness;
	String eol;
	String replacetime;
	double longtitude;
	double latitude;
	

	public double getS11() {
		return s11;
	}
	@XmlElement
	public void setS11(double s11) {
		this.s11 = s11;
	}

	public String getTimestamp() {
		return timestamp;
	}
	@XmlElement
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getMileage() {
		return mileage;
	}
	@XmlElement
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getPressure() {
		return pressure;
	}
	@XmlElement
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	
	public int getTire_id() {
		return tire_id;
	}
	@XmlElement
	public void setTire_id(int tire_id) {
		this.tire_id = tire_id;
	}
	
	public boolean isOutlier() {
		return outlier;
	}
	@XmlElement
	public void setOutlier(boolean outlier) {
		this.outlier = outlier;
	}

	public double getThickness() {
		return thickness;
	}
	@XmlElement
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	
	public String getEol() {
		return eol;
	}
	@XmlElement
	public void setEol(String eol) {
		this.eol = eol;
	}
	
	public String getReplacetime() {
		return replacetime;
	}
	@XmlElement
	public void setReplacetime(String replacetime) {
		this.replacetime = replacetime;
	}
	
	public double getLongtitude() {
		return longtitude;
	}
	@XmlElement
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	@XmlElement
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	




}
