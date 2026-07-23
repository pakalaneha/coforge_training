package com.coforge.dms.exception;

public class DepartmentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DepartmentNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
