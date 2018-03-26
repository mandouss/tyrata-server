
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	String name;
	String email;
	int user_ID;
	String phone_num;
	
	public String getName() {
		return name;
	}
	
	public String getemail() {
		return email;
	}
	
	public int getUser_ID() {
		return user_ID;
	}
	
	public String getPhone_num() {
		return phone_num;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public void setemail(String email) {
		this.email = email;
	}
	@XmlElement
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	@XmlElement
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

}
