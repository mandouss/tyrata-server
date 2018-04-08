package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 * XML implementation class XML Snapshot
 * Author: Yiwei
 * */

@XmlRootElement
public class Snapshot {
	int id;
	double s11;
	String timestamp;
	double mileage;
	double pressure;
	int tire_id;
	boolean outlier;
	double thickness;
	String eol;
	String time_to_replacement;
	double longtitude;
	double latitude;
	

	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
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
	
	public String getTime_to_replacement() {
		return time_to_replacement;
	}
	@XmlElement
	public void setTime_to_replacement(String time_to_replacement) {
		this.time_to_replacement = time_to_replacement;
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
