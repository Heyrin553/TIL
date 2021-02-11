package test.array;

public class ArrayInArrayExample {

	public static void main(String[] args) {
		int[][] mathScores = new int[2][3];
		for(int i = 0; i < mathScores.length; i++) {
			for(int j = 0; j < mathScores[i].length; j++) {
				System.out.println("mathScores[" + i + "][" + j + "]=" + mathScores[i][j]);
			}
		}
		System.out.println();
		
		int[][] EnglishScores = new int[2][3];
		for(int i = 0; i < EnglishScores.length; i++) {
			for(int j = 0; j < EnglishScores[i].length; j++) {
				System.out.println("EnglishScores[" + i + "][" + j + "]=" + EnglishScores[i][j]);
			}
		}
		System.out.println();
		
	}

}
