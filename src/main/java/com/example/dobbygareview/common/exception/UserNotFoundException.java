package com.example.dobbygareview.common.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String email) {
		super(email + " NotFoundException");
	}
}
