package doublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
	int size;
	ListNode<T> head;
	ListNode<T> tail;
	public DoublyLinkedList () {
		head = null;
		tail = null;
		//head.next = tail;
		//tail.prev = head;
		size = 0;
	}
	/**
	 * add at head
	 * O(1)
	 * @param obj
	 */
	public void addFirst(T obj) {
		ListNode<T> h = head;
		ListNode<T> node = new ListNode<T> (null, obj, h);
		head = node;
			if (tail == null)
				tail = node;
			else
				h.prev = node;
		size++;
	}
	/**
	 * add at tail
	 * O(1)
	 * @param obj
	 */
	public void addLast(T obj) {
		ListNode<T> t = tail;
		ListNode<T> node = new ListNode<T> (t, obj, null);
		tail = node;
		if (head == null)
			head = node;
		else
			t.next = node;
		size++;
	}
	/**
	 * insert at a desired position
	 * O(n)
	 */
	public void insert(int index, T obj) {
		isPositionIndex(index);
		if (index == 0) {
			addFirst(obj);
			return;
		}
		if (index == size) {
			addLast(obj);
			return;
		}
		ListNode<T> prev = getNode(index - 1);
		ListNode<T> curr = prev.next;
		ListNode<T> toAdd = new ListNode<T>(prev, obj, curr);
		curr.prev = toAdd;
		prev.next = toAdd;
		size++;
		
	}
	/**
	 * remove first element in the list
	 * O(1)
	 * @return
	 */
	public T removeFirst() {
		if (head == null)
			throw new NoSuchElementException("Probably empty list?");
		T obj = head.value;
		ListNode<T> next = head.next;
		head.value = null;
		head.next = null;
		head = next;
		if (next == null)
			tail = null;
		else
			next.prev = null;
		size--;
		return obj;
	}
	/**
	 * remove the last element
	 * O(1) 
	 * @return
	 */
	public T removeLast() {
		if (tail == null)
			throw new NoSuchElementException("Probably empty list?");
		T obj = tail.value;
		ListNode<T> prev = tail.prev;
		tail.value = null;
		tail.prev = null;
		tail = prev;
		if (prev == null)
			head = null;
		else 
			prev.next = null;
		size--;
		return obj;
	}
	/**
	 * remove the element at given index
	 * O(n)
	 * @param index
	 * @return
	 */
	public T remove(int index) {
		isPositionIndex(index);
		if (index == size)
			throw new NoSuchElementException("Probably empty list?");
		if (index == 0) {
			return removeFirst();
		}
		if (index == size - 1) {
			return removeLast();
		}
		ListNode<T> toRemove = getNode(index);
		T obj = toRemove.value;
		ListNode<T> prev = toRemove.prev;
		ListNode<T> next = toRemove.next;
		prev.next = next;
		next.prev = prev;
		toRemove.value = null;
		toRemove.prev = null;
		toRemove.next = null;
		size--;
		return obj;
		
	}
	
	public T getFirst() {
		if (head == null)
			throw new NoSuchElementException("Probably empty list?");
		return head.value;
	}
	public T getLast() {
		if (tail == null)
			throw new NoSuchElementException("Probably empty list?");
		return tail.value;
	}
	public int getSize() {
		return size;
	}
	public void clear() {
		for (ListNode<T> node = head; node != null;) {
			ListNode<T> next = node.next;
			node.value = null;
			node.next = null;
			node = next;
		}
		head = null;
		tail = null;
		size = 0;
	}
	public String toString() {
		ListNode<T> node = head;
		String rst = "";
		while (node != null) {
			rst += String.valueOf(node.value);
			rst += " -> ";
			node = node.next;
		}
		return rst.substring(0, rst.length() - 4);
	}
	
	private ListNode<T> getNode(int index) {
		//in the first half of the list
		//traverse from the head
		if (index < (size >> 1)) {
			ListNode<T> node = head;
			for (int i = 0; i < index; i++)
				node = node.next;
			return node;
		}
		//in the second half
		//traverse from the tail
		else {
			ListNode<T> node = tail;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}
	private boolean isPositionIndex(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index must be greater than 0 and smaller than list size!");
		return true;
	}
	

}
