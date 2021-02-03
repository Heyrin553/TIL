package my.shop;

public class Guest extends Customer {
	
	@Override //어노테이션, 오버라이딩 체크해달라 
	public void calcPoint() {
		super.calcPoint(); //아버지 메소드를 그대로 호출
		System.out.println("1회 방문하셨습니다.");
	}

}
