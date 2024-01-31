package org.rak.fee.exception;

public class ApplicationException extends RuntimeException{

	String code;

	public ApplicationException(String code, String message) {
		this(code, message, null);
	}

	public ApplicationException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
}
