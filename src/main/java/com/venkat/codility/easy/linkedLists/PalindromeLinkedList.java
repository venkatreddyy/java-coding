package com.venkat.codility.easy.linkedLists;

import java.util.Stack;

public class PalindromeLinkedList {

    // Inner ListNode class representing each node in the linked list
    static class ListNode {
        int val;            // Value of the node
        ListNode next;      // Reference to the next node

        // Constructor to initialize ListNode with a value
        ListNode(int val) { this.val = val; }
    }

    // Method to check if a linked list is a palindrome
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>(); // Stack to store the first half of the list values
        ListNode slow = head, fast = head;    // Slow and fast pointers to find the middle of the list

        // Move fast pointer twice as fast as slow to find the middle of the list
        while (fast != null && fast.next != null) {
            stack.push(slow.val); // Push the current value of slow pointer onto the stack
            slow = slow.next;     // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }

        // If the list has an odd number of elements, skip the middle element
        if (fast != null)
            slow = slow.next;

        // Compare the remaining elements in the list with values in the stack
        while (slow != null) {
            if (slow.val != stack.pop())
                return false; // If values differ, it's not a palindrome
            slow = slow.next; // Move to the next node
        }

        return true; // If all values match, it's a palindrome
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        // Check if the linked list is a palindrome and print the result
        System.out.println("Is Palindrome: " + isPalindrome(head)); // Output: true
    }
}
//Output: Is Palindrome: true