package uo.mp2021.util.collection.impl;

import java.util.Iterator;

import uo.mp2021.collections.Collection;
import uo.mp2021.collections.List;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.IndexCheck;
import uo.mp2021.util.checks.NoSuchElementsCheck;
import uo.mp2021.util.checks.StatesCheck;

public class ArrayList<T extends Cloneable> implements List<T> {

	private T[] elements;
	private int counter;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		elements = (T[]) new Object[16];
		counter = 0;
		
	}
	
	public ArrayList(Collection<T> collection) {
		elements = collection.toArray();
		
	}
	
	@Override
	public int size() {
		return counter;
		
	}

	@Override
	public boolean isEmpty() {
		return counter == 0;
		
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
		
	}

	@Override
	public boolean add(T element) {
		ArgumentChecks.isTrue(element != null,
				"No se puede añadir un elemento nulo");
		if (isMemoryFull()) {
			addMemory(size()+1);
		}
		elements[counter] = element;
		counter++;
		return true;
		
	}

	@Override
	public boolean remove(T o) {
		ArgumentChecks.isTrue(o != null,
				"No se puede eliminar un elemento nulo");
		int index = this.indexOf(o);
		return index >= 0 ? this.remove(index) != null : false;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public void clear() {
		elements = (T[]) new Object[16];
		counter = 0;
		
	}

	@Override
	public T get(int index) {
		IndexCheck.isTrue(index >= 0 && index < this.size());
		return elements[index];
		
	}

	@Override
	public T set(int index, T element) {
		ArgumentChecks.isTrue(element != null,
				"No se puede añadir un elemento nulo");
		IndexCheck.isTrue(index >= 0 && index < this.size());
		T aux = elements[index];
		elements[index] = element;
		return aux;
		
	}

	@Override
	public void add(int index, T element) {
		ArgumentChecks.isTrue(element != null,
				"No se puede añadir un elemento nulo");
		IndexCheck.isTrue(index >= 0 && index <= this.size());
		if (index == counter) {
			this.add(element);
		} else {
			for (int i = counter - 1; i >= index; i--) {
				elements[i+1] = elements[i];
			}
			elements[index] = element;
			counter++;
		}
		
	}

	@Override
	public T remove(int index) {
		IndexCheck.isTrue(index >= 0 && index < this.size());
		T aux = elements[index];
		for (int i = index; i < elements.length -1; i++) {
			elements[i] = elements[i +1];
		}
		elements[elements.length -1] = null;
		counter--;
		return aux;
		
	}
	
	@Override
	public T[] toArray() {
		return this.elements.clone();
	}

	@Override
	public int indexOf(Object o) {
		int index = -1;
		if (o == null)
			return -1;
		
		if (counter == 0)
			return index;
		
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null && elements[i].equals(o)) {
				index = i;
				break;
			}
		}
		return index;
		
	}
	
	@Override
	public String toString() {
		String string = "[";
		if (this.size() == 0)
			return "[]";
		
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				string += elements[i].toString() + ", ";
			}
		}
		string = string.substring(0, string.length() -2);
		string += "]";
		return string;
		
	}
	
	@Override
	public int hashCode() {
		int hashCode=1;
		for(int i=0; i< this.size(); i++) {
			hashCode = hashCode * 31 + (this.get(i) == null ? 0 : this.get(i).hashCode());
		}
		return hashCode;
		
	}
	
	@Override
	@SuppressWarnings({ "unchecked" })
	public boolean equals(Object o) {
		if (o == null)
			return false;
		
		if (o == this)
			return true;
		
		if (!(o instanceof ArrayList))
			return false;
		
		ArrayList<T> al = (ArrayList<T>) o;
		if (!(al.size() == this.size()))
			return false;
		
		for (int i = 0; i < this.size(); i++) {
			if(!this.get(i).equals(al.get(i)))
				return false;
		}
		
		return true;
	}
	
	private boolean isMemoryFull() {
		if (counter == elements.length)
			return true;
		return false;
		
	}

	@SuppressWarnings("unchecked")
	private void addMemory(int numElem) {
		if (numElem > elements.length) {
			T[] aux = (T[]) new Object[Math.max(numElem, elements.length*2)];
			System.arraycopy(elements, 0, aux, 0, elements.length);
			this.elements = aux;
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator<T>();
	}
	
	@SuppressWarnings("hiding")
	private class ArrayListIterator<T extends Cloneable> implements Iterator<T>{

		private int index = 0;
		private T lastReturned = null;
		
		@Override
		public boolean hasNext() {
			return index < size();
			
		}

		@Override
		@SuppressWarnings("unchecked")
		public T next() {
			NoSuchElementsCheck.isTrue(hasNext(), "No hay mas elementos");
			lastReturned = (T) get(index);
			index++;
			return lastReturned;
			
		}
		
		/**
		 * 
		 */
		@Override
		public void remove() {
			StatesCheck.isTrue(lastReturned != null, "No es posible borrar");
			ArrayList.this.remove(index - 1);
			lastReturned = null;
		}
		
	}

}
