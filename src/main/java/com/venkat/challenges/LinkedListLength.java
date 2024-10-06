package com.venkat.challenges;


public class LinkedListLength {

    // Method to find the length of a singly linked list
    public static int getLength(Node head) {
        int length = 0;        // Initialize the counter for length
        Node current = head;   // Start from the head node

        // Traverse the list
        while (current != null) {
            length++;          // Increment the counter for each node
            current = current.next; // Move to the next node
        }

        return length;         // Return the length of the list
    }

    // Helper method to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list: 10 -> 20 -> 30 -> 40 -> 50
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        // Print the original list
        System.out.println("Linked List:");
        printList(head);

        // Find and print the length of the linked list
        int length = getLength(head);
        System.out.println("Length of the linked list: " + length);
    }
}
