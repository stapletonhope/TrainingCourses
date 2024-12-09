package util;

/*
* File name :LinearNode
* Author :Hope Stapleton
* Student number : C23376453
* Description of class :represents a node in a linked list
*/
public class LinearNode<T> {
	private LinearNode<T> next;
	private T element;

	// ---------------------------------------------------------
	// Creates an empty node.
	// ---------------------------------------------------------
	public LinearNode() {
		this.next = null;
		this.element = null;
	}

	// ---------------------------------------------------------
	// Creates a node storing the specified element.
	// ---------------------------------------------------------
	public LinearNode(T elem) {
		this.next = null;
		this.element = elem;
	}

	// ---------------------------------------------------------
	// Returns the node that follows this one.
	// ---------------------------------------------------------
	public LinearNode<T> getNext() {
		return this.next;
	}

	// ---------------------------------------------------------
	// Sets the node that follows this one.
	// ---------------------------------------------------------
	public void setNext(LinearNode<T> node) {
		this.next = node;
	}

	// ---------------------------------------------------------
	// Returns the element stored in this node.
	// ---------------------------------------------------------
	public T getElement() {
		return this.element;
	}

	// ---------------------------------------------------------
	// Sets the element stored in this node.
	// ---------------------------------------------------------
	public void setElement(T elem) {
		this.element = elem;
	}
}
