package test.multi.array;

public class Test {

	public static void main(String[] args) {
		int [][]all=new int [3][];
		System.out.println(all);
		System.out.println(all[0]);
		System.out.println(all[1]);
		System.out.println(all[2]);
		all[0]=new int[4];
		all[0][0]=100;
		System.out.println(all[0][0]);
		all[2]=new int[2];
		System.out.println(all[2][1]);
		all[2][1]=1000;
		System.out.println(all[2][1]);
		System.out.println(all.length);
		System.out.println(all[0].length);
		//2차원배열 
		
		char [][]all2= {{'a','b'},{'c','d','e'}}; //new char[2][]
		System.out.println(all2[0][1]);
	}

}
