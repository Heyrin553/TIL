package my.fly;

public class Test {

	public static void main(String[] args) {
		Flyer b=new Bird();
		Flyer s=new Superman();
		Flyer a=new Airplane();
		
		Show show=new Show();
		show.airShow(b);
		show.airShow(s);
		show.airShow(a);
//		show.airShow("java"); //규격에 맞지 않아 에러 발생! 
		
	}

}
