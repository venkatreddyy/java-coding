package com.venkat.dsa.datastructures;
/*
Key Points:
====================
====================
Basic Operations of a Circular Singly Linked List:
Insert at the beginning.
Insert at the end.
Delete a node.
Traverse the list.
Example: Circular Singly Linked List in Java
Here's a simple implementation of a circular singly linked list with the ability to add elements and traverse the list.


The last node in the list points to the first node, forming a circle.
The list can be traversed in a circular manner by starting at any node.
There is no clear "end" of the list since the last node points back to the first node.
Advantages of Circular Singly Linked List:
It allows circular traversal, which can be useful in certain scenarios like implementing a round-robin scheduler or when you want continuous looping through the list.
Insertion at the end or at the beginning is easier because you always have access to the last node, and you don't need to traverse the entire list to find the last node.
Time Complexity:
====================
====================
Insertion at the end: O(1) (you directly modify the last pointer and update the next pointers).
Traversal: O(n), where n is the number of nodes in the list.
Would you like additional operations or variations of this list structure?
 */
public class CircularSinglyLinkedList {
    Node last;

    // Node class for circular singly linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert a node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (last == null) { // If the list is empty
            last = newNode;
            last.next = last; // Point to itself, circular link
        } else {
            newNode.next = last.next; // New node points to the first node
            last.next = newNode; // Last node points to the new node
            last = newNode; // New node becomes the last node
        }
    }

    // Print the list from the head (starting at the first node)
    public void traverse() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node first = last.next; // The node after 'last' is the first node
        Node current = first;

        System.out.println("Circular Singly Linked List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != first); // Stop when we get back to the first node

        System.out.println();
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);

        // Traverse the list
        csll.traverse(); // Output: 10 20 30 40
    }
}

