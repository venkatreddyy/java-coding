package com.venkat.programs.advanced;

import java.util.Scanner;

/*
Node class defines the structure of a single node.
insert(), display(), and countNodes() are basic methods for inserting, displaying, and counting nodes.
displayReverse() uses recursion to display the list in reverse order.
deleteBeginning(), deleteMiddle(), and deleteEnd() handle node deletions from different positions.
isPalindrome() checks if the list forms a palindrome.
findMaxMin() finds the maximum and minimum values in the list.
insertAtMiddle(), insertAtBeginning() insert nodes at specific positions.
removeDuplicates() removes consecutive duplicates from the list.
searchElement() searches for a specific element in the list.

Features used up to Java 17:
record (Java 16+):

A concise and immutable way to define the Node class, which contains just data and a reference to the next node.
The record automatically provides a constructor, getters, equals(), hashCode(), and toString() methods.
var (Java 10+):

Used for local variable type inference. Instead of explicitly specifying types like Node temp = head,
you can use var temp = head, which reduces verbosity. This is helpful for improving code readability and
keeping the code minimal.Recursive methods:

Recursion is used instead of iterative loops to perform operations like inserting, deleting, counting,
 and finding elements, which results in shorter and cleaner code.
StringBuilder (Palindrome check):

Efficiently constructs a string representation of the list's data and checks for palindrome using the reverse()
method in StringBuilder. This approach avoids manual reversal of the list and leverages Java's built-in efficient
 string manipulation methods.

 */
public class SinglyLinkedList {
    // Java 17 Record for defining Node (Immutable object, concise structure)
    // Records automatically generate the constructor, getters, `toString`, `equals`, and `hashCode` methods.
    record Node(int data, Node next) {
    }

    private Node head;

    // 1) Insert at end
    // Using recursion to minimize code and avoid loops.
    public void insert(int data) {
        head = (head == null) ? new Node(data, null) : insertRec(head, data);
    }

    private Node insertRec(Node node, int data) {
        return node.next() == null ? new Node(node.data(), new Node(data, null))
                : new Node(node.data(), insertRec(node.next(), data));
    }

    // 2) Display List
    // Using `var` introduced in Java 10 to automatically infer the variable type
    public void display() {
        for (var temp = head; temp != null; temp = temp.next()) System.out.print(temp.data() + " ");
        System.out.println();
    }

    // 3) Count nodes
    // Recursive method to count nodes instead of using loops
    public int countNodes() {
        return countRec(head);
    }

    private int countRec(Node node) {
        return (node == null) ? 0 : 1 + countRec(node.next());
    }

    // 4) Display reverse using recursion
    // Recursion is used to reverse display, avoiding a need for extra memory
    public void displayReverse(Node node) {
        if (node == null) return;
        displayReverse(node.next());
        System.out.print(node.data() + " ");
    }

    // 5) Delete from the beginning
    // Simple operation to move the head reference
    public void deleteBeginning() {
        if (head != null) head = head.next();
    }

    // 6) Delete from middle
    // Recursively traverses to the given position and deletes
    public void deleteMiddle(int position) {
        head = deleteAtPosition(head, position, 1);
    }

    private Node deleteAtPosition(Node node, int pos, int count) {
        return (node == null || pos == 1) ? (node != null ? node.next() : null)
                : new Node(node.data(), deleteAtPosition(node.next(), pos - 1, count + 1));
    }

    // 7) Delete from end
    // Recursive approach to reach and remove the last element
    public void deleteEnd() {
        head = deleteRecEnd(head);
    }

    private Node deleteRecEnd(Node node) {
        return (node == null || node.next() == null) ? null : new Node(node.data(), deleteRecEnd(node.next()));
    }

    // 8) Check if palindrome
    // Using StringBuilder to concatenate the list's data into a string and check palindrome efficiently
    public boolean isPalindrome() {
        var sb = new StringBuilder();  // `var` is used for concise type inference
        for (var temp = head; temp != null; temp = temp.next()) sb.append(temp.data());
        return sb.toString().equals(sb.reverse().toString());
    }

    // 9) Find max and min
    // Recursively traversing the list to find max and min values
    public int[] findMaxMin() {
        return (head == null) ? new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}
                : findRecMaxMin(head, head.data(), head.data());
    }

    private int[] findRecMaxMin(Node node, int max, int min) {
        return (node == null) ? new int[]{max, min}
                : findRecMaxMin(node.next(), Math.max(max, node.data()), Math.min(min, node.data()));
    }

    // 10) Insert at middle
    // Recursively inserts at a calculated middle position
    public void insertAtMiddle(int data) {
        int mid = countNodes() / 2; // Calculate middle position
        head = insertAtPosition(head, data, mid, 0);
    }

    private Node insertAtPosition(Node node, int data, int pos, int count) {
        return (pos == 0 || node == null) ? new Node(data, node)
                : new Node(node.data(), insertAtPosition(node.next(), data, pos - 1, count + 1));
    }

    // 11) Insert at beginning
    // Inserts a new node at the start of the list
    public void insertAtBeginning(int data) {
        head = new Node(data, head); // Simply updates head to point to the new node
    }

    // 13) Remove duplicates
    // Recursively removes consecutive duplicate elements in the list
    public void removeDuplicates() {
        head = removeDupRec(head);
    }

    private Node removeDupRec(Node node) {
        return (node == null || node.next() == null) ? node
                : (node.data() == node.next().data() ? removeDupRec(node.next())
                : new Node(node.data(), removeDupRec(node.next())));
    }

    // 14) Search an element
    // Recursively searches for a key in the list
    public boolean searchElement(int key) {
        return searchRec(head, key);
    }

    private boolean searchRec(Node node, int key) {
        return node != null && (node.data() == key || searchRec(node.next(), key));
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in); // Using `var` for concise type declaration
        var list = new SinglyLinkedList();

        // Insert example
        list.insert(1);
        list.insert(2);
        list.insert(3);

        // Display list
        list.display();

        // Count nodes
        System.out.println("Count: " + list.countNodes());

        // Reverse display
        System.out.print("Reversed: ");
        list.displayReverse(list.head);
        System.out.println();

        // Delete operations
        list.deleteBeginning();
        list.display();

        list.deleteMiddle(2);
        list.display();

        list.deleteEnd();
        list.display();

        // Palindrome check
        list.insert(1);
        list.insert(2);
        list.insert(1);
        System.out.println("Is palindrome: " + list.isPalindrome());

        // Max and Min values
        var maxMin = list.findMaxMin();
        System.out.println("Max: " + maxMin[0] + ", Min: " + maxMin[1]);

        // Insert at middle
        list.insertAtMiddle(9);
        list.display();

        // Insert at beginning
        list.insertAtBeginning(5);
        list.display();

        // Remove duplicates
        list.removeDuplicates();
        list.display();

        // Search element
        System.out.println("Element 9 found: " + list.searchElement(9));
    }
}

