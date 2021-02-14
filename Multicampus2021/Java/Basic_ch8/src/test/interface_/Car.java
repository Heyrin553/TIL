package test.interface_;

public class Car {
	Tire FLTire = new HankookTire();
	Tire FRTire = new HankookTire();
	Tire BLTire = new HankookTire();
	Tire BRTire = new HankookTire();
	
	void run() {
		FLTire.roll();
		FRTire.roll();
		BLTire.roll();
		BRTire.roll();
	}
}
