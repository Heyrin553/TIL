package test.interface_.defaultmethod;

public interface ChildInterface2 extends ParentInterface{
	@Override
	default void method2() {
		System.out.println("childinterface2 - method2");
		
	}
	public void method3();

}
