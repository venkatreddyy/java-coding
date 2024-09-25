package com.venkat.dsa.ds;

/*
Key Points:
================
Each node has two references: one to the next node and one to the previous node.
The last node's next pointer points to the first node (circular), and the first node's prev pointer points to the last node.
This allows traversal in both directions: forward and backward.
Example Breakdown:
Insertion at End:
================
If the list is empty, the new node becomes the head, and it points to itself (both next and prev point to the new node).
If the list is not empty, the new node is inserted at the end, and the links are updated to maintain the circular structure.
Forward Traversal:
================
Start from the head and keep moving forward using the next pointers until you reach the head again.
Backward Traversal:
================
Start from the last node (found using head.prev), and keep moving backward using the prev pointers until you reach the last node again.
Advantages:
Allows circular traversal in both directions (forward and backward).
Useful in scenarios where you need continuous looping in both directions (e.g., in multimedia applications for playlists or for navigating through a history of visited items).
Time Complexity:
Insertion: O(1) (if inserting at the end, with direct reference to the head and prev pointers).
Traversal: O(n), where n is the number of nodes in the list.
Would you like further examples on insertion at the beginning, deletion, or any other operations?
 */
public class CircularDoublyLinkedList {
    Node head;

    // Node class for circular doubly linked list
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
            newNode.next = head; // Point to itself, circular link
            newNode.prev = head;
        } else {
            Node last = head.prev; // Get the last node

            last.next = newNode;  // Last node's next points to new node
            newNode.prev = last;  // New node's prev points to last node
            newNode.next = head;  // New node's next points to head (circular)
            head.prev = newNode;  // Head's prev points to the new node
        }
    }

    // Traverse the list in the forward direction
    public void traverseForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.println("Circular Doubly Linked List (Forward):");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head); // Stop when we reach the head again

        System.out.println();
    }

    // Traverse the list in the backward direction
    public void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node last = head.prev; // Start from the last node
        System.out.println("Circular Doubly Linked List (Backward):");
        Node current = last;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != last); // Stop when we reach the last node again

        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        cdll.insertAtEnd(10);
        cdll.insertAtEnd(20);
        cdll.insertAtEnd(30);
        cdll.insertAtEnd(40);

        // Traverse the list in both directions
        cdll.traverseForward();  // Output: 10 20 30 40
        cdll.traverseBackward(); // Output: 40 30 20 10
    }
}

