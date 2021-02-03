package test.shape;

public class Test {

	public static void main(String[] args) {
		Circle c=new Circle();
		c.setRadius(5);
		
		Rectangle r=new Rectangle();
		r.setW(10);
		r.setH(8);
		
		Triangle t=new Triangle();
		t.setW(5);
		t.setH(8);
		
		Printer out=new Printer();
		out.print((Shape)c);
		out.print(c);
		out.print(r);
		out.print(t);
		//out.print("java"); // 에러 체크! robust 한 프로그램 

	}

}
