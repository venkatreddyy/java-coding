package com.venkat.programs.advanced;
/*
var for local variable type inference: This simplifies code by letting the compiler infer types. For example, var dll = new DoublyLinkedList();.

Efficient looping and recursion: Loops and recursive calls are used to perform operations in a concise manner, avoiding unnecessary complexity.

Minimal code for list operations: Operations like insertion, deletion, searching, and rotating are kept as short as possible without sacrificing clarity.

Java 17 optimizations: The use of concise control structures and var helps to reduce verbosity while maintaining readability and functionality.
 */
public class DoublyLinkedList {
    // Node structure for doubly linked list
    class Node {
        int data;
        Node prev, next;

        Node(int data) { this.data = data; }
    }

    private Node head, tail;

    // 1) Convert Binary Tree to Doubly Linked List (Inorder)
    static class BinaryTree {
        int data;
        BinaryTree left, right;

        BinaryTree(int data) { this.data = data; }
    }

    public Node convertTreeToDLL(BinaryTree root) {
        if (root == null) return null;
        var dll = new DoublyLinkedList();
        convertTreeRec(root, dll);
        return dll.head;
    }

    private void convertTreeRec(BinaryTree root, DoublyLinkedList dll) {
        if (root == null) return;
        convertTreeRec(root.left, dll);
        dll.insertAtEnd(root.data);
        convertTreeRec(root.right, dll);
    }

    // 2) Convert Ternary Tree to Doubly Linked List
    static class TernaryTree {
        int data;
        TernaryTree left, middle, right;

        TernaryTree(int data) { this.data = data; }
    }

    public Node convertTernaryTreeToDLL(TernaryTree root) {
        if (root == null) return null;
        var dll = new DoublyLinkedList();
        convertTernaryTreeRec(root, dll);
        return dll.head;
    }

    private void convertTernaryTreeRec(TernaryTree root, DoublyLinkedList dll) {
        if (root == null) return;
        convertTernaryTreeRec(root.left, dll);
        dll.insertAtEnd(root.data);
        convertTernaryTreeRec(root.middle, dll);
        convertTernaryTreeRec(root.right, dll);
    }

    // 3) Count nodes in Doubly Linked List
    public int countNodes() {
        var count = 0;
        for (var temp = head; temp != null; temp = temp.next) count++;
        return count;
    }

    // 4) Display in reverse
    public void displayReverse() {
        for (var temp = tail; temp != null; temp = temp.prev) System.out.print(temp.data + " ");
        System.out.println();
    }

    // 5) Create and display doubly linked list
    public void display() {
        for (var temp = head; temp != null; temp = temp.next) System.out.print(temp.data + " ");
        System.out.println();
    }

    // 6) Delete from beginning
    public void deleteFromBeginning() {
        if (head != null) head = head.next;
        if (head != null) head.prev = null;
    }

    // 7) Delete from end
    public void deleteFromEnd() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        }
    }

    // 8) Delete from middle
    public void deleteFromMiddle(int pos) {
        if (head == null) return;
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }
        var temp = head;
        for (int i = 1; temp != null && i < pos; i++) temp = temp.next;
        if (temp != null && temp.prev != null && temp.next != null) {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // 9) Find max and min values
    public int[] findMaxMin() {
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var temp = head; temp != null; temp = temp.next) {
            if (temp.data > max) max = temp.data;
            if (temp.data < min) min = temp.data;
        }
        return new int[]{max, min};
    }

    // 10) Insert at the beginning
    public void insertAtBeginning(int data) {
        var newNode = new Node(data);
        if (head == null) head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // 11) Insert at the end
    public void insertAtEnd(int data) {
        var newNode = new Node(data);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // 12) Insert in the middle
    public void insertAtMiddle(int data, int pos) {
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }
        var newNode = new Node(data);
        var temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp != null && temp.next != null) {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // 13) Remove duplicates
    public void removeDuplicates() {
        for (var temp = head; temp != null && temp.next != null; temp = temp.next) {
            if (temp.data == temp.next.data) temp.next = temp.next.next;
            if (temp.next != null) temp.next.prev = temp;
        }
    }

    // 14) Rotate by N nodes
    public void rotateByN(int n) {
        if (head == null) return;
        var temp = head;
        for (int i = 1; i < n && temp != null; i++) temp = temp.next;
        if (temp == null) return;

        tail.next = head; // Make it circular
        head.prev = tail;
        head = temp.next;
        head.prev = null;
        temp.next = null;
        tail = temp;
    }

    // 15) Search an element
    public boolean search(int key) {
        for (var temp = head; temp != null; temp = temp.next) if (temp.data == key) return true;
        return false;
    }

    // 16) Sort the list
    public void sortList() {
        for (var i = head; i != null; i = i.next) {
            for (var j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    var temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        var dll = new DoublyLinkedList();

        // Example operations
        dll.insertAtEnd(3);
        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.display(); // Output: 3 1 2

        dll.sortList();
        dll.display(); // Output: 1 2 3

        dll.insertAtBeginning(0);
        dll.display(); // Output: 0 1 2 3

        dll.deleteFromEnd();
        dll.display(); // Output: 0 1 2

        System.out.println("Max/Min: " + java.util.Arrays.toString(dll.findMaxMin())); // Output: Max/Min: [2, 0]
    }
}

