package test.shape;

public class Printer {
	
	public void print(Shape s) {
		s.area();
	}
		public void print(Circle c) {
			System.out.println(c.getRadius());
		}
		public void print(Rectangle r) {
			System.out.println(r.getW());
		
	}

}

// 개발불편, 확장성 x, if 가 들어가면 느려짐 ->성능에 나빠 
//원인: 셰도 이펙트 -> 피해가는 방법 
// 
