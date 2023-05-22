package com.example.dobbygareview.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorResult {

	DUPLICATE_USER_REGISTER(HttpStatus.BAD_REQUEST, "Duplicated Membership Register Request"),
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "Membership Not found"),
	UNKNOWN_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown Exception"),
	ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, "Item Not Found"),
	NOT_ENOUGH_STOCK(HttpStatus.BAD_REQUEST, "Not Enough Stock");

	private final HttpStatus httpStatus;
	private final String message;
}
