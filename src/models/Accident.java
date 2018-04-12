package models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Accident {
    String description;
    String email;
    public String getDescription(){ 
	return description;          
    }
    public String getEmail(){
	return email;
    }

    @XmlElement
    public void setDescription(String description){
	this.description = description;
    }

    @XmlElement
    public void setEmail(String email){
	this.email = email;
    }

}
