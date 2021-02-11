package test.stmt;

public class IfElseExample {

	public static void main(String[] args) {
		int score = 80;
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.\n" + "등급은 A입니다.");
		} else { // score < 90
			System.out.println("점수가 90보다 작습니다.\n" + "등급은 B입니다."); 
		}

		
	}

}
