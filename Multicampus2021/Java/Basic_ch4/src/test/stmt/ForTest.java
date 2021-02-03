package test.stmt;

public class ForTest {

	public static void main(String[] args) {
		int i=0;
		for(i=0;i<100;i++) {//for( ;i<100;i++) 이것도 가능 
			System.out.println(i);
		}
		System.out.println("i="+i);
	}

} //while 문보다 가독성이 높음 
