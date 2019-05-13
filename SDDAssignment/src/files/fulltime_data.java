package files;

import java.io.Serializable;

public class fulltime_data implements Serializable {
	private String name;
    private String type;
    private String salary;
    private String address;
    private String email;
    private String phnumber;
    
    
    public fulltime_data(String name, String type, String salary, String address, String email, String phnumber) {
   	 this.name = name;
   	 this.type = type;
   	 this.salary = salary;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
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
