package uo.mp2021.util.checks;

import java.util.NoSuchElementException;

public class EmptyQueueCheck {	
	/**
	 * Comprueba si la condici�n es correcta. Si no lo es, lanza una excepci�n
	 * de tipo NoSuchElementException
	 * @param condition
	 * @param message
	 */
	public static void isTrue(boolean condition, String msg) {
		if (!condition) {
			throw new NoSuchElementException(msg);
		}
	}
	
}
