package test.final_;

public class Test {
	
	public static void main(String[] args) {
	Object o1=new Object();
	System.out.println(o1.toString()); //주소값 출력 
	
	Object o2=new Object();
	System.out.println(o2.toString()); //주소값 출력 
	
	System.out.println(o1==o2); //주소값 비교
	System.out.println(o1.equals(o2)); 
	
	Test t1=new Test();
	System.out.println(t1.toString());
	Test t2=new Test();
	System.out.println(t2.toString());
	
	System.out.println(t1==t2);
	System.out.println(t1.equals(t2));
	
	String s1=new String("java");
	System.out.println(s1.toString()); //오버라이딩 결과 - 내용값 출력 
	String s2=new String("java");
	System.out.println(s2.toString()); //오버라이딩 결과 - 내용값 출력 
	
	System.out.println(s1==s2); //오버라이딩 결과 
	System.out.println(s1.equals(s2)); //오버라이딩 결과 - 내용값 비교 
	
	String s3="java";
	System.out.println(s3.toString()); //오버라이딩 결과 - 내용값 출력  
	String s4="java";
	System.out.println(s4.toString()); //오버라이딩 결과 - 내용값 출력 
	
	System.out.println(s3==s4); //오버라이딩 결과 - 내용값 비교  
	System.out.println(s3.equals(s4)); //오버라이딩 결과 - 내용값 비교   
	
	}
}
