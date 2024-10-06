package com.venkat.challenges;

public class ThirdNodeFromEnd {

    // Method to find the third node from the end in a singly linked list
    public static Node findThirdFromEnd(Node head) {
        Node first = head;
        Node second = head;

        // Move the `first` pointer three nodes ahead
        for (int i = 0; i < 3; i++) {
            if (first == null) {
                System.out.println("The list has fewer than 3 nodes.");
                return null; // If there are fewer than 3 nodes, return null
            }
            first = first.next;
        }

        // Move both `first` and `second` pointers one step at a time
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // `second` now points to the third node from the end
        return second;
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
        // Create a linked list: 10 -> 20 -> 30 -> 40 -> 50 -> 60
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        // Print the original list
        System.out.println("Linked List:");
        printList(head);

        // Find and print the third node from the end
        Node thirdFromEnd = findThirdFromEnd(head);
        if (thirdFromEnd != null) {
            System.out.println("The third node from the end is: " + thirdFromEnd.data);
        }
    }
}
