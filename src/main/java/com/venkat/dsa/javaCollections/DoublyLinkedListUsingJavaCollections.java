package com.venkat.dsa.javaCollections;

import java.util.LinkedList;
import java.util.ListIterator;
/*
Explanation:
Add elements: addFirst() to insert at the beginning, add() (or addLast()) to insert at the end.
Remove elements: removeFirst() to remove the first node, removeLast() to remove the last node.
Reverse traversal: ListIterator is used for backward traversal by starting at the end of the list and iterating with hasPrevious().

Doubly Linked List (Forward): [5, 10, 20, 30]
Doubly Linked List (Backward): 30 <-> 20 <-> 10 <-> 5 <-> null
After Removing First and Last: [10, 20]


 */
public class DoublyLinkedListUsingJavaCollections {
    public static void main(String[] args) {
        // Create a LinkedList (which is a doubly linked list in Java)
        LinkedList<Integer> doublyLinkedList = new LinkedList<>();

        // Insert elements
        doublyLinkedList.add(10);
        doublyLinkedList.add(20);
        doublyLinkedList.add(30);

        // Insert at the beginning
        doublyLinkedList.addFirst(5);

        // Display the list forward
        System.out.println("Doubly Linked List (Forward): " + doublyLinkedList);

        // Display the list in reverse order using ListIterator
        System.out.print("Doubly Linked List (Backward): ");
        ListIterator<Integer> iterator = doublyLinkedList.listIterator(doublyLinkedList.size());
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " <-> ");
        }
        System.out.println("null");

        // Remove first and last element
        doublyLinkedList.removeFirst();  // Removes 5
        doublyLinkedList.removeLast();   // Removes 30

        // Display the updated list
        System.out.println("After Removing First and Last: " + doublyLinkedList);
    }
}

