package excercise;

public class ShopService {
	
	// 자기 객체를 private static하게 생성
	private static ShopService shopservice = new ShopService();
	
	// 생성자는 private
	private ShopService() { 
	}
	
	// 자기 객체를 반환하는 static한 메소드 -getInstance()
	static ShopService getInstance() {
		return shopservice;
	}

}
