package com.venkat.dsa.datastructures;

/*

A doubly linked list is a type of data structure consisting of nodes where each node contains three parts:

Data: The value stored in the node.
Next Pointer: A reference (or pointer) to the next node in the sequence.
Previous Pointer: A reference (or pointer) to the previous node in the sequence.
In a singly linked list, each node only contains a reference to the next node, whereas in a doubly linked list, each node has references to both the next and previous nodes. This allows traversal of the list in both forward and backward directions.



Key Features:
=============
Each node has pointers to the next and previous nodes, making it easy to traverse in both directions.
Insertion and deletion operations are more flexible than in a singly linked list because you have access to both previous
and next nodes, making it easier to manipulate nodes in the middle of the list.
Time Complexity:
===============
Insertion and Deletion: O(1) (if you already have the reference to the node).
Traversal: O(n), where n is the number of nodes in the list.
 */
public class DoublyLinkedList {
    Node head;

    // Node class for doubly linked list
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Insert a node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) { // If the list is empty
            head = newNode;
            return;
        }

        Node last = head;
        while (last.next != null) { // Traverse to the end of the list
            last = last.next;
        }

        last.next = newNode; // Link the new node at the end
        newNode.prev = last; // Set the previous pointer of the new node
    }

    // Print the list from head to end
    public void traverseForward() {
        Node current = head;
        System.out.println("Doubly Linked List (Forward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print the list from end to head
    public void traverseBackward() {
        if (head == null) {
            return;
        }

        Node last = head;
        while (last.next != null) { // Traverse to the end of the list
            last = last.next;
        }

        System.out.println("Doubly Linked List (Backward): ");
        while (last != null) { // Traverse backward using the prev pointer
            System.out.print(last.data + " ");
            last = last.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);

        // Traverse in both directions
        dll.traverseForward(); // Output: 10 20 30 40
        dll.traverseBackward(); // Output: 40 30 20 10
    }
}

