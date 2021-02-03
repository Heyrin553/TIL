package test1;

public class MyProfile {
	
	String name;
	int age;
	double tall;
	char gender;
	boolean isSmart;
	
	public void setProfile(String name1, int age1, double tall1, 
			char gender1, boolean isSmart1) {//정의
		
		name=name1;
		age=age1;
		tall=tall1;
		gender=gender1;
		isSmart=isSmart1;

	}
	
	public void printProfile() {
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(tall);
		System.out.println(gender);
		System.out.println(isSmart);
		
	}

}
