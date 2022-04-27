package uo.mp2021.util.collection.impl;

import java.util.Iterator;

import uo.mp2021.collections.List;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.IndexCheck;
import uo.mp2021.util.checks.NoSuchElementsCheck;
import uo.mp2021.util.checks.StatesCheck;

public class LinkedList<T> implements List<T> {
	protected Node<T> head;
	protected int counter;
	
	public LinkedList() {
		head = null;
		counter = 0;
	}
	
	/*
	@SuppressWarnings("unchecked")
	public LinkedList(Collection<T> collection) {
		Iterator<T> it = collection.iterator();
		while(it.hasNext()) {
			this.add((T) it.next().clone());
		}
	}
	*/

	@Override
	public int size() {
		return counter;
		
	}
	
	@Override
	public boolean isEmpty() {
		return head == null;
		
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
		
	}
	
	@Override
	public boolean add(T element) {
		ArgumentChecks.isTrue(element != null,
				"No se puede añadir un elemento nulo");
		if (head == null) {
			addFirst(element);
		} else {
			Node<T> last = getNode(size() - 1);
			last.next = new Node<T>(element, null);
			counter++;
		}
		return true;
		
	}
	
	@Override
	public boolean remove(T o) {
		ArgumentChecks.isTrue(o != null,
				"No se puede eliminar un elemento nulo");
		int pos = indexOf(o);
		if (pos < 0)
			return false;
		
		this.remove(pos);
		return true;
		
	}	
	
	@Override
	public void clear() {
		this.head = null;
		this.counter = 0;
	}
	
	@Override
	public T get(int index) {
		IndexCheck.isTrue(index >= 0 && index < this.size());
		return getNode(index).value;
		
	}
	
	@Override
	public T set(int index, T element) {
		IndexCheck.isTrue(index >= 0 && index < this.size());
		ArgumentChecks.isTrue(element != null,
				"No se puede añadir un elemento nulo");
		Node<T> aux = getNode(index);
		T auxElement = aux.value;
		aux.value = element;
		return auxElement;
		
	}
	
	@Override
	public void add(int index, T element) {
		ArgumentChecks.isTrue(element != null,
				"No se puede añadir un elemento nulo");
		IndexCheck.isTrue(index >= 0 && index <= this.size());
		if (index == 0) {
			addFirst(element);
		} else {
			Node<T> previous = getNode(index - 1);
			previous.next = new Node<T>(element, previous.next);
			counter++;
		}
		
	}
	
	@Override
	public T remove(int index) {
		IndexCheck.isTrue(index >= 0 && index < this.size());
		T aux;
		if (index == 0) {
			aux = head.value;
			head = head.next;
		} else {
			Node<T> previous = getNode(index - 1);
			aux = previous.next.value;
			previous.next = previous.next.next;
		}
		counter--;
		return aux;
		
	}
	
	@Override
	//@SuppressWarnings("unchecked")
	public T[] toArray() {
		/*
		Node<T> currentElement = head;
		T[] array = (T[]) new Object[this.size()];
		int counter = 0;
		
		do {
			try {
				array[counter] = (T) currentElement.value.clone();
			} catch (Exception e) {
				e.printStackTrace();
			}
			currentElement = currentElement.next;
			counter++;
		} while(currentElement != null);
		*/
		return null;
	}
	
	@Override
	public int indexOf(Object o) {
		Node<T> aux = head;
		int index = 0;
		if (o == null)
			return -1;
		
		while(aux != null && !aux.value.equals(o)) {
			aux = aux.next;
			index++;
		}
		return aux == null ? -1 : index;
		
	}
	
	@Override
	public String toString() {
		String string = "[";
		if (this.size() == 0)
			return "[]";
		
		for (int i = 0; i < this.size(); i++) {
			Node<T> node = this.getNode(i);
			if (node.value != null) {
				string += node.toString() + ", ";
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
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (o == null)
			return false;
		
		if (o == this)
			return true;
		
		if (!(o instanceof LinkedList))
			return false;
		
		LinkedList<T> ll = (LinkedList<T>) o;
		if (!(ll.size() == this.size()))
			return false;
		
		for (int i = 0; i < this.size(); i++) {
			if (!this.get(i).equals(ll.get(i))) {
				return false;
			}
		}
		
		return true;
		
	}

	private Node<T> getNode(int index) {
		Node<T> aux = head;
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		return aux;
		
	}	
	
	private void addFirst(T value) {
		head = new Node<T>(value, head);
		counter++;
		
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>();
		
	}
	
	@SuppressWarnings("hiding")
	private class Node<T> {	
		protected T value;
		protected Node<T> next;
		
		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return this.value.toString();
			
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object o) {
			if (o == null)
				return false;
			
			if (o == this)
				return true;
			
			if (!(o instanceof Node))
				return false;
			
			Node<T> node = (Node<T>) o;
			if (this.value.equals(node.value))
				return true;
			
			return false;
			
		}
		
	}
	
	@SuppressWarnings("hiding")
	private class LinkedListIterator<T>implements Iterator<T>{

		private int nextIndex = 0;
		private Node<T> lastReturned = null;
		@SuppressWarnings("unchecked")
		private Node<T> next =(Node<T>) LinkedList.this.head;
		
		@Override
		public boolean hasNext() {
			return next != null;
			
		}

		@Override
		public T next() {
			NoSuchElementsCheck.isTrue(hasNext(), "No hay mas elementos");
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.value;
		}
		
		/**
		 * Elimina el ultimo elemento devuelto
		 * Solo se puede llamar si previamente ha invocado, al menos una vez, 
		 * al metodo next
		 */
		@Override
		public void remove() {
			StatesCheck.isTrue(lastReturned != null, "No es posible borrar");
			LinkedList.this.remove(nextIndex - 1);
			lastReturned = null;
		}
		
	}
	
}

