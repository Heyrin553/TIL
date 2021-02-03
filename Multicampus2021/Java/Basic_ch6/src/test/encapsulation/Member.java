package test.encapsulation;

public class Member {
	private String name;
	private String address;
	private String phone;
	private String email;
	private String hobby;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		//유효성 검사 
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		//유효성 검사 
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		//유효성 검사 
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		//유효성 검사 
		this.email = email;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		//유효성 검사 
		this.hobby = hobby;
	}
	
	
	
	

}
