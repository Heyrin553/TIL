package excercise;

public class Exercise07 {

	public static void main(String[] args) {
		int max = 0;
		int[] array = {1, 5, 3, 8, 2};
		for(int i = 0, j = 1; i < array.length & j < array.length ; i++, j++) {
			if(array[i] > array[j]) {
				max = array[i];
			}else {
				continue;
			}
		}
		System.out.println("max: " + max);
	}

}
