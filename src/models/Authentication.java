package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Authentication{
    String email;
    String salt;
    String hash;

    public String getEmail(){
	return email;
    }
    public String getSalt(){
	return salt;
    }
    public String getHash(){
	return hash;
    }

    @XmlElement
    public void setEmail(){
	this.email = email;
    }
    @XmlElement
    public void setSalt(){
	this.salt = salt;
    }
    @XmlElement
    public void setHash(){
	this.hash = hash;
    }
}
