package com.vcriate.exception;

public class VcriateException extends RuntimeException {

	public VcriateException() {
		super();
	}

	public VcriateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VcriateException(String message, Throwable cause) {
		super(message, cause);
	}

	public VcriateException(String message) {
		super(message);
	}

	public VcriateException(Throwable cause) {
		super(cause);
	}

}
