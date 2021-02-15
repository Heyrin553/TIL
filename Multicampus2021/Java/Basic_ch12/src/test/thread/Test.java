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
// 메인 포함 스레드 3개 - 메인은 데몬스레드, 프로세스 라고도 함 
	}

class A extends Thread { // 실행 흐름을 나눔 
	public void run() {
		for(int i = 0; i<100; i++) {
			System.out.println(getName()+":"+i+"+1="+(i+1));
			if(i == 50) {
			
			}
		}		
	}
}
