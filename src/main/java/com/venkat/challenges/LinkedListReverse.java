package com.venkat.challenges;

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class LinkedListReverse {
    // Method to reverse the linked list
    public static Node reverse(Node head) {
        Node prev = null;      // 'prev' will eventually point to the new head (reversed list)
        Node current = head;   // 'current' is used to traverse the list
        Node next = null;      // 'next' will temporarily store the next node

        // Loop to reverse the linked list
        while (current != null) {
            next = current.next;    // Save the next node
            current.next = prev;    // Reverse the 'next' pointer to point to the previous node
            prev = current;         // Move 'prev' forward to the current node
            current = next;         // Move 'current' forward to the next node
        }

        // Return the new head of the reversed list, which is 'prev'
        return prev;
    }

    // Method to print the linked list
    public static void printList(Node head) {
        Node temp = head;  // 'temp' is used to traverse the list
        while (temp != null) {
            System.out.print(temp.data + " ");  // Print the data of the current node
            temp = temp.next;                   // Move to the next node
        }
        System.out.println();  // Print a new line after the entire list has been printed
    }

    // Main method to test the reversal and printing of the linked list
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Print the original list
        System.out.println("Original List:");
        printList(head);

        // Reverse the linked list and update the head
        head = reverse(head);

        // Print the reversed list
        System.out.println("Reversed List:");
        printList(head);
    }
}

