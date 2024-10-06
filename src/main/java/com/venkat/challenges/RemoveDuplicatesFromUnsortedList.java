package com.venkat.challenges;

import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedList {
    // Method to remove duplicates using HashSet
    public static void removeDuplicates(Node head) {
        HashSet<Integer> set = new HashSet<>(); // HashSet to store unique elements
        Node current = head;
        Node prev = null;

        while (current != null) {
            // If the value is already in the HashSet, it's a duplicate, so skip the node
            if (set.contains(current.data)) {
                prev.next = current.next;
            } else {
                // If it's a new value, add it to the set
                set.add(current.data);
                prev = current; // Move prev pointer to current
            }
            current = current.next; // Move to the next node
        }
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
        // Create an unsorted linked list: 10 -> 12 -> 11 -> 11 -> 12 -> 10 -> 15
        Node head = new Node(10);
        head.next = new Node(12);
        head.next.next = new Node(11);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(12);
        head.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next = new Node(15);

        System.out.println("Original list:");
        printList(head);

        // Remove duplicates
        removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}

