package com.bookassignment;

public class InvalidBookTitleException extends RuntimeException {
	InvalidBookTitleException(String msg){
		super(msg);
	}
}
