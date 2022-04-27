package uo.mp2021.util.exceptions;

@SuppressWarnings("serial")
public class InvalidFileNameException  extends NewStandException {

	public InvalidFileNameException() {
	}

	public InvalidFileNameException(String message) {
		super("El nombre del fichero " + message + " no es correcto.");
	}

	public InvalidFileNameException(Throwable cause) {
		super(cause);
	}

	public InvalidFileNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFileNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
