package test.collection;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList(); //String 타입만 들어올 수 있는 리스트 
		list.add("1"); // 한 번에 하나씩만 집어넣을 수 있음 
		list.add("2");
		list.add("3");
		list.add("1");
//		list.add(new ListTest()); // 컴파일에러발생!

		
		for(String s:list) {
				System.out.println(s); // robust하면서도 성능이 좋아짐! 확인 절차를 안 넣어도 됨. 

	}
	}
}
