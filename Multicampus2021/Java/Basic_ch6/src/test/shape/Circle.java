package test.shape;

public class Circle extends Shape {
	private int radius;
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		if(radius>0) {
		this.radius = radius;
		}else {
			System.out.println("반지름은 0보다 커야 합니다.");
		}
	}
	public void area() { //shape에서 정의한 메서드를 재정의
		System.out.println("원의 넓이="+(3.14*radius*radius));
	}
}

