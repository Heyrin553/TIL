package test.interface_.inheritance;

public class Example {

	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();
		
		InterfaceA ia = impl;
		ia.methodA(); // methodA만 호출 가능
		System.out.println();
		
		InterfaceB ib = impl;
		ib.methodB(); // methodB만 호출 가능
		System.out.println();
		
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();

	}

}
