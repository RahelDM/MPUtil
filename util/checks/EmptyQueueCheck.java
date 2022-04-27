package uo.mp2021.util.checks;

import java.util.NoSuchElementException;

public class EmptyQueueCheck {	
	/**
	 * Comprueba si la condición es correcta. Si no lo es, lanza una excepción
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
