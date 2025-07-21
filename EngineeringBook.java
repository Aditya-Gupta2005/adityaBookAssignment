package com.bookassignment;

public class EngineeringBook extends Book {
	private String category;

	public EngineeringBook(String title, Author author, double price, String publisher,
        String copyright, int qty, String category) {
		super(title, author, price, publisher, copyright, qty);
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
