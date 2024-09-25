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

 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class FastSlowPointerExample {

    // Function to detect if there is a cycle in the linked list
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or contains only one node
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with the two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer by 1 step
            fast = fast.next.next;  // Move fast pointer by 2 steps

            // If slow and fast pointers meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end, no cycle is present
        return false;
    }

    public static void main(String[] args) {
        // Create a list: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (cycle at node with value 3)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Create a cycle

        // Check if the linked list contains a cycle
        if (hasCycle(head)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle detected in the linked list.");
        }
    }
}
