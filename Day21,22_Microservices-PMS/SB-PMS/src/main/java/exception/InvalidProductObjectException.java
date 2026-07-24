package com.coforge.pms.exception;

public class InvalidProductObjectException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidProductObjectException(String errorMessage) {
		 super(errorMessage);
	}

}
