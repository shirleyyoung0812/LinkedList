package singlyLinkedListwithSentinel;
/**
 * ListNode that will be used in the linked list
 * @author shirleyyoung
 *
 * @param <T>
 */
public class ListNode<T> {
	private T value;
	private ListNode<T> next;
	
	public ListNode(T value) {
		this.value = value;
		this.next = null;
	}
	public T getValue() {
		return value;
	}
	public ListNode<T> getNext() {
		return next;
	}
	public void setValue (T value) {
		this.value = value;
	}
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
	public boolean equals(ListNode<T> node) {
		return value == node.value;
	}
}
