package test.method;

public class Book {
	
	int i;
	
	public void want(String ...all) { // ...은 개발 편의성을 극대화해주는 표현법. 내부적으로는 배열로 인식
		System.out.println(all);
		for(String s:all) { //향상된 for문
			System.out.println(s);
		}
	}
	
	public void test() {
		System.out.println(this);
	}
	
	public void test(int i) {
		this.i=i;
		System.out.println(this.i);
		String s=super.toString();
		System.out.println(s);
	}

}
