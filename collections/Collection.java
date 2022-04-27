package uo.mp2021.collections;



/**
 * The root interface in the <i>collection hierarchy</i>. A collection
 * represents a group of objects, known as its <i>elements</i>. Some collections
 * allow duplicate elements and others do not. Some are ordered and others
 * unordered. This interface is typically used to pass collections around and
 * manipulate them where maximum <i>generality</i> is desired.
 */
public interface Collection<T> extends Iterable<T>{

	/**
	 * Returns the number of elements in this collection.
	 *
	 * @return the number of elements in this collection
	 */
	int size();

	/**
	 * Returns {@code true} if this collection contains no elements.
	 *
	 * @return {@code true} if this collection contains no elements.
	 */
	boolean isEmpty();

	/**
	 * Returns {@code true} if this collection contains the specified element.
	 * More formally, returns {@code true} if and only if this collection
	 * contains at least one element e such that
	 * {@code (o == null ? e == null : o.equals(e))}.
	 * 
	 * @param o, the element whose presence in this collection is to be tested
	 * @return {@code true} if this collection contains the specified element
	 */
	boolean contains(Object o);

	/**
	 * Appends the specified element to this collection, thus ensuring that this
	 * collection contains the specified element (optional operation). 
	 * 
	 * Returns {@code true} if this collection changed as a result of the call. 
	 * Returns {@code false} if this collection does not permit duplicates and 
	 * already contains the specified element.)
	 * <p>
	 * 
	 * Collections that support this operation may place limitations on what
	 * elements may be added to this collection. In particular, some collections
	 * will refuse to add {@code null}, and others will impose restrictions on
	 * the type of elements that may be added. Collection classes should clearly
	 * specify in their documentation any restrictions on what elements may be
	 * added.
	 * <p>
	 *
	 * If a collection refuses to add a particular element for any reason other
	 * than that it already contains the element, it <i>must</i> throw an
	 * exception (rather than returning {@code false}). This preserves the
	 * invariant that a collection always contains the specified element after
	 * this call returns.
	 *
	 * @param element, the element to be appended to this collection
	 * @return {@code true} if this collection changed as a result of the call
	 * 
	 * @throws IllegalArgumentException
	 *             if the specified element is null and this collection does not
	 *             permit null elements
	 */
	boolean add(T element);

	/**
	 * Removes a single instance of the specified element from this collection,
	 * if it is present. 
	 * More formally, removes an element 
	 * {@code e} such that {@code o == null ? o == null : o.equals(e))}, 
	 * if this collection contains one or more such elements. 
	 * 
	 * @param o, the element to be removed from this collection, if present
	 * 
	 * @return {@code true} if an element was removed as a result of this call
	 */
	boolean remove(T o);

	/**
	 * Removes all of the elements from this collection.
	 * The collection will be empty after this method returns.
	 */
	void clear();

	/**
	 * Returns a string representation of this collection. The string
	 * representation consists of a list of the collection's elements, enclosed
	 * in square brackets (<tt>"[]"</tt>).
	 *  
	 * Adjacent elements are separated by the characters 
	 * <tt>", "</tt> (comma and space).
	 *  
	 * Elements are converted to strings as by invoking their 
	 * {@code toString} method.
	 *
	 * @return a string representation of this collection
	 */
	String toString();
	
	/**
	 * Returns an array with the elements of the colection in the same order
	 * @return copy of the collection in array format
	 */
	T[] toArray();
	
	
//	public class TransactionParser {
//
//		@SuppressWarnings("unused")
//		private int lineNumber = 1;
//
//		public List<Transaction> parse(List<String> lines) {
//			ArgumentChecks.isNotNull(lines);
//			List<Transaction> transactions = new ArrayList<>();
//			for (String line : lines) {
//				try {
//					transactions.add(parseLine(line));
//				} catch (InvalidLineException e) {
//					// Logger.log("PARSING ERROR en línea " + lineNumbre + ":" + e.getMessage());
//					// Logger.log(lineaNumber, e.getMessage());
//				}
//				lineNumber++;
//
//			}
//
//			return null;
//		}
//
//		private Transaction parseLine(String line) throws InvalidLineException {
//			checkIsBlank(line);
//			String[] parts = line.split(";");
//			String type = parts[0];
//			if (parts[0].equals("cc")) {
//				return parseCreditCard(parts);
//			} else if (type.equals("acc")) {
//				return parseCurrentAccount(parts);
//			} else {
//				throw new InvalidLineException("PALABRA CLAVE NO VÁLIDA");
//			}
//
//		}
//
//		private void checkIsBlank(String line) throws InvalidLineException {
//			if (line.isBlank()) {
//				throw new InvalidLineException("LÍNEA VACÍA");
//			}
//		}

//		private Transaction parseCreditCard(String[] parts) throws InvalidLineException {
//			checkFields(parts, 7);
//			checkDate(parts[1]);
//			String date = parts[1];
//			String cardNumber = parts[2];
//			String dueDate = parts[3];
//			double maxAmount = toDouble(parts[4]);
//			double amount = toDouble(parts[5]);
//			String description = parts[6];
//
//			return new CredidCardTransaction(date, cardNumber, dueDate, maxAmount, amount, description);
//
//		}
//
//		private void checkFields(String[] parts, int i) {
//
//		}
//
//		private void checkDate(String string) throws InvalidLineException {
//			String[] parsDate = string.split("/");
//
//			if (parsDate.length != 3) {
//				throw new InvalidLineException("FORMATO DE FECHA INVÁLIDO ");
//			}
//			checkYear(parsDate[0]);
//			checkMonth(parsDate[1]);
//			checkDay(parsDate[2]);
//
//		}
//
//		private void checkYear(String string) throws InvalidLineException {
//			if (string.length() != 4) {
//				throw new InvalidLineException("FORMATO DE FECHA INVÁLIDO ");
//			}
//			try {
//				int year = Integer.parseInt(string);
//				if(year!= 2021) {
//					throw new InvalidLineException("FORMATO DE FECHA INVÁLIDO ");
//				}
//			} catch (NumberFormatException e) {
//				throw new InvalidLineException("FORMATO DE FECHA INVÁLIDO ");
//			}
//		}
//
//		private double toDouble(String string) throws InvalidLineException {
//			try {
//				return Double.parseDouble(string);
//			} catch (NumberFormatException e) {
//				throw new InvalidLineException("FORMATO DE NÚMERO NO VÁLIDO");
//			}
//		}
//
//		private Transaction parseCurrentAccount(String[] parts) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		private void checkDay(String string) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		private void checkMonth(String string) {
//			// TODO Auto-generated method stub
//			
//		}
//
//	}

}
