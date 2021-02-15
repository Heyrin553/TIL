package com.scsa.java.fifth;

public class Magazine {
	String isbn;
	String title;
	String author;
	String publisher;
	int year;
	int month;
	int price;
	String desc;
	
	public String toString() {
		return isbn+"|"+title+"|"+author+"|"+publisher+"|"+price+"|"+desc+"|"+year+"."+month;
		
	}

}
