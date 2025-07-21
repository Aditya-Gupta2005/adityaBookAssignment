package com.bookassignment;

public class InvalidBookPriceException extends RuntimeException {
	InvalidBookPriceException(String msg){
		super(msg);
	}
}
