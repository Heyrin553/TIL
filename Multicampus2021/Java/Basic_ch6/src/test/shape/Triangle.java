package test.shape;

public class Triangle extends Shape {
	private int w,h;
	
	public int getW() {
		return w;
	}

	public void setW(int w) {
		if (w>0) {
		this.w = w;
		}else {
			System.out.println("길이는 0보다 커야 합니다.");
		}
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		if (h>0) {
		this.h = h;
		}else {
			System.out.println("높이는 0보다 커야 합니다.");
		}
	}

	public void area() {
		System.out.println("삼각형의 넓이="+(w*h/2));
	}

}
