/**
 * 
 */
package uo.mp2021.util.check;

import java.util.NoSuchElementException;

/**
 * @author Raquel
 *
 */
public class NoSuchElementsCheck {
	/**
	 * Comprueba si la condición es correcta. Si no lo es, lanza una excepción
	 * de tipo NoSuchElementException en la que se envía el mensaje del 
	 * parámetro
	 * 
	 * @param condition
	 * @param msg
	 */
	public static void isTrue(boolean condition, String msg) {
		if (!condition) {
			throw new NoSuchElementException(msg);
		}
	}
	
	/**
	 * Comprueba si la condición es correcta. Si no lo es, lanza una excepción
	 * de tipo NoSuchElementException
	 * @param condition
	 */
	public static void isTrue(boolean condition) {
		if (!condition) {
			throw new NoSuchElementException();
		}
	}
}
