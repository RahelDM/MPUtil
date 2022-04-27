package uo.mp2021.util.check;

import java.util.EmptyStackException;

public class EmptyStackCheck {	
	/**
	 * Comprueba si la condición es correcta. Si no lo es, lanza una excepción
	 * de tipo EmptyStackException
	 * @param condition
	 */
	public static void isTrue(boolean condition) {
		if (!condition) {
			throw new EmptyStackException();
		}
	}
	
}
