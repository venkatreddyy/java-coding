package com.venkat.dsa.datastructures;

/*
Explanation of the Code:
Node Class:

Each node contains two fields:
data: The value stored in the node.
next: A reference to the next node in the list.
SinglyLinkedList Class:

head: This points to the first node in the list. Initially, it is set to null.
insertAtBeginning(int data): Inserts a new node at the beginning of the list.
insertAtEnd(int data): Inserts a new node at the end of the list.
deleteNode(int key): Deletes a node with a specified value from the list.
displayList(): Traverses and prints the elements of the list.
search(int key): Searches for a node with a specified value.
Key Operations:
Insertion:

Insertion can be done at the beginning, end, or middle of the list.
To insert at the beginning: We simply create a new node and point its next to the current head, then update the head to this new node.
To insert at the end: We traverse to the end of the list and add the new node there.
Deletion:

To delete a node: We find the node with the given value and unlink it from the list by adjusting the next pointer of the previous node.
Traversal:

To traverse: We start from the head and follow the next pointers until we reach the end (null).
Search:

To search: We traverse the list and check if the data in any node matches the target value.
Advantages of Singly Linked Lists:
Dynamic Size: Unlike arrays, linked lists can grow and shrink dynamically as nodes are added or removed.
Efficient Insertions/Deletions: Inserting or deleting a node at the beginning or middle is O(1) once you have a pointer to the relevant node.
Disadvantages:
Access Time: Accessing an element by index takes O(n) time since you have to traverse the list from the head.
Extra Memory: Each node requires extra memory to store the reference (pointer) to the next node.
 */
public class SinglyLinkedList {

    // Head of the list (first node)
    private Node head;

    // Node class representing each element in the list
    class Node {
        int data;
        Node next;

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to insert a new node at the beginning of the list
    public void insertAtBeginning(int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);

        // Point the new node's next to the current head
        newNode.next = head;

        // Make the new node the head of the list
        head = newNode;
    }

    // Method to insert a new node at the end of the list
    public void insertAtEnd(int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the end of the list
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Add the new node at the end of the list
        current.next = newNode;
    }

    // Method to delete a node by its value
    public void deleteNode(int key) {
        Node current = head;
        Node prev = null;

        // If the head contains the key, delete the head
        if (current != null && current.data == key) {
            head = current.next; // Change head
            return; // Exit the method early
        }

        // Traverse the list to find the key
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // If the key was not present, do nothing
        if (current == null) {
            System.out.println("Key not found in the list.");
            return;
        }

        // Unlink the node from the linked list
        prev.next = current.next;
    }

    // Method to display the contents of the list
    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null"); // End of list
    }

    // Method to search for a node with a given value
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true; // Node found
            }
            current = current.next;
        }
        return false; // Node not found
    }

    public static void main(String[] args) {
        // Create an instance of the SinglyLinkedList
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert elements into the list
        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);

        // Display the list
        System.out.println("Singly Linked List:");
        list.displayList(); // Expected output: 5 -> 10 -> 20 -> 30 -> null

        // Delete a node from the list
        list.deleteNode(20);
        System.out.println("After deleting 20:");
        list.displayList(); // Expected output: 5 -> 10 -> 30 -> null

        // Search for a node in the list
        boolean found = list.search(10);
        System.out.println("Is 10 in the list? " + found); // Expected output: true
    }
}

