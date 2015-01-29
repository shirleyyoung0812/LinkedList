
public class CreateList {
	private ListNode head;
	
	public CreateList(ListNode head)
	{
		this.head = head;
	}

	public void clear(ListNode node)
	{
		node.next = null;
		node = null;
	}

	public void insert(ListNode n, ListNode curr)
	{
		if (n == null)
			return;
		
		if(curr == null)
		{
			n.next = head;
			head = n;
		}
		else if(curr.next == null)
			curr.next = n;
		else
		{	
			n.next = curr.next;
			curr.next = n;
		}
		
	}
	
	public ListNode searchNode(int k)
	{
		ListNode curr = head;
	
		int it = 1;
		while (curr.next != null)
		{
			if (it == k)
				return curr;
			curr = curr.next;
			it += 1;
		}
		return curr;
	}
		
	public void insertposi(int k, ListNode n)
	{
		ListNode curr = searchNode (k);
		insert(n,curr);
	}
	
	public int searchposi(int val)
	{
	//	if (head.val == val)
	//		return 1;
		
		ListNode curr = head;
		int it = 1;
		while (curr.next != null)
		{
			if (curr.val == val)
				return it;
			curr = curr.next;
			it += 1;
		}
		return it;
	}
	
	public void insertb4 (ListNode curr, ListNode n)
	{
		int k = searchposi(curr.val);
		insertposi(k-1, n);
	}
	
	
	public void printList(ListNode head)
	{
		if (head == null)
			return;
		
		ListNode curr = head;
		while(curr != null)
		{
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.print(" ");
		
	}

}
