package test2.operator;

public class StringEqualsExample {

	public static void main(String[] args) {
		String strVar1 = "Heyrin";
		String strVar2 = "Heyrin";
		String strVar3 = new String("Heyrin");
		
		System.out.println(strVar1 == strVar2); // true
		System.out.println(strVar1 == strVar3); // false
		System.out.println("------------------");
 		System.out.println(strVar1.equals(strVar2)); // true
		System.out.println(strVar1.equals(strVar3)); // true
	}

}
