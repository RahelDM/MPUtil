package uo.mp2021.util.exceptions;

@SuppressWarnings("serial")
public class AlreadyExistException extends NewStandException {

	public AlreadyExistException() {
	}

	public AlreadyExistException(String message) {
		super("La publicación "+ message + " ya existe");
	}

	public AlreadyExistException(Throwable cause) {
		super(cause);
	}

	public AlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
