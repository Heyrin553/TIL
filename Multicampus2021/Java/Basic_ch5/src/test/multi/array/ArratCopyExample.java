package test.multi.array;

public class ArratCopyExample {

	public static void main(String[] args) {
		String[]oldStrArray = {"java","array","copy"};
		String[]newStrArray = new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		for(int i=0; i<newStrArray.length; i++) {
			
		}

		for(String s:newStrArray) {
			System.out.println(s);
		}
	}

}
