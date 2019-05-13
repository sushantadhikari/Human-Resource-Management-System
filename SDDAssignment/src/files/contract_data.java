package files;

import java.io.Serializable;

public class contract_data implements Serializable{
	private String name;
    private String type;
    private String payrate;
    private String address;
    private String email;
    private String phnumber;
    
    
    public contract_data(String name, String type, String payrate, String address, String email, String phnumber) {
   	 this.name = name;
   	 this.type = type;
   	 this.payrate = payrate;
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

	public String getpayrate() {
		return payrate;
	}

	public void setpayrate(String payrate) {
		this.payrate = payrate;
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
