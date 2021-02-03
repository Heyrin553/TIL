package my.shop;

public class Customer {
	private String name;
	private int custNo;
	private String address;
	
	public void calcPoint() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		//유효성 검사 했다 치고 
		this.name = name;
	}
	public int getCustNo() {
		return custNo;
	}
	public void setCustNo(int custNo) {
		//유효성 검사 했다 치고 
		this.custNo = custNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		//유효성 검사 했다 치고 
		this.address = address;
	}
	
}
