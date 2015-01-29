package singlyLinkedListwithTail;

public class SinglyLinkedListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer> ();
		sll.addLast(1);
		sll.addLast(2);
		sll.addLast(3);
		sll.addLast(4);
		sll.add(5);
		sll.addLast(7);
		sll.insert((int)sll.getSize() - 1, 6);
		System.out.println(sll.toString());
	}

}
