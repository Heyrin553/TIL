public class MyOOP {

	public static void main(String[] args) {
		
		Print t1 = new Print("****");
		t1.A();
		t1.A();
		t1.B();
		t1.B();
		
		Print t2 = new Print("----");
		t2.A();
		t2.A();
		t2.B();
		t2.B();
		
		t1.A();
		t2.A();
		t1.A();
		t2.A();
		
	}
}
