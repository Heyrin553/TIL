package test.stmt;

public class Exercise04 {

	public static void main(String[] args) {
		while(true) {
			int dice1 = (int)(Math.random()*6) + 1;
			int dice2 = (int)(Math.random()*6) + 1;
			System.out.println("("+dice1+","+dice2+")");
			if((dice1 == 1 & dice2 == 4) | (dice1 == 4 & dice2 == 1) | (dice1 == 2 & dice2 == 3) | (dice1 == 3 & dice2 == 2)) {
				break;
			}
		}
	}
}
