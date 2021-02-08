package test.generic2;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Cat cat = new Cat();
		AnimalList<LandAnimal> zoo = new AnimalList();
		zoo.add(cat);
//		zoo.add("aaa");
		
		Fish fish = new Fish();
		AnimalList<WaterAnimal> zoo2 = new AnimalList();
		zoo2.add(fish);
		
		AnimalList.cryingAnimalList(zoo);

	}

}

class AnimalList<T>{ //제한은 할 건데 니가 사용하는 시점에서 제한해서 쓰면 그 타입을 받아들이겠다 
	ArrayList<T> al = new ArrayList<T>(); // 빈 상자 
	public static void cryingAnimalList(AnimalList<? extends LandAnimal> al) { // LandAnimal로 제한되는 애니멀리스트만 받아들여라 
		LandAnimal la = al.get(0);
		la.crying();
	}
	public void add(T o) { // 리스트에 동물 추가 
		al.add(o);
		
	}
	public T get(int index){ // 동물 리턴 -어떤 타입이 올지 모르기 때문에 일단 T 
		return al.get(index);
	}
	public void remove() { // 동물 삭제 
		
	}
}
class WaterAnimal{
	public void swim() {
		System.out.println("수중동물");
	}
}

class Fish extends WaterAnimal{
	public void swim() {
		System.out.println("지느러미를 움직임");
	}
}

class LandAnimal{
	public void crying() {
		System.out.println("육지동물");
	}
}
class Cat extends LandAnimal{
	@Override
	public void crying() {
		System.out.println("냐옹냐옹");
	}
}
class Dog extends LandAnimal{
	@Override
	public void crying() {
		System.out.println("멍멍");
	}
}
class Sparrow extends LandAnimal{
	@Override
	public void crying() {
		System.out.println("짹짹");
	}
}