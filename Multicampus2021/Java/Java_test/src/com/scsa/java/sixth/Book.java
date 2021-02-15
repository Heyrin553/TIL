package com.scsa.java.sixth;

public class Book {
	
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	


	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	

	public Book(String isbn, String title, String author, String publisher, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (isbn.length() == 5) {
		this.isbn = isbn;
		} else {
			System.out.println("도서 번호를 정확하게 입력해 주십시오");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title != null) {
		this.title = title;
		} else {
			System.out.println("도서 제목을 정확하게 입력해 주십시오");
		}
	
		
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(author != null) {
			this.author = author;
			
		}else {
			System.out.println("저자명을 정확하게 입력해 주십시오");
			
		}
		
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		if(publisher != null) {
			this.publisher = publisher;
			}else {
				System.out.println("출판사명을 정확하게 입력해 주십시오");
			}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price > 0) {
			this.price = price;
		}else {
			System.out.println("가격을 정확하게 입력해 주십시오");
		}
		
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		if(desc == null) {
			System.out.println(" ");
		}else {
		this.desc = desc;
		}
	}

	
	@Override
	public String toString() {
		System.out.println(this.isbn+"|"+this.title+"|"+this.author+"|"+this.publisher+"|"+this.price+"|"+this.desc);
		return this.isbn+"|"+this.title+"|"+this.author+"|"+this.publisher+"|"+this.price+"|"+this.desc;
	}
}
