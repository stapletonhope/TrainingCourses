package util;

/*
* File name :LinkedList
* Author :Hope Stapleton
* Student number : C23376453
* Description of class :implementation of a linked list with common operations like add, remove and search elements. 
*/
public class LinkedList<T> implements LinkedListADT<T> {

	private int count; // the current number of elements in the list
	private LinearNode<T> front; // pointer to the first element
	private LinearNode<T> last; // pointer to the last element

	// -----------------------------------------------------------------
	// Creates an empty list.
	// -----------------------------------------------------------------
	public LinkedList() {
		this.count = 0;
		this.last = null;
		this.front = null;
	}

	// 1. Add a generic object to the end of a list only if the object doesn't
	// already exist

	public void add(T element) {
		LinearNode<T> node = new LinearNode<T>(element);

		if (size() == 0) {
			this.last = node; // This is the last and the
			this.front = node; // first node
			this.count++;
		} // end if
		else {
			last.setNext(node); // add node to the end of the list
			last = node; // now make this the new last node.

			this.count++;
		} // end else
	}

	//2. Add a generic object in its correct sorted position in the list
	public void add(T element, int position) {
		LinearNode<T> node = new LinearNode<T>(element);
		if (size() == 0) {
			this.last = node;
			this.front = node;
			this.count++;
		} else {
			this.last.setNext(node);
			this.last = node;
			count++;
		}
	}

	// Removes and returns the first element from this list
	public T remove() {
		LinearNode<T> temp = null;
		T result = null;
		if (isEmpty()) {
			System.out.println("There are no nodes in the list");
		} // end if
		else {

			result = this.front.getElement();
			temp = this.front;
			this.front = this.front.getNext();
			temp.setNext(null); // dereference the original first element
			count--;
		} // end else
		return result;

	}

	//3. Delete any object from the list where the object is passed in as a parameter
	public T remove(T element) {
		LinearNode<T> current = front;
		LinearNode<T> previous = null;

		T result = null;
		while (current != null && !current.getElement().equals(element)) {
			previous = current;
			current = current.getNext(); // move to the next node
		}
		if (current == null) {
			return null; // if element not found, return null
		}
		if (current == front) {
			front = current.getNext();// if the element is the first node
		} else if (current == last) {
			last = previous;// if the element is the last node
			last.setNext(null);
		} else {
			previous.setNext(current.getNext());// otherwise, remove it from middle
		}
		result = current.getElement();
		count--;
		return result;
	}

//4. Display all object data in the list
	public String toString() {
		LinearNode<T> current = null;
		String fullList = "";

		for (current = this.front; current != null; current = current.getNext()) {
			fullList = fullList + "\n" + current.getElement().toString();
		} // end for

		return fullList + "\n";
	}

	// 5. Return the first linear node in the list
	public LinearNode<T> getFirstNode() {
		if (isEmpty()) {
			System.out.println("There are no nodes in the list");
			return null;
		}
		System.out.println(this.front);
		return this.front;
	}

	// 6. Return the last linear node in the list
	public LinearNode<T> getLastNode() {
		if (isEmpty()) {
			System.out.println("There are no nodes in the list");
			return null;
		}
		System.out.println(this.last);
		return this.last;
	}

	// 7. Return the first element in the list,
	public T getFirst() {
		T first = null;
		if (isEmpty()) {
			System.out.println("There are no elements in the list");
		} else {
			first = this.front.getElement();
		}
		return first;
	}

	// 8. Return the last element in the list
	public T getLast() {
		T last = null;
		if (isEmpty()) {
			System.out.println("There are no elements in the list");
		} else {
			last = this.last.getElement();
		}
		return last;
	}

	// 9. Return the next element in the list (where the current object is
	// input into the method as a parameter).
	public T getNext(T element) {
		T next = null;
		LinearNode<T> current = front;
		if (isEmpty()) {
			System.out.println("There are no nodes in the list");
		} else {
			while ((!current.getElement().equals(element)) && (current != null))
				;
			{
				current = current.getNext();
			}
			if (current == last) {
				current = null;
			} else {
				current = current.getNext();
			}
			next = current.getElement();
		}
		return next;
	}

	//10. Check to see if the list is empty
	public boolean isEmpty() {
		if (this.front == null)
			return true;
		else
			return false;
	}

	// 11. Check to see if the list already contains a generic object
	public boolean contains(T element) {
		boolean found = false;
		LinearNode<T> current;

		if (front.getElement().equals(element)) {
			found = true;
		} else {
			current = front.getNext();
			for (int look = 0; look < count && !found; look++)
				if (current.getElement().equals(element))
					found = true;
				else {
					current = current.getNext();
				}
			if (!found)
				found = false;

		}
		return found;
	}

	public T get(int i) {
		if (i < 0 || i >= this.count) {
			return null;
		}
		LinearNode<T> current = this.front;
		for (int x = 0; x < i; x++) {
			current = current.getNext();
		}
		return current.getElement();
	}

	// Method to get size of the list
	public int size() {
		return this.count;

	}

}
