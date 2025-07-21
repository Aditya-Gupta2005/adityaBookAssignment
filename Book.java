package com.bookassignment;

import java.io.Serializable;

public class Book implements Serializable {
	private final int bookNo;
	private String title;
	private Author author;
	private String publisher;
	private String copyright;
	private double price;
	private int qty;
	private static int bookCount;
	
	static {
		bookCount=0;
	}
	public Book() {
		bookNo=101+bookCount++;
	}
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public static int getBookCount() {
		return bookCount;
	}
	
	public Book(String title,Author author,double price,String publisher,String copyright,
			int qty) {
		this();
			try {
				
				if(title.length()<4) {
					throw new InvalidBookTitleException("Invalid Book Length");
				}
				
				if(price<0.0 || price>5000.0) {
					throw new InvalidBookPriceException("Invalid Book Price");
				}
				
					this.title=title;
					this.author=author;
					this.price=price;
					this.publisher=publisher;
					this.copyright=copyright;
					this.qty=qty;
	
		
				
		}
			catch(InvalidBookTitleException ibte) {
				System.out.println(ibte);
			}
			
			catch(InvalidBookPriceException ibpe) {
				System.out.println(ibpe);
			}
	}
	
	public Author getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
	    if (author != null) {
	        return title + "\t" + author.getName() + "\t" + author.getGender() + "\t" + author.getEmail();
	    } else {
	        return title + "\tAuthor details unavailable";
	    }
	}
	
	public void display() {
	    if (author != null && copyright != null &&
	        (copyright.equalsIgnoreCase("Yes") || copyright.equalsIgnoreCase("Y"))) {
	        
	        System.out.println("Book No      : " + bookNo);
	        System.out.println("Book Title   : " + title);
	        System.out.println("Author Name  : " + author.getName());
	        System.out.println("Author Email : " + author.getEmail());
	        System.out.println("Author Gender: " + author.getGender());
	        System.out.println("Price        : ₹" + price);
	        System.out.println("Publisher    : " + publisher);
	    } else {
	        System.err.println("Cannot display book details — Author or Copyright missing");
	    }
	}
	
	//SearchBookfunctionality
	public static void searchBook(Book[] bookArr,int targetBookNo) {
		try {
		boolean flag=false;
		
		for(Book b: bookArr) {
			if(b.bookNo==targetBookNo) {
				flag=true;
				System.out.println("Book Found at "+targetBookNo);
				System.out.println(b.toString());
				break;
			}
			
		}
		
		
		
		if(!flag) {
			throw new BookIdNotFoundException("Book with "+ targetBookNo+" doesn't exists");
		}
		
		}
		catch(BookIdNotFoundException binfe) {
			System.out.println(binfe);
		}
	}
}
