package util;

/*
* File name :LinkedListADT
* Author :Hope Stapleton
* Student number : C23376453
* Description of class :interface for LinkedList, defines method headings needed for a linked list.

*/
public interface LinkedListADT<T> {
	// 1. Add a generic object to the end of a list
	public void add(T element);

	// 2. Add a generic object in its correct sorted position in the list
	public void add(T element, int position);

	// 3. Delete any object from the list where the object is passed in as a
	// parameter
	public T remove(T element);

	// 4. Display all object data in the list
	public String toString();

	// 5. Return the first linear node in the list
	public LinearNode<T> getFirstNode();

	// 6. Return the last linear node in the list
	public LinearNode<T> getLastNode();

	// 7. Return the first element in the list
	public T getFirst();

	// 8. Return the last element in the list
	public T getLast();

	// 9. Return the next element in the list (where the current element is input
	// into the method as a parameter).
	public T getNext(T element);

	// 10. Check to see if the list is empty
	public boolean isEmpty();

	// 11. Check to see if the list already contains a generic object input as a
	// parameter and returns a boolean
	public boolean contains(T element);
	
	//12. Include another function into this linked list class that you will call in your driver class.
	public T get(int i);
	
	// Removes and returns the first element from this list
	public T remove();

	// Returns the number of elements in this list
	public int size();

}
