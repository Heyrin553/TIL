package test.encapsulation;

public class MyDate { 
	private int year;
	private int month;
	private int day; 
	
	//이것이  캡슐화. 외부 입력으로 인해 객체가 손상되지 않도록
	//직접 입력을 차단하고 메서드를 통해 제어 
	
	
	public int getYear() {
		return year;
	}


	public int getMonth() {
		return month;
	}


	public int getDay() {
		return day;
	}

	
	public void setYear(int year2){
		
		//유효성 검사 
		if(year2>0 && year2<2022) {
			year=year2;
		}else {
			System.out.println("invalid year");
		}
	}




	public void setMonth(int month) {
		if(month>0 && month<13) {
			this.month = month;
		}else {
			System.out.println("invalid month");
		}
		
	}

	public void setDay(int day) {
		if(day>0 && day<32) {
			this.day = day;
		}else {
			System.out.println("invalid day");
		}
		
	}
	

}


