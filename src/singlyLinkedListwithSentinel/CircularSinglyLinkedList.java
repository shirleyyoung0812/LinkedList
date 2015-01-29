package singlyLinkedListwithSentinel;
/**
 * this class implements a circular singly linked list
 * since it's a circular list, there is no "head" and "tail"
 * a pointer points to the current location
 * any operation will set the current node to the desired node
 * Note this class does not include addLast() and removeLast() method
 * a "tail" pointer can be added to perform the these two operations
 * @author shirleyyoung
 *
 * @param <T>
 */
public class CircularSinglyLinkedList<T> {
	private ListNode<T> sentinel;
	private ListNode<T> current;
	private long size;
	
	/**
	 * construct a new list
	 * current points to sentinel
	 */
	public CircularSinglyLinkedList () {
		sentinel = new ListNode<T> (null);
		//current = sentinel;
		//current.setNext(sentinel);
		clear();
		size = 0;
		//System.out.println("Construct an empty list!");
		//System.out.println(sentinel == null ? "sentinel equals null" : current.getValue());
	}
	public void clear() {
		sentinel.setNext(sentinel);
		current = sentinel;
		size = 0;
	}
	/**
	 * insert an element after the current position
	 * @param value
	 * O(1)
	 */
	public void add(T value) {
		ListNode<T> node = new ListNode<T> (value);
		//System.out.println(node.getValue());
		node.setNext(current.getNext());
		//System.out.println(node.getNext() == null ? "Null" : node.getNext().getValue());
		current.setNext(node);
		//System.out.println(current.getNext() == null ? "Null" : current.getNext().getValue());
		current = node;
		size++;
	}
	/**
	 * add at desired position
	 * @param index
	 * @param value
	 * O(n)
	 */
	public void add(int index, T value) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Index must be greater than zero and less than list size!");
		if (index == 0)
			addFirst(value);
		int count = 0;
		ListNode<T> node = sentinel.getNext();
		while (node != sentinel && count < index - 1) {
			node = node.getNext();
			count++;
		}
		ListNode<T> toAdd = new ListNode<T> (value);
		toAdd.setNext(node.getNext().getNext());
		node.setNext(toAdd);
		current = toAdd;
		size++;
	}
	/**
	 * add at the head
	 * O(1)
	 * @param value
	 */
	public void addFirst(T value) {
		current = sentinel;
		add(value);
		size++;
	}
	/**
	 * remove the node at current position
	 * makes its successor the current position
	 * singly linked list, need to traverse the list
	 * O(1)
	 */
	public void remove() {
		if (sentinel.getNext() == sentinel) 
			throw new NullPointerException("Empty list!");
		ListNode<T> node = sentinel;
		while (node.getNext() != current)
			node = node.getNext();
		node.setNext(current.getNext());
		current = current.getNext();
	}
	
	
	/**
	 * if an object is in the list
	 * Note it returns the first occurrence of the object
	 * @param value
	 * @return
	 * O(n)
	 */
	public boolean contains(T value) {
		//put the  value in sentinel, if the value cannot be 
		//found in the list, then the node will return to sentinel
		sentinel.setValue(value);
		ListNode<T> node = sentinel.getNext();
		while (node.getValue() != value) 
			node = node.getNext();
		if (node == sentinel)
			return false;
		sentinel.setValue(null);
		//set current node to the desired node
		current = node;
		return true;
	}
	public boolean isEmpty() {
		return sentinel.getNext() == sentinel;
	}
	/**
	 * return the current object
	 * @return
	 * O(1)
	 */
	public T getCurrent() {
		if (current == sentinel)
			throw new NullPointerException("Empty list!");
		return current.getValue();
	}
	/**
	 * get the first object in the list
	 * makes the current be the head of the list
	 * @return
	 */
	public T getFirst() {
		current = sentinel.getNext();
		return getCurrent();
	}
	
	
	/**
	 * set the value of the current element
	 */
	public void setCurrent(T value) {
		if (current == sentinel)
			throw new NullPointerException("Empty list!");
		current.setValue(value);
	}
	/**
	 * return the next object after the current element
	 * @return
	 */
	public T next() {
		if (!hasNext()) {
			System.err.println("No next element!");
			return null;
		}
		current = current.getNext();
		return current.getValue();
	}
	public boolean hasNext() {
		return current.getNext() != sentinel;
	}
	public String toString() {
		ListNode<T> node = sentinel;
		//System.out.println(node == null ? "Null" : node.getValue());
		String rst = "";
		node = node.getNext();
		while (node != sentinel) {
			rst += String.valueOf(node.getValue());
			rst += " -> ";
			node = node.getNext();
		}
		return rst.substring(0, rst.length() - 4);
	}
}
