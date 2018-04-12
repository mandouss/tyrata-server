package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User {
	
    String name;
    String email;
    String phone_num;
    String hash;
    String salt;
   
	
    public boolean isValid () {
	return name!=null && email != null && phone_num != null;
    }
    
    public String getName() {
	return name;
    }
    
    public String getEmail() {
	return email;
    }
	
    public String getPhone_num() {
	return phone_num;
    }

    public String getHash() {
	return hash;
    }

    public String getSalt() {
	return salt;
    }
    
	
    @XmlElement
    public void setName(String name) {
	this.name = name;
    }
    @XmlElement
    public void setEmail(String email) {
	this.email = email;
    }
    @XmlElement
    public void setPhone_num(String phone_num) {
	this.phone_num = phone_num;
    }
    @XmlElement
    public void setHash(String hash) {
	this.hash = hash;
    }
    @XmlElement
    public void setSalt(String salt) {
	this.salt = salt;
    }
    
    
}
