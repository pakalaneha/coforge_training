package com.coforge.ems.exception;

public class InvalidEmployeeObjectException extends RuntimeException {

   public InvalidEmployeeObjectException(String errorMessage) {
	   super(errorMessage);
   }
}