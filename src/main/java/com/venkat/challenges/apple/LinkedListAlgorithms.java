package com.venkat.challenges.apple;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class RandomListNode {
    int val;
    RandomListNode next, random;
    RandomListNode(int val) { this.val = val; }
}

public class LinkedListAlgorithms {

    // 1. Reverse a linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 2. Find the middle of a linked list
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 3. Detect a cycle (Floyd's)
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // 4. Remove a loop
    public static void removeLoop(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return;

        slow = head;
        if (slow == fast) { // Loop starts at head
            while (fast.next != slow) fast = fast.next;
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        fast.next = null;
    }

    // 5. Find intersection of two linked lists
    public static ListNode getIntersection(ListNode a, ListNode b) {
        ListNode p1 = a, p2 = b;
        while (p1 != p2) {
            p1 = (p1 == null) ? b : p1.next;
            p2 = (p2 == null) ? a : p2.next;
        }
        return p1;
    }

    // 6. Merge two sorted linked lists
    public static ListNode mergeSorted(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) { tail.next = l1; l1 = l1.next; }
            else { tail.next = l2; l2 = l2.next; }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // 7. Remove Nth node from end
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i <= n; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next; slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    // 8. Check if linked list is a palindrome
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
        }
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next; secondHalf = secondHalf.next;
        }
        return true;
    }

    // 9. Flatten a multilevel linked list
    static class Node {
        int val;
        Node next, child;
        Node(int val) { this.val = val; }
    }

    public static Node flatten(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) stack.push(curr.next);
                curr.next = curr.child;
                curr.child = null;
            } else if (curr.next == null && !stack.isEmpty()) {
                curr.next = stack.pop();
            }
            curr = curr.next;
        }
        return head;
    }

    // 10. Clone linked list with random pointers
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        RandomListNode dummy = new RandomListNode(0), copyCurr = dummy;
        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    // 11. Add two numbers represented as linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Main for sample demonstration
    public static void main(String[] args) {
        // Example: Reverse a linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2); head.next.next = new ListNode(3);
        ListNode reversed = reverseList(head);
        System.out.print("Reversed: ");
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
        System.out.println();
    }
}

