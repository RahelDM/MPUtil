package uo.mp2021.util.exceptions;

@SuppressWarnings("serial")
public class NotExistException extends NewStandException {

	public NotExistException() {

	}

	public NotExistException(String message) {
		super("La publicación " + message + " no existe.");
	}

	public NotExistException(Throwable cause) {
		super(cause);
	}

	public NotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
