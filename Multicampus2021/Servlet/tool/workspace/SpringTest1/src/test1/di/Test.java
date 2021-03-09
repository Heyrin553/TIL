package test1.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import my.model.Person;
import my.model.PersonImpl;

public class Test {

	public static void main(String[] args) {
		//PersonImpl person1=new PersonImpl();
		//person1.setName("전은수");
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("person.xml"));
		Person p=(Person) factory.getBean(args[0]);
		System.out.println(p);
		
	}

}
