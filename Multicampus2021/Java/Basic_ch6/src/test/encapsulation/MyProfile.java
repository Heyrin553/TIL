package test.encapsulation;

public class MyProfile {
	String name="오미주";
	MyDate birthday=new MyDate();
	//birthday.year=1980;행위를 하려면 메서드가 필요 
	
	public void setBirthday() {
//		birthday.year=1980; //의미적으로 굉장히 나쁨 
		birthday.setYear(1980);
		birthday.setMonth(10);
		birthday.setDay(-3); //실수로 -를 넣어도 에러가 안 남! 이게 날짜인 것을 컴퓨터가 모름 
		System.out.println(birthday.getYear()+"년"+birthday.getMonth()
		+"월"+birthday.getDay()+"일");
		
		
	}
	
}
