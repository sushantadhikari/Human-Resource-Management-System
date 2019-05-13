package files;

import java.io.Serializable;

import javax.swing.JTextField;

public class Department_data implements Serializable {

	 private String name;
     private String type;
     private String username;
     private String password;
     
     public Department_data (String name, String type, String username, String password) {
    	 this.name = name;
    	 this.type = type;
    	 this.username = username;
    	 this.password = password;
     }
     
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
     
	
}
