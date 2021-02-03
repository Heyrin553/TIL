package test1;

public class Test {

	public static void main(String[] args) {
		MyProfile m1=new MyProfile();
		m1.setProfile("Hyerin", 25, 161.5, 'F', true);//메서드 호출 
		System.out.println(m1);
		m1.printProfile();
		
	
		MyProfile m2=new MyProfile();
		m2.setProfile("James", 26, 180, 'M', true);
		System.out.println(m2);
		m2.printProfile();

	}
}


