package com.coforge.sms.exception;

public class SupplierNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SupplierNotFoundException(String errorMessage) {
		 super(errorMessage);
	}
}
