package db.test;

public class StudentDTO {
	
	private int no;
	private String name;
	private String det;
	private String addr;
	private String tel;
	
	public StudentDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + det + "\t" + addr + "\t" + tel;
	}

	public StudentDTO(int no, String name, String det, String addr, String tel) {
		super();
		setNo(no);
		setName(name);
		setDet(det);
		setAddr(addr);
		setTel(tel);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		if(no>0) {
			this.no = no;
		}else {
			System.out.println("학번을 다시 입력해 주세요");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name!=null) {
			this.name = name;
		}else {
			System.out.println("이름을 입력해 주세요");
		}
	}

	public String getDet() {
		return det;
	}

	public void setDet(String det) {
		if(det!=null) {
			this.det = det;
		}else {
			System.out.println("전공을 입력해 주세요");
		}
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		if(addr!=null) {
			this.addr = addr;
		}else {
			System.out.println("주소를 입력해 주세요");
		}
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		if(tel!=null) {
			this.tel = tel;
		}else {
			System.out.println("전화번호를 입력해 주세요");
		}
	}
}
