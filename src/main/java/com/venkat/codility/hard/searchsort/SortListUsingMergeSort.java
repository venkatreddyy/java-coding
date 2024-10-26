package com.venkat.codility.hard.searchsort;

class SortListUsingMergeSort {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Main function to sort a linked list using merge sort
    public static ListNode sortList(ListNode head) {
        // Base case: if list is empty or has a single element, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode mid = getMiddle(head);
        ListNode rightHalf = mid.next;
        mid.next = null;

        // Step 2: Recursively sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // Step 3: Merge the sorted halves
        return merge(left, right);
    }

    // Helper function to find the middle of the linked list
    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted linked lists
    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify the merge process
        ListNode current = dummy;

        // Merge the two lists by comparing nodes
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Attach any remaining nodes from either list
        current.next = (left != null) ? left : right;

        return dummy.next; // The merged list starts from the next node of dummy
    }

    public static void main(String[] args) {
        // Example: Creating a linked list
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        // Sort the list using merge sort
        head = sortList(head);

        // Print the sorted list
        ListNode current = head;
        System.out.print("Sorted List: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // Expected Output: 1 2 3 4
    }
}

