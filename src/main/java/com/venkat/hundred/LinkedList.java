package com.venkat.hundred;

class LinkedList {
    Node head; // Head node of the linked list

    // Node definition for Linked List
    static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node in the list
        Node random; // Random pointer (used for Clone a Linked List with Random Pointers)

        // Constructor to initialize a node with the given data
        Node(int data) {
            this.data = data;
            this.next = null; // Initialize next pointer to null
            this.random = null; // Initialize random pointer to null (used for Clone)
        }
    }

    // 1. Reverse a Singly Linked List
    public Node reverseLinkedList(Node head) {
        Node prev = null;     // Initialize the previous node as null
        Node current = head;  // Start with the head node
        Node next;     // Temporary node to store next node reference

        // Traverse the list
        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev;  // Reverse the current node's pointer to the previous node
            prev = current;       // Move prev pointer to current node
            current = next;       // Move current to the next node
        }

        return prev;  // Return prev which is the new head of the reversed list
    }

    // 2. Detect a Loop in a Linked List (Floyd's Cycle Detection Algorithm)
    public boolean detectLoop(Node head) {
        Node slow = head; // Slow pointer starts at head
        Node fast = head; // Fast pointer starts at head

        // Traverse the list
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one step
            fast = fast.next.next;    // Move fast pointer by two steps
            if (slow == fast) {       // If slow and fast meet, a loop exists
                return true;
            }
        }

        return false;  // Return false if no loop is detected
    }

    // 3. Find the Middle Element of a Linked List
    public Node findMiddleElement(Node head) {
        Node slow = head; // Slow pointer starts at head
        Node fast = head; // Fast pointer starts at head

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one step
            fast = fast.next.next;    // Move fast pointer by two steps
        }

        return slow;  // Slow pointer will be at the middle when fast reaches the end
    }

    // 4. Merge Two Sorted Linked Lists
    public Node mergeTwoSortedLists(Node l1, Node l2) {
        Node dummy = new Node(0);  // Create a dummy node to simplify merging logic
        Node tail = dummy;         // Tail pointer to build the merged list

        // Traverse both lists and merge them
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail.next = l1;    // Add l1 to the merged list if l1's data is smaller
                l1 = l1.next;      // Move l1 pointer to the next node
            } else {
                tail.next = l2;    // Add l2 to the merged list if l2's data is smaller
                l2 = l2.next;      // Move l2 pointer to the next node
            }
            tail = tail.next;      // Move the tail pointer to the next node in the merged list
        }

        // Add remaining nodes from l1 or l2 (one list might still have nodes left)
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;  // Return the merged list starting from the next node of dummy
    }

    // 5. Remove Duplicates from a Sorted Linked List
    public Node removeDuplicatesFromSortedList(Node head) {
        Node current = head;  // Start from the head node

        // Traverse the list
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;  // Skip the duplicate node
            } else {
                current = current.next;  // Move to the next distinct node
            }
        }

        return head;  // Return the modified list
    }

    // 6. Find the Nth Node from the End of a Linked List
    public Node findNthFromEnd(Node head, int n) {
        Node first = head;  // First pointer starts at head
        Node second = head; // Second pointer starts at head

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) return null;  // Return null if n is larger than the list length
            first = first.next;  // Move first pointer to the next node
        }

        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;  // Move first pointer to the next node
            second = second.next;  // Move second pointer to the next node
        }

        return second;  // The second pointer is now at the Nth node from the end
    }

    // 7. Add Two Numbers Represented by Linked Lists
    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);  // Create a dummy node for simplicity
        Node current = dummy;      // Pointer to build the result list
        int carry = 0;             // Initialize carry as 0

        // Traverse both lists
        while (l1 != null || l2 != null) {
            int sum = carry;  // Start sum with the carry value
            if (l1 != null) {
                sum += l1.data;  // Add l1's data to the sum
                l1 = l1.next;    // Move l1 to the next node
            }
            if (l2 != null) {
                sum += l2.data;  // Add l2's data to the sum
                l2 = l2.next;    // Move l2 to the next node
            }

            carry = sum / 10;  // Calculate the new carry
            current.next = new Node(sum % 10);  // Create a new node with the sum's remainder
            current = current.next;  // Move current pointer to the next node
        }

        if (carry > 0) {  // If there's a remaining carry, create a new node
            current.next = new Node(carry);
        }

        return dummy.next;  // Return the result list, skipping the dummy node
    }

    // 8. Flatten a Linked List (Skipped in this version, usually involves child pointers)

    // 9. Detect and Remove a Loop in a Linked List
    public Node detectAndRemoveLoop(Node head) {
        Node slow = head;  // Slow pointer starts at head
        Node fast = head;  // Fast pointer starts at head

        // Detect loop
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one step
            fast = fast.next.next;    // Move fast pointer by two steps
            if (slow == fast) {       // If slow and fast meet, loop is detected
                removeLoop(slow, head);  // Remove the loop
                return head;  // Return the modified list after removing loop
            }
        }

        return head;  // No loop detected, return the original list
    }

    // Helper function to remove the detected loop
    private void removeLoop(Node loopNode, Node head) {
        Node ptr1 = head;  // Pointer to start from the head
        Node ptr2 = null;  // Pointer to find the node where the loop starts

        // Find the loop starting point
        while (true) {
            ptr2 = loopNode;  // Set ptr2 to loopNode

            // Traverse the loop
            while (ptr2.next != loopNode && ptr2.next != ptr1) {
                ptr2 = ptr2.next;  // Move ptr2 to the next node
            }

            if (ptr2.next == ptr1) break;  // Loop starting point found

            ptr1 = ptr1.next;  // Move ptr1 to the next node
        }

        ptr2.next = null;  // Break the loop
    }

    // 10. Check if a Linked List is a Palindrome
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;  // Empty or single node list is a palindrome

        // Find the middle of the list
        Node slow = head;  // Slow pointer
        Node fast = head;  // Fast pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;  // Move slow pointer by one step
            fast = fast.next.next;  // Move fast pointer by two steps
        }

        // Reverse the second half of the list
        Node secondHalf = reverseLinkedList(slow);  // Reverse from the middle to the end
        Node firstHalf = head;  // First half starts from head

        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;  // If mismatch found, it's not a palindrome
            firstHalf = firstHalf.next;  // Move first half pointer
            secondHalf = secondHalf.next;  // Move second half pointer
        }

        return true;  // No mismatches, it's a palindrome
    }

    // 11. Rotate a Linked List by k positions
    public Node rotateLinkedList(Node head, int k) {
        if (head == null || k == 0) return head;  // No rotation needed for empty list or zero rotations

        // Find the length of the list
        Node current = head;  // Start from head
        int length = 1;       // Initialize length as 1
        while (current.next != null) {
            current = current.next;  // Traverse the list
            length++;  // Increase length
        }

        // Connect the last node to the head to make it circular
        current.next = head;

        // Find the new head after rotating (length - k % length) times
        k = k % length;  // Handle cases where k > length
        int stepsToNewHead = length - k;  // Calculate steps to new head
        Node newTail = head;  // Initialize newTail as head
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;  // Move newTail to the new position
        }

        Node newHead = newTail.next;  // Set the new head
        newTail.next = null;  // Break the circular link

        return newHead;  // Return the new head of the rotated list
    }

    // 12. Clone a Linked List with Random Pointers
    public Node cloneRandomList(Node head) {
        if (head == null) return null;  // Return null for empty list

        // Step 1: Create a copy of each node and insert it next to the original node
        Node current = head;  // Start from head
        while (current != null) {
            Node copy = new Node(current.data);  // Create a copy of the current node
            copy.next = current.next;  // Set the copied node's next to current's next
            current.next = copy;  // Insert the copied node after the current node
            current = copy.next;  // Move current pointer to the next original node
        }

        // Step 2: Copy the random pointers
        current = head;  // Reset current to head
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;  // Set the copied node's random pointer
            }
            current = current.next.next;  // Move to the next original node
        }

        // Step 3: Separate the copied list from the original list
        current = head;  // Reset current to head
        Node dummy = new Node(0);  // Dummy node to hold the copied list
        Node copyCurrent = dummy;  // Pointer for the copied list
        while (current != null) {
            Node copy = current.next;  // Get the copied node
            copyCurrent.next = copy;  // Append the copied node to the new list
            copyCurrent = copyCurrent.next;  // Move the pointer for the copied list
            current.next = copy.next;  // Restore the original list's next pointer
            current = current.next;  // Move current to the next original node
        }

        return dummy.next;  // Return the head of the cloned list
    }

    // 13. Delete a Node from a Singly Linked List without Head Pointer
    public void deleteNodeWithoutHead(Node node) {
        if (node == null || node.next == null) return;  // Cannot delete the last node or a null node

        // Copy the data from the next node to the current node
        node.data = node.next.data;

        // Remove the next node by skipping it
        node.next = node.next.next;
    }

    // Helper function to print the linked list
    public void printList(Node head) {
        Node temp = head;  // Start from head
        while (temp != null) {
            System.out.print(temp.data + " ");  // Print the data of the current node
            temp = temp.next;  // Move to the next node
        }
        System.out.println();  // Print a newline after printing the list
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();  // Create a new LinkedList

        // Create a sample linked list 1 -> 2 -> 3 -> 4 -> 5
        list.head = new Node(1);  // Create head node
        list.head.next = new Node(2);  // Create and link second node
        list.head.next.next = new Node(3);  // Create and link third node
        list.head.next.next.next = new Node(4);  // Create and link fourth node
        list.head.next.next.next.next = new Node(5);  // Create and link fifth node

        // 1. Reverse Linked List
        list.head = list.reverseLinkedList(list.head);
        System.out.print("Reversed List: ");
        list.printList(list.head);  // Output: 5 4 3 2 1

        // 2. Detect Loop (for testing, create a loop by linking last node to second node)
        list.head.next.next.next.next.next = list.head.next;  // Create a loop for testing
        System.out.println("Loop Detected: " + list.detectLoop(list.head));  // Output: true

        // 3. Find Middle Element
        list.head = list.reverseLinkedList(list.head);  // Reverse back to original order
        System.out.println("Middle Element: " + list.findMiddleElement(list.head).data);  // Output: 3

        // 4. Merge Two Sorted Linked Lists
        LinkedList list1 = new LinkedList();
        list1.head = new Node(1);  // Create first list: 1 -> 3 -> 5
        list1.head.next = new Node(3);
        list1.head.next.next = new Node(5);

        LinkedList list2 = new LinkedList();
        list2.head = new Node(2);  // Create second list: 2 -> 4 -> 6
        list2.head.next = new Node(4);
        list2.head.next.next = new Node(6);

        Node mergedHead = list.mergeTwoSortedLists(list1.head, list2.head);
        System.out.print("Merged List: ");
        list.printList(mergedHead);  // Output: 1 2 3 4 5 6

        // 5. Remove Duplicates from Sorted List
        list.head = new Node(1);  // Create sorted list with duplicates: 1 -> 1 -> 2
        list.head.next = new Node(1);
        list.head.next.next = new Node(2);
        list.head = list.removeDuplicatesFromSortedList(list.head);
        System.out.print("After Removing Duplicates: ");
        list.printList(list.head);  // Output: 1 2

        // 6. Find Nth Node from End
        Node nthNode = list.findNthFromEnd(list.head, 2);
        System.out.println("Nth Node from End: " + nthNode.data);  // Output: 2

        // 7. Add Two Numbers Represented by Linked Lists
        list1.head = new Node(2);  // First number: 2 -> 4 -> 3 (342)
        list1.head.next = new Node(4);
        list1.head.next.next = new Node(3);

        list2.head = new Node(5);  // Second number: 5 -> 6 -> 4 (465)
        list2.head.next = new Node(6);
        list2.head.next.next = new Node(4);

        Node sumHead = list.addTwoNumbers(list1.head, list2.head);
        System.out.print("Sum List: ");
        list.printList(sumHead);  // Output: 7 0 8 (807)

        // 9. Detect and Remove Loop (reset the list first)
        list.head = new Node(1);  // Create list: 1 -> 2 -> 3
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = list.head.next;  // Create loop
        list.detectAndRemoveLoop(list.head);  // Remove the loop
        System.out.print("List after removing loop: ");
        list.printList(list.head);  // Output: 1 2 3

        // 10. Check if Linked List is a Palindrome
        list.head = new Node(1);  // Create palindrome list: 1 -> 2 -> 2 -> 1
        list.head.next = new Node(2);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(1);
        System.out.println("Is Palindrome: " + list.isPalindrome(list.head));  // Output: true

        // 11. Rotate Linked List
        list.head = new Node(1);  // Create list: 1 -> 2 -> 3 -> 4 -> 5
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head = list.rotateLinkedList(list.head, 2);  // Rotate by 2 positions
        System.out.print("Rotated List: ");
        list.printList(list.head);  // Output: 4 5 1 2 3

        // 12. Clone a Linked List with Random Pointers
        list1.head = new Node(1);  // Create list with random pointers
        list1.head.next = new Node(2);
        list1.head.next.next = new Node(3);
        list1.head.random = list1.head.next.next;  // Random: 1 -> 3
        list1.head.next.random = list1.head;       // Random: 2 -> 1

        Node clonedHead = list.cloneRandomList(list1.head);
        System.out.print("Cloned List: ");
        list.printList(clonedHead);  // Should print the cloned list

        // 13. Delete Node without Head Pointer
        list.head = new Node(1);  // Create list: 1 -> 2 -> 3 -> 4
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.deleteNodeWithoutHead(list.head.next.next);  // Delete node 3
        System.out.print("List after deleting node 3: ");
        list.printList(list.head);  // Output: 1 2 4
    }
}

