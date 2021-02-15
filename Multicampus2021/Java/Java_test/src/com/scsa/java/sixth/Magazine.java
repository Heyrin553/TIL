package com.scsa.java.sixth;

public class Magazine {
	
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	private int year;
	private int month;

	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.year = year;
		this.month = month;
	}
	
	

	public Magazine(String isbn, String title, String author, String publisher, int price, int year, int month) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.year = year;
		this.month = month;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year > 1900 & year <= 2021) {
		this.year = year;
		} else {
			System.out.println("출간년도를 정확하게 입력해 주십시오");
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month >= 1 & month <= 12) {
		this.month = month;
		}else {
			System.out.println("출간월을 정확하게 입력해 주십시오");
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
		System.out.println(this.isbn+"|"+this.title+"|"+this.author+"|"+this.publisher+"|"+this.price+"|"+this.desc+"|"+this.year+"."+this.month);
		return this.isbn+"|"+this.title+"|"+this.author+"|"+this.publisher+"|"+this.price+"|"+this.desc+"|"+this.year+"."+this.month;
	}

}
