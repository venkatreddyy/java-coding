package com.venkat.codility.medium.linkedLists;

public class IntersectionOfLinkedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA > lenB) {
            headA = advanceBy(headA, lenA - lenB);
        } else {
            headB = advanceBy(headB, lenB - lenA);
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private static ListNode advanceBy(ListNode node, int steps) {
        while (steps-- > 0) node = node.next;
        return node;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersect = new ListNode(8);
        headA.next.next = intersect;
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        ListNode result = getIntersectionNode(headA, headB);
        System.out.println("Intersection at node with value: " + (result != null ? result.val : "null")); // Output: 8
    }
}

