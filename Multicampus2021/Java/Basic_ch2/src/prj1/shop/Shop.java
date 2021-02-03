package prj1.shop;

public class Shop {

	public static void main(String[] args) {
		
		Customer c1=new Customer();
		c1.name="전혜린";
		c1.address="시흥";
		c1.gender='여';
		
		System.out.println(c1);
		System.out.println(c1.name);
		System.out.println("["+c1.gender+"]");
		System.out.println(c1.age);
		System.out.println(c1.tall);
		System.out.println(c1.isStudent);
		
		Customer c2=new Customer();
		c2.name="홍길동";
		c2.address="시흥";
		c2.gender='남';
		
		System.out.println(c2);
		System.out.println(c2.name);
		System.out.println("["+c2.gender+"]");
		System.out.println(c2.age);
		System.out.println(c2.tall);
		System.out.println(c2.isStudent);
		

	}

}
