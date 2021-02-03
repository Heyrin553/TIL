package test.datatype;

import java.util.Date;

public class Test {
	
	
	public static void main(String[] args) {
		int age=25;
		double tall=160.5;
		char gender='여';
		boolean isSmart=true;
		String name=new String("전혜린");
		Date birthday=new Date(1997,2,26);
		//MemberName name=new MemberName();
		
		//Test t1=new Test();
		System.out.println(age);
		System.out.println(tall);
		System.out.println(gender);
		System.out.println(isSmart);
		System.out.println(name);
		System.out.println(birthday.getYear()+"년"+birthday.getMonth()+"월"+birthday.getDate()+"일");
		//System.out.println(name.name1+""+name.name2+""+name.name3);
	
	}
}
