package test.inheritance.area;

public class Test {

	public static void main(String[] args) {
		
		Circle c=new Circle();
		Rectangular r=new Rectangular();
		Triangle t=new Triangle();
		Printer out=new Printer();
		
		out.print(c);
		out.print(r);
		out.print(t);
	

	}

}
