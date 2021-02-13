package test.method;

public class Computer {
	
	// 배열 타입으로 선언-배열만 매개값으로 받아들일 수 있음 
	int sum1(int[] values) { 
		int sum = 0;
		for(int i = 0; i < values.length; i++) {
				sum += values[i];
		}
		return sum;
	}
	/* ... 타입으로 선언-배열과 값리스트 둘 다 받아들일 수 있음. 
	  처리방식은 배열과 같음*/
	int sum2(int ... values) {  
		int sum = 0;
		for(int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
}
