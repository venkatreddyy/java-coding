package com.venkat.dsa.patterns;
/*
Linked List In-place Reversal is a common problem that involves reversing a linked list, or a part of a linked list, without using extra space. The in-place reversal approach ensures that the linked list is reversed by adjusting the pointers of the nodes directly, rather than creating a new linked list. This technique is often used in interview questions and has practical applications in algorithms involving linked lists.

Problem: Reverse a Singly Linked List in Place
Example:
Given a linked list:
1 -> 2 -> 3 -> 4 -> 5

The reversed linked list will be:
5 -> 4 -> 3 -> 2 -> 1

Approach:
We can reverse a singly linked list in place by keeping track of three pointers:

Previous node (prev) – This will be the node before the current one, initialized to null.
Current node (curr) – This is the node that we are currently processing.
Next node (next) – This is the node that comes after the current node, which we need to store to not lose track of the remaining list while reversing.
Steps:
Initialize prev as null and curr as the head of the linked list.
Traverse the linked list and:
Store the next node temporarily.
Reverse the curr.next pointer to point to the prev node.
Move prev and curr one step forward.
After the loop ends, prev will be the new head of the reversed list.
 */
class ListNode1 {
    int value;
    ListNode1 next;

    ListNode1(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListReversal {

    // Function to reverse the linked list in place
    public static ListNode1 reverseLinkedList(ListNode1 head) {
        ListNode1 previousNode = null;  // Initialize prev as null
        ListNode1 currentNode = head;   // Start with the head as the current node
        ListNode1 nextNode;      // A pointer to store the next node temporarily

        // Traverse through the list and reverse the pointers
        while (currentNode != null) {
            nextNode = currentNode.next;  // Store the next node
            currentNode.next = previousNode;  // Reverse the current node's pointer
            previousNode = currentNode;   // Move prev to the current node
            currentNode = nextNode;       // Move curr to the next node
        }

        // After the loop, previousNode will be the new head of the reversed list
        return previousNode;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);

        // Print original list
        System.out.println("Original List:");
        printLinkedList(head);

        // Reverse the linked list
        ListNode1 reversedHead = reverseLinkedList(head);

        // Print reversed list
        System.out.println("\nReversed List:");
        printLinkedList(reversedHead);
    }

    // Helper function to print the linked list
    public static void printLinkedList(ListNode1 head) {
        ListNode1 currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}

