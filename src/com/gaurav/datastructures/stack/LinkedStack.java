package com.gaurav.datastructures.stack;

import com.gaurav.datastructures.linkedLists.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {
	private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

	public LinkedStack() {
	} 															// new stack relies on the initially empty list

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void push(E element) {
		list.addFirst(element);
	}

	public E top() {
		return list.first();
	}

	public E pop() {
		return list.removeFirst();
	}
	
	public static void main(String args[]) {
		LinkedStack linkedStack = new LinkedStack();
		
		linkedStack.push(1);
		linkedStack.push(2);
		linkedStack.push(3);
		linkedStack.push(4);
		System.out.println(linkedStack.size());
		System.out.println(linkedStack.pop());
		System.out.println(linkedStack.size());
		
		System.out.println(linkedStack.pop());
		
		
		System.out.println(linkedStack.pop());
		System.out.println(linkedStack.size());
		
		System.out.println(linkedStack.pop());
		System.out.println(linkedStack.size());
		
		System.out.println(linkedStack.pop());
		
		System.out.println(linkedStack.isEmpty());
	}
}
