package temp;

public class Test {
	public static void main(String[] args) {
		int out = 10; //원래 여기에 final이 없으면 이너클래스에서 out사용못함, 1.8부터는 자동으로 final들어가짐 
		
		class Inner { //이름이 있는 로컬 클래스 
			public int count() {
				int cnt = 0;
				for (int i = 0; i < out; i++) {
					cnt += i;
				}
				return cnt;
			}
	}
		Inner a = new Inner();
		System.out.println(a.count());
		
	}
	


	
}

//사용자가 이벤트 행위를 하면 그걸 알아듣고 호출하는 것은 JVM 이 함. 코드로 하는 것이 아님. 우리는 핸들러를 만들어서 컴포넌트에 연결만 시켜주면 됨. 
