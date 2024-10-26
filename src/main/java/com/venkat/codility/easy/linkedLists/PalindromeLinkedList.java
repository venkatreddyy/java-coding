package com.venkat.codility.easy.linkedLists;

import java.util.Stack;

public class PalindromeLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (slow.val != stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println("Is Palindrome: " + isPalindrome(head)); // Output: true
    }
}
//Output: Is Palindrome: true