package test.method;

public class Car {
	int gas;
	
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("out of gas");
			return false; 
		}else {
			System.out.println("gas left");
			return true;
		}
		
	}
	
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("Run.(gas: " + gas + ")");
				gas -= 1;
			}else {
				System.out.println("Stop.(gas: " + gas + ")");
				return;
			}
		}
	}
}
