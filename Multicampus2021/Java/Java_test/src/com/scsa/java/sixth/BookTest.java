package com.scsa.java.sixth;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("21424", "Java Basic  ", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("33455", "JDBC Pro    ", "김철수", "Jaen.kr", 23000, " ");
		Book b3 = new Book("55355", "Servlet/JSP ", "박자바", "Jaen.kr", 41000, "Model2 기반");
		Book b4 = new Book("35332", "Android App ", "홍길동", "Jaen.kr", 25000, "Lightweight Framework");
		Book b5 = new Book("35355", "OOAD 분석,설계       ", "소나무", "Jaen.kr", 30000, " ");
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		

	}

}
