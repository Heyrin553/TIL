package my.shop;

public class Black extends Customer {
	
	@Override //어노테이션, 오버라이딩 체크해달라 
	public void calcPoint() {
		super.calcPoint(); //아버지 메소드를 그대로 호출
		System.out.println("100포인트 차감되었습니다.");
	}


}
