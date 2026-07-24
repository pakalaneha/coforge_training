package com.coforge.sms.exception;

public class InvalidSupplierObjectException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidSupplierObjectException(String errorMessage) {
		 super(errorMessage);
	}

}
