package test.stmt;

public class ContinueTest {

	public static void main(String[] args) {
		int i=0;
		for(i=0;i<10;i++) {
			if(i==5) {
				continue; //i 가 5이면 반복문 수행하지 않고 증감치로 감-> 6으로 넘어가기 
			}
			System.out.println(i);
		}
		System.out.println("i="+i);
	}

} 
