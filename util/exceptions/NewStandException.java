package uo.mp2021.util.exceptions;

@SuppressWarnings("serial")
public class NewStandException extends Exception {

	public NewStandException() {
	}
	public NewStandException(String message) {
		super(message);
	}


	public NewStandException(Throwable cause) {
		super(cause);
	}

	public NewStandException(String message, Throwable cause) {
		super(message, cause);
	}

	public NewStandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}