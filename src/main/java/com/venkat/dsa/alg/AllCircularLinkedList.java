package com.venkat.dsa.alg;

/*
Key Features:
Creation and Display: The program allows creating a Circular Linked List and displaying it both in normal and reverse order.
Node Operations: It includes inserting nodes at the beginning, end, and middle, as well as deleting nodes from those positions.
Search and Sort: You can search for an element, remove duplicates, and sort the elements in the list.
Min/Max: Find the maximum and minimum values in the list.
Count Nodes: The program also counts the number of nodes in the list.
How it works:
The main method demonstrates the creation of the Circular Linked List and performs various operations on it.
Each operation has a print statement to show the results and the changes to the list.
 */
// Circular Linked List Implementation with Various Operations
public class AllCircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    // 1) Create and display a Circular Linked List
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    // 2) Create a Circular Linked List of N nodes and count the number of nodes
    public void createList(int n) {
        for (int i = 1; i <= n; i++) {
            insertEnd(i);
        }
        System.out.println("Created a list of " + n + " nodes.");
    }

    public int countNodes() {
        if (head == null) return 0;
        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // 3) Display Circular Linked List in reverse order
    public void displayReverse(Node current) {
        if (current.next != head) {
            displayReverse(current.next);
        }
        System.out.print(current.data + " <- ");
    }

    public void displayReverseOrder() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        displayReverse(head);
        System.out.println("(tail)");
    }

    // 4) Delete a node from the beginning of the Circular Linked List
    public void deleteBegin() {
        if (head == null) return;
        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        System.out.println("Deleted node from the beginning.");
    }

    // 5) Delete a node from the end of the Circular Linked List
    public void deleteEnd() {
        if (head == null) return;
        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
        System.out.println("Deleted node from the end.");
    }

    // 6) Delete a node from the middle of the Circular Linked List
    public void deleteMiddle(int pos) {
        if (head == null) return;
        if (pos == 1) {
            deleteBegin();
            return;
        }
        Node current = head;
        Node prev = null;
        int count = 1;
        while (count < pos) {
            prev = current;
            current = current.next;
            count++;
        }
        if (current == tail) {
            deleteEnd();
        } else {
            prev.next = current.next;
        }
        System.out.println("Deleted node from position " + pos);
    }

    // 7) Find the maximum and minimum value node from a Circular Linked List
    public void findMinMax() {
        if (head == null) return;
        int max = head.data;
        int min = head.data;
        Node temp = head;
        do {
            if (temp.data > max) max = temp.data;
            if (temp.data < min) min = temp.data;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Max value: " + max + ", Min value: " + min);
    }

    // 8) Insert a new node at the beginning of the Circular Linked List
    public void insertBegin(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        System.out.println("Inserted " + data + " at the beginning.");
    }

    // 9) Insert a new node at the end of the Circular Linked List
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            newNode.next = head;
        }
        System.out.println("Inserted " + data + " at the end.");
    }

    // 10) Insert a new node at the middle of the Circular Linked List
    public void insertMiddle(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 1) {
            insertBegin(data);
            return;
        }
        Node temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted " + data + " at position " + pos);
    }

    // 11) Remove duplicate elements from the Circular Linked List
    public void removeDuplicates() {
        if (head == null) return;
        Node current = head;
        do {
            Node temp = current;
            while (temp.next != head) {
                if (temp.next.data == current.data) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            current = current.next;
        } while (current != head);
        System.out.println("Duplicates removed.");
    }

    // 12) Search an element in the Circular Linked List
    public boolean search(int key) {
        if (head == null) return false;
        Node temp = head;
        do {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    // 13) Sort the elements of the Circular Linked List
    public void sortList() {
        if (head == null) return;
        Node current = head;
        Node index = null;
        int temp;
        do {
            index = current.next;
            while (index != head) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        } while (current.next != head);
        System.out.println("List sorted.");
    }

    public static void main(String[] args) {
        AllCircularLinkedList cll = new AllCircularLinkedList();
        cll.createList(5); // Create a list with 5 nodes
        cll.display();
        cll.insertBegin(0); // Insert at the beginning
        cll.insertEnd(6); // Insert at the end
        cll.insertMiddle(3, 4); // Insert in the middle
        cll.display();
        System.out.println("Total nodes: " + cll.countNodes());
        cll.displayReverseOrder();
        cll.deleteBegin();
        cll.deleteEnd();
        cll.deleteMiddle(3);
        cll.display();
        cll.findMinMax();
        cll.removeDuplicates();
        cll.display();
        System.out.println("Is 3 in the list? " + cll.search(3));
        cll.sortList();
        cll.display();
    }
}

