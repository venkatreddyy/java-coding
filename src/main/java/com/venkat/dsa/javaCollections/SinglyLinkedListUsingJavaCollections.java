package com.venkat.dsa.javaCollections;

import java.util.LinkedList;

public class SinglyLinkedListUsingJavaCollections {
    public static void main(String[] args) {
        // Create a LinkedList (which is a doubly linked list in Java)
        LinkedList<Integer> singlyLinkedList = new LinkedList<>();

        // Insert elements (equivalent to inserting at the end)
        singlyLinkedList.add(10);
        singlyLinkedList.add(20);
        singlyLinkedList.add(30);

        // Insert at the beginning
        singlyLinkedList.addFirst(5);

        // Display the list
        System.out.println("Singly Linked List (Forward): " + singlyLinkedList);

        // Remove an element (simulating delete)
        singlyLinkedList.removeFirst();  // Remove the head (beginning element)

        // Display the updated list
        System.out.println("After Removing First Element: " + singlyLinkedList);

        // Remove last element
        singlyLinkedList.removeLast();

        // Display the updated list
        System.out.println("After Removing Last Element: " + singlyLinkedList);

        // Traversing through the list (simulating a singly linked list traversal)
        System.out.print("Traversing the list: ");
        for (int element : singlyLinkedList) {
            System.out.print(element + " -> ");
        }
        System.out.println("null");
    }
}
