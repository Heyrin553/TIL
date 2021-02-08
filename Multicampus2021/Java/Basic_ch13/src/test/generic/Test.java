package test.generic;

import java.util.*;  

public class Test {

	public static void main(String []var) {
		
		
		List<String> list = new ArrayList<>(); // 선언에 <String> 주고 생성에는 <>넣으면 list.add(new Object());에서 다시 에러 발생  
		list.add("Hi");

		Object [] array = new Long[10];
		array[0]= "Hi"; // 컴파일 에러는 안 나지만, java.lang.ArrayStoreException
		array[1]=new Integer(1); // java.lang.ArrayStoreException
		array[2]=new Long(2L);
		System.out.println(array);
		
//		int [] all = new int[10];
//		all[0] = 1;
//		
//		List<Integer> list2 = new ArrayList();
//		Integer o1 = new Integer(1);
//		Integer o2 = new Integer(2);
//		
//		list2.add(o1); 
//		list2.add(o2);
//		list2.add(1); // int 1은 객체가 아닌 primitive데이터이기 때문에 자바1.4까지는 에러났음 
//		int i = list2.get(2); //java5에서 생긴 unboxing기능 
		

	}

}
