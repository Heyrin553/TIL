package test.thread;

public class Test {

	public static void main(String[] args) {
		A t1=new A();
		A t2=new A();
		
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		th1.start();
		th2.start();
		}

	}

class A implements Runnable { // 실행 흐름을 나눔 
	public void run() {
		for(int i = 0; i<100; i++) {
			System.out.println(i+"+1="+(i+1));
		}		
	}
}
