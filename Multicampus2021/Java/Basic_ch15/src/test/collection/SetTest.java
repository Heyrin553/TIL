package test.collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet();
		set.add("1");
		set.add("2");
		set.add("3");
		//set.add(new SetTest());
		//set.add(new SetTest());
		set.add("1");
		System.out.println(set);
		System.out.println(set.size()); // 순서 없고, 중복 허용 안함 
		Iterator<String> ite = set.iterator(); //순서가 없으므로 get메소드는 사용 불가. 대신 iterator 사용 
		System.out.println(ite); // java.util.HashMap$KeyIterator@106d69c 이터레이터 주소 출력
		while(ite.hasNext()) {
			String o = ite.next();
			System.out.println(o);	
		}
	}
}
