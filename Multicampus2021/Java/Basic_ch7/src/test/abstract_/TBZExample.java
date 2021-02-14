package test.abstract_;

public class TBZExample {

	public static void main(String[] args) {
		// 각 객체 생성후 호출
		JY jy = new JY();
		HJ hj = new HJ();
		jy.dance();
		hj.dance();
		System.out.println("--------");
		// 부모 타입으로 변환후 호출
		TBZ tbz = new JY();
		tbz.dance();
		tbz = new HJ();
		tbz.dance();
		System.out.println("--------");
		
		// 부모 타입 매개변수에 자식 객체를 대입
		tbzDance(new JY());
		tbzDance(new HJ());
		}
	
	public static void tbzDance(TBZ tbz) {
		tbz.dance();
		}
	}

