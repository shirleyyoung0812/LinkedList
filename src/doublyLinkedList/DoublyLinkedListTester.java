package doublyLinkedList;

public class DoublyLinkedListTester {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer> ();
		dll.addFirst(1);
		dll.addFirst(3);
		dll.addLast(2);
		dll.addLast(4);
		dll.insert(2, 5);
		//dll.remove(1);
		System.out.println(dll.getLast());
		System.out.println(dll.toString());

	}

}
