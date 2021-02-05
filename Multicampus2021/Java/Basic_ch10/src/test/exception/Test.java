package test.exception;

public class Test {

	public static void main(String[] args) {
		try {
			int x=100;
			args[0]=null; //수행하면 NullPointerException이 발생하지만, 아래  Exception e에 걸려 "어떤 예외가 발생했습니다"메시지만 출력
			int y=Integer.parseInt(args[0].trim());//trim():공백을 떼는 메소드
			System.out.println(x/y);
			}catch(ArithmeticException e) {
				 System.out.println("0으로 나누지 마세요");
			}catch(NumberFormatException e) {
				 System.out.println("숫자로 바꿀 수 없는 입력입니다");
			}catch(ArrayIndexOutOfBoundsException e) {
				 System.out.println("숫자를 입력하세요");
			}catch(Exception e) {
				System.out.println("어떤 예외가 발생했습니다");
			}
		System.out.println("아주 중요한 일이 여기부터");
	}
}
