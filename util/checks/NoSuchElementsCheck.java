/**
 * 
 */
package uo.mp2021.util.checks;

import java.util.NoSuchElementException;

/**
 * @author Raquel
 *
 */
public class NoSuchElementsCheck {
	/**
	 * Comprueba si la condici�n es correcta. Si no lo es, lanza una excepci�n
	 * de tipo NoSuchElementException en la que se env�a el mensaje del 
	 * par�metro
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
	 * Comprueba si la condici�n es correcta. Si no lo es, lanza una excepci�n
	 * de tipo NoSuchElementException
	 * @param condition
	 */
	public static void isTrue(boolean condition) {
		if (!condition) {
			throw new NoSuchElementException();
		}
	}
}
