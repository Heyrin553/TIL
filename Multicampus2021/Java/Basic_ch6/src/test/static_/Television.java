package test.static_;

public class Television {
	static String company = "Samsung";
	static String model = "LCD";
	static String info;
	
	static { // 정적 초기화 블록 
		info = company + "-" + model;
	}

}
