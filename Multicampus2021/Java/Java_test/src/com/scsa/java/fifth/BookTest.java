package com.scsa.java.fifth;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book();
		Magazine m = new Magazine();
		
		b1.isbn = "21424";
		b1.title = "Java Pro";
		b1.author = "김하나";
		b1.publisher = "Jaen.kr";
		b1.price = 15000;
		b1.desc = "기본문법";
		
		b2.isbn = "35355";
		b2.title = "OOAD 분석, 설계";
		b2.author = "소나무";
		b2.publisher = "Jaen.kr";
		b2.price = 30000;
		b2.desc = " ";
		
		m.isbn = "35535";
		m.title = "Java World";
		m.author = "편집부";
		m.publisher = "androidjava.com";
		m.price = 7000;
		m.year = 2013;
		m.month = 2;
		m.desc = " ";
		
		
		
		
		System.out.println("*********************** 도서목록 ***********************");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(m);

	}

}
