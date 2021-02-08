package test.map;

import java.util.Enumeration;
import java.util.Hashtable;

public class MapTest {

	public static void main(String[] args) {
		Hashtable map = new Hashtable();
		// key가 겹쳐선 안 됨
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "1");
		map.put("d", new MapTest()); // 자기객체
		
		System.out.println(map); // {b=2, a=1, d=test.map.MapTest@139a55, c=1}
		System.out.println(map.size()); // 4
		
		Object o1 = map.get("a");
		Object o2 = map.get("c");
		System.out.println(o1 == o2); // 값을 비교, true
		
		Enumeration enu = map.keys(); // key를 모를 때 사용 
		while(enu.hasMoreElements()) {
			Object o = enu.nextElement();
//			System.out.println(o); // b a d c 
			System.out.println(o + ":" + map.get(o)); //b:2 a:1 d:test.map.MapTest@139a55 c:1
			
		}

	}

}
