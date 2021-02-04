package test.static_;

public class Test2 {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(time);
		
		//System s=new System(); //컴파일 에러-생성자가 private 하여 외부에서 객체 생성이 불가능. 외부에서 접근하지 못하도록 막아둠! 어차피  static에 올라와 있으니 객체생성 안해도 사용가능

	}

}
