package doublyLinkedList;

public class ListNode<T> {
	T value;
	ListNode<T> next;
	ListNode<T> prev;
	
	public ListNode(T value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	public ListNode(ListNode<T> prev, T value, ListNode<T> next) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
	
}
