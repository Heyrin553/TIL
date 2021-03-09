package my.model;

public class PersonImpl implements Person{
	private String name;
	private int age;
	
	
	
	public PersonImpl(int age, String name) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("생성자 (int age, String name) 호출");
	}
	
	public PersonImpl(String name) {
		super();
		this.name = name;
		System.out.println("생성자 (String name) 호출");
	}
	
	public PersonImpl() {
		System.out.println("생성자() 호출");
		
	}
	
	@Override
	public String toString() {
		return "PersonImpl [name=" + name + ", age=" + age + "]";
	}
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
