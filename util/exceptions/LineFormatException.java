package uo.mp2021.util.exceptions;

@SuppressWarnings("serial")
public class LineFormatException extends Exception {

	private int lineNumber;

	public LineFormatException(int ln, String msg) {
		super(msg);
		lineNumber = ln;
	}

	@Override
	public String getMessage() {
		return "Error en línea" + lineNumber + " " + getMessage();
	}
}
