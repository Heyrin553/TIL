package test.casting;

public class CheckValueBeforeCasting {

	public static void main(String[] args) {
		int i = 300;
		
		if((i < Byte.MAX_VALUE) || (i > Byte.MAX_VALUE)){
			System.out.println("byte타입으로 변환할 수 없습니다\n"+"값을 다시 확인해 주세요");
		}else {
			byte b = (byte) i;
			System.out.println(b);
		}  // i가 -128~127 사이의 값이면 그대로 출력되지만, 범위를 넘어가면 경고 메시지를 출력! 
	}

}
