package com.venkat.challenges;
/*
Time Complexity:
O(n + m), where n is the length of list A and m is the length of list B.
 This is because we are traversing both lists once.
Space Complexity:
O(1), since we are only using a constant amount of extra space (the dummy node and pointers).
 */
public class MergeSortedLinkedLists {

    // Method to merge two sorted linked lists
    public static Node mergeLists(Node A, Node B) {
        // Create a dummy node to form the starting point of the merged list
        Node dummy = new Node(0);
        Node tail = dummy;

        // Traverse both lists
        while (A != null && B != null) {
            // Compare the data of current nodes in A and B
            if (A.data <= B.data) {
                tail.next = A;  // Attach the smaller node to the result
                A = A.next;     // Move pointer A to the next node
            } else {
                tail.next = B;  // Attach the smaller node to the result
                B = B.next;     // Move pointer B to the next node
            }
            tail = tail.next;   // Move the tail of the merged list
        }

        // If one list ends, append the rest of the other list
        if (A != null) {
            tail.next = A;
        } else {
            tail.next = B;
        }

        // Return the merged list, starting from the first real node (skip the dummy)
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create first sorted linked list: 1 -> 3 -> 5
        Node A = new Node(1);
        A.next = new Node(3);
        A.next.next = new Node(5);

        // Create second sorted linked list: 2 -> 4 -> 6
        Node B = new Node(2);
        B.next = new Node(4);
        B.next.next = new Node(6);

        System.out.println("List A:");
        printList(A);

        System.out.println("List B:");
        printList(B);

        // Merge the two sorted linked lists
        Node mergedList = mergeLists(A, B);

        System.out.println("Merged list:");
        printList(mergedList);
    }
}

