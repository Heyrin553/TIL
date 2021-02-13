package test.method;

public class ComputerExample {

	public static void main(String[] args) {
		Computer myCom = new Computer();
		int[] values1 = {1, 2, 3}; 
		// 메소드 호출 전에 배열을 생성해야 함 
		int result1 = myCom.sum1(values1);
		System.out.println("result1: " + result1); // 6

		int result2 = myCom.sum1(new int[] {1, 2, 3, 4, 5});
		System.out.println("result2: " + result2); // 15
		
		int result3 = myCom.sum2(1, 2, 3); 
		// 호출 시 넘겨준 값의 수에 따라 자동으로 배열 생성
		System.out.println("result3: " + result3); // 6
		
		int result4 = myCom.sum2(1, 2, 3, 4, 5);
		System.out.println("result4: " + result4); // 15
		
		int result5 = myCom.sum2(new int[] {1, 2, 3, 4, 5, 6}); 
		// 배열을 생성해서 넘겨주는 것도 가능 
		System.out.println("result5: " + result5); // 21
		
	}  

}
