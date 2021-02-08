
class Print{
	public String delimiter = "";
	public Print(String delimiter) {
		 // this는 이 클래스가 인스턴스화 되었을 때의 인스턴스를 가리키는 특별한 이름! 
//		delimiter = delimiter; //이렇게 실행하면 객체화하면서 준 parameter를 받아오지 못하고, 공백이 그대로 출력된다. 
		this.delimiter = delimiter; //this를 추가하면 parameter를 받아와 잘 출력된다. 
	}
	public void A() {
	
		System.out.println(this.delimiter);
		System.out.println("A");
		System.out.println("A");
	}
	public void B() {
		System.out.println(this.delimiter);
		System.out.println("B");
		System.out.println("B");
	}
} 