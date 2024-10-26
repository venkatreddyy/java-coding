package com.venkat.codility.hard.linkedLists;
/*
2. Swap Nodes in Pairs with Constraints
Problem: Swap every two adjacent nodes in a linked list. Implement this with the constraint that you cannot simply swap values but must swap nodes.

Approach:

Use a dummy node to simplify edge cases at the head.
Traverse the list and, at each pair of nodes, perform a swap by adjusting pointers.
Continue swapping pairs until the end of the list or if there’s only one node left.

Explanation:
swapPairs: The function uses a dummy node to handle the head swap scenario easily. For each pair, we reassign pointers to swap the nodes.
Pointer Adjustments:
current.next is adjusted to point to the second node.
first.next is adjusted to skip the swapped pair and point to the next node.
second.next points to first, completing the swap.
 */
class SwapNodesInPairsWithConstraints {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        // Dummy node to handle the head swap scenario
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Traverse the list and swap nodes in pairs
        while (current.next != null && current.next.next != null) {
            // Identify the two nodes to be swapped
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Perform the swap
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move the current pointer forward by two nodes
            current = first;
        }

        return dummy.next; // Return the new head, which is dummy.next
    }

    public static void main(String[] args) {
        // Example: Creating a linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Swap nodes in pairs
        head = swapPairs(head);

        // Print the modified list
        System.out.print("List after swapping in pairs: ");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // Expected Output: 2 1 4 3
    }
}

