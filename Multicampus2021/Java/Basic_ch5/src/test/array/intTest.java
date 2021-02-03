package test.array;

public class intTest {

	public static void main(String[] args) {
		int []all=new int[100]; //100칸의 배열을 인스턴스 영역에 생성 후 0으로 채움. 로컬데이터인 all은 스택 영역에 저장되고 배열의 주소를 가짐.  
		System.out.println(all); 
		for(int i=0;i<all.length;i++) {
			all[i]=i;
			System.out.println(all[i]); 

		}

	}

}
