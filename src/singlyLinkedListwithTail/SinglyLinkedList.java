package singlyLinkedListwithTail;
/*
 * This implementation can perform
 * retrieval and removal in FIFO 
 * order:
 * addLast & removeFirst
 */
public class SinglyLinkedList<T> {
	protected ListNode<T> head;
	protected ListNode<T> tail;
	protected long size;
	
	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	/**
	 * add to the head
	 */
	public void add(T value) {
		ListNode<T> node = new ListNode<T> (value);
		//if no node is in the list, 
		//set the tail to the first node added to the list
		if (tail == null)
			tail = node;
		node.setNext(head);
		head = node;
		size++;
	}
	/**
	 * insert a node at desired position
	 * @param curr
	 * @param toInsert
	 * O(n)
	 */
	public void insert(int index, T value) {
		if (index < 0 || index > size - 1)
			throw new IllegalArgumentException("index must be greater than 0 and less than number of elements in the list!");
		
		if (index == 0) {
			add(value);
			return;
		}
		if (index == size - 1) {
			addLast(value);
			return;
		}
		ListNode<T> toInsert = new ListNode<T> (value);
		ListNode<T> prev = getNode(index - 1);
		ListNode<T> next = prev.getNext();
		prev.setNext(toInsert);
		toInsert.setNext(next);
	}
	
	
	/**
	 * add the node at tail
	 * O(1)
	 */
	public void addLast(T value) {
		ListNode<T> node = new ListNode<T> (value);
		if (head == null) {
			head = node;
		}
		else {
			tail.setNext(node);
		}
		node.setNext(null);
		tail = node;
		size++;
	}
	/**
	 * remove the first element in the list
	 * O(n)
	 * @return
	 */
	public ListNode<T> removeFirst() {
		if (head == null)
			throw new NullPointerException("Empty list!");
		ListNode<T> tmp = head;
		head = head.getNext();
		tmp.setNext(null);
		size--;
		return tmp;
	}
	/**
	 * need to traverse the list
	 * @return
	 */
	public ListNode<T> removeLast() {
		if (size == 0)
			throw new NullPointerException("Empty list!");
		ListNode<T> node = head;
		ListNode<T> toRemove = tail;
		while (!node.getNext().equals(tail))
			node = node.getNext();
		node.setNext(null);
		tail = node;
		size--;
		return toRemove;	
	}
	/**
	 * remove a node
	 * @param node
	 * O(n)
	 */
	public void remove(ListNode<T> toRemove) {
		if (size == 0)
			throw new NullPointerException("Empty list!");
		if (toRemove.equals(head))
			removeFirst();
		if (toRemove.equals(tail))
			removeLast();
		ListNode<T> node = head;
		while (node != null && !node.getNext().equals(toRemove)) {
			node = node.getNext();
		}
		if (node == null)
			throw new IllegalArgumentException("No such element in the list!");
		node.setNext(node.getNext().getNext());
	}
	public ListNode<T> getFirst() {
		return head;
	}
	public ListNode<T> getLast() {
		return tail;
	}
	public long getSize() {
		return size;
	}
	public void clear() {
		for (ListNode<T> node = head; node != null;) {
			ListNode<T> next = node.getNext();
			node.setValue (null);
			node.setNext(null);
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
			rst += String.valueOf(node.getValue());
			rst += " -> ";
			node = node.getNext();
		}
		return rst.substring(0, rst.length() - 4);
	}
	private ListNode<T> getNode(int index) {
		int count = 0;
		if (index == size - 1)
			return tail;
		if (index == 0)
			return head;
		ListNode<T> node = head;
		while (count < index && node != null) {
			node = node.getNext();
			count++;
		}
		return node;
	}
}
