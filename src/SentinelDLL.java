
public class SentinelDLL<T> {
	private Element<T> sentinel; // sentinel, serves as head and tail
	  private Element<T> current;  // current position in the list
	 
	  // A private class representing the elements in the list.
	  private class Element<T> {
	    // Because this is a private inner class, these can be seen from SentinelDLL,
	    // but not from outside SentinelDLL.
	    private T data;                  // reference to data stored in this element
	    private Element<T> next;            // reference to next item in list
	    private Element<T> previous;        // reference to previous item in list
	    
	    // Constructor for a linked list element, given an object.
	    public Element(T obj) {
	      next = previous = null;   // no element before or after this one, yet
	      data = obj;               // OK to copy reference, since obj references an immutable object
	    }

	    // Returns the String representation of a linked list element.
	    public String toString() {
	      return data.toString();
	    }

	    // Returns true if this element and an object obj are equal, false if not equal.
	    // If both are null, consider them equal, and if exactly one is null, they are
	    // definitely not equal.
	    public boolean equals(Object obj) {
	      if (data == null)
	        return obj == null;
	      else if (obj != null)
	        return data.equals(obj);
	      else
	        return false;
	    }
	  }

	  // Constructor for a circular, doubly linked list with a sentinel.
	  // Makes an empty list.
	  public SentinelDLL() {
	    sentinel = new Element<T>(null);
	    System.out.println(sentinel == null ? "Null" : sentinel.data);
	    clear();
	  }

	  // Removes all elements from the list. 
	  public void clear() {
	    // Make the list be empty by having the sentinel point to itself
	    // in both directions.
	    sentinel.next = sentinel.previous = sentinel;
	  
	    // There's only one place to put the current reference...
	    current = sentinel;
	  }

	  // Inserts a new element with given object reference, after the current position.
	  // (If current == sentinel, the new element becomes the new head.)
	  // Makes the new element the current position.
	  public void add(T obj) {
	    Element<T> x = new Element<T>(obj);     // allocate a new element

	    // Splice in the new element.
	    x.next = current.next;
	    x.previous = current;
	    current.next.previous = x;
	    current.next = x;

	    current = x;                        // new element is current position
	  }

	  // Removes the current element.  Makes its successor the current position.
	  // Error if the current element is the sentinel.
	  public void remove() {
	    // Do not ever let the sentinel be deleted!
	    if (current == sentinel)
	      System.err.println("Attempt to delete sentinel!");
	    else {          
	      // Splice out the current element.
	      current.previous.next = current.next;
	      current.next.previous = current.previous;
	        
	      current = current.next;           // make successor the new current
	    }
	  }

	  // Returns the String representation of this list.
	  public String toString() {
	    String result = "";
	    
	    for (Element<T> x = sentinel.next; x != sentinel; x = x.next)    
	      result += x.toString() + "\n"; 
	    
	    return result;
	  }

	  // Finds an object within a circular, doubly linked list with a sentinel.
	  // Returns whether it was found.
	  // If found, sets current to be the element containing the object.
	  // If not found, leaves current alone.
	  public boolean contains(T obj) {
	    Element<T> x;
	  
	    // Since we have a sentinel that isn't being used for a "real" element,
	    // we put the object we are looking for in the sentinel.  That way, we
	    // know we'll find it some time during the search.
	    sentinel.data = obj;
	  
	    for (x = sentinel.next; !x.equals(obj); x = x.next)
	      ;
	  
	    // We dropped out of the loop because we found the target object in an element
	    // that x references.
	    // If we found it in the sentinel, it wasn't really in the list.
	    // If we found it before getting back to the sentinel, it was in the list.

	    // Put the sentinel back into its null state.
	    sentinel.data = null;

	    if (x == sentinel)
	      return false;             // tell the caller that we did not find the object
	    else {
	      current = x;              // remember where we found it
	      return true;              // and tell the caller
	    }
	  }

	  // Returns whether the list is empty.
	  public boolean isEmpty() {
	    return sentinel.next == sentinel;
	  }

	  // Returns first object in the list.
	  // Makes the current element be the head of the list.
	  public T getFirst() { 
	    current = sentinel.next;
	    return get();
	  }

	  // Returns last object in the list.
	  // Makes the current element be the tail of the list.
	  public T getLast() {
	    current = sentinel.previous;
	    return get();
	  }

	  // Inserts a new element at the head of a circular, doubly linked list with a sentinel.
	  // Makes it the current item.
	  public void addFirst(T obj) {
	    current = sentinel;
	    add(obj);
	  }

	  // Inserts a new element at the tail of a circular, doubly linked list with a sentinel.
	  // Makes it the current item.
	  public void addLast(T obj) {
	    current = sentinel.previous;
	    add(obj);
	  }
	  
	  // Returns the current item.  Error if there is no current item.
	  public T get() {
	    if (current == sentinel) {
	      System.err.println("No current item to return");
	      return null;
	    }
	    else
	      return (T) current.data;
	  }
	  
	  // Sets current item's data to obj.  
	  // Error if there is no current item.
	  public void set(T obj) {
	    if (current == sentinel)
	      System.err.println("No current item to set");
	    else
	      current.data = obj;
	  }
	  
	  // Returns next object in the list.
	  // Moves current to the next position.  Error if there is no next item.
	  public T next() {
	    if (hasNext()) {
	      current = current.next;
	      return (T) current.data;
	    }
	    else {
	      System.err.println("No next item");
	      return null;
	    }
	  }
	  
	  // Returns true if there is a next item (current item is
	  // not the last item in the list).
	  public boolean hasNext() {
	    return current.next != sentinel;
	  }

}
