package files;

import java.io.Serializable;

public class Lecturer_data implements Serializable {
	 private String name;
     private String type;
     private String department;
     private String address;
     private String email;
     private String phnumber;
     
     
     public Lecturer_data (String name, String type, String department, String address, String email, String phnumber) {
    	 this.name = name;
    	 this.type = type;
    	 this.department = department;
    	 this.address = address;
    	 this.email = email;
    	 this.phnumber = phnumber;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}

	
}
