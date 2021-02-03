package my.fly;

public class Test {

	public static void main(String[] args) {
		Bird b=new Bird();
		Superman s=new Superman();
		Airplane a=new Airplane();
		
		show show=new show();
		show.airShow(b);
		show.airShow(s);
		show.airShow(a);
		show.airShow("java");
		
		
	}

}
