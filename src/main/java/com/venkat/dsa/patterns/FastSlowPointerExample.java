package com.venkat.dsa.patterns;
/*
Explanation:
Initialize pointers:
slow moves one step at a time.
fast moves two steps at a time.
Cycle Detection:
If there is a cycle, the fast pointer will eventually "lap" the slow pointer, and the two will meet.
If the fast pointer reaches the end of the list (null), there is no cycle.

Common Applications of Fast and Slow Pointers:
    Cycle Detection in a Linked List (Floyd's Cycle Detection Algorithm)
    Finding the Middle of a Linked List
    Detecting Palindromes in Linked Lists
    Finding the Starting Point of a Cycle in a Linked List

    1 -> 2 -> 3 -> 4 -> 5
          ^         |
          |         |
          -----------

 */
// Definition of the ListNode class representing a node in a singly linked list
class ListNode {
    int val;        // Value of the node
    ListNode next;  // Pointer to the next node

    // Constructor to create a new node with a given value
    ListNode(int val) {
        this.val = val;      // Initialize the value of the node
        this.next = null;    // Initially, the next pointer is null (no connection to any other node)
    }
}

public class FastSlowPointerExample {

    // Function to detect if there is a cycle in the linked list
    public static boolean hasCycle(ListNode head) {
        // If the list is empty or contains only one node, there's no cycle
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize two pointers, slow and fast, both starting at the head node
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with two pointers, slow moving one step and fast moving two steps
        while (fast != null && fast.next != null) {  // Continue while fast and fast.next are not null
            slow = slow.next;        // Move the slow pointer by one step
            fast = fast.next.next;   // Move the fast pointer by two steps

            // If the slow and fast pointers meet, a cycle is detected
            if (slow == fast) {
                return true;         // Cycle exists, return true
            }
        }

        // If fast reaches the end of the list, there's no cycle
        return false;
    }

    public static void main(String[] args) {
        // Create a linked list with a cycle:
        // 1 -> 2 -> 3 -> 4 -> 5 -> back to node 3 (cycle at node 3)
        ListNode head = new ListNode(1);                      // First node with value 1
        head.next = new ListNode(2);                          // Second node with value 2
        head.next.next = new ListNode(3);                     // Third node with value 3
        head.next.next.next = new ListNode(4);                // Fourth node with value 4
        head.next.next.next.next = new ListNode(5);           // Fifth node with value 5
        head.next.next.next.next.next = head.next.next;       // Creating a cycle by pointing the last node back to node 3

        // Check if the linked list has a cycle and print the result
        if (hasCycle(head)) {                                 // Call hasCycle() with the head of the list
            System.out.println("Cycle detected in the linked list.");  // If there's a cycle, print this message
        } else {
            System.out.println("No cycle detected in the linked list."); // If no cycle is detected, print this message
        }
    }
}

