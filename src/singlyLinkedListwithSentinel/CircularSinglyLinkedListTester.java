package singlyLinkedListwithSentinel;

public class CircularSinglyLinkedListTester {

	public static void main(String[] args) {
		CircularSinglyLinkedList<Integer> csll = new CircularSinglyLinkedList<Integer> ();
		csll.add(1);
		//ListNode<Integer> s = new ListNode<Integer> (null);
		//System.out.println(s.getValue());
		csll.add(2);
		csll.add(3);
		csll.addFirst(5);
		csll.add(4);
		System.out.println(csll.toString());
		System.out.println(csll.getCurrent());
		System.out.println(csll.next());
		System.out.println(csll.getFirst());
		csll.add(3, 6);
		System.out.println(csll.getCurrent());
		System.out.println(csll.toString());
		

	}

}
