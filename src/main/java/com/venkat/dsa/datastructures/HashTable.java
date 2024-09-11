package com.venkat.dsa.datastructures;

import java.util.LinkedList;
/*


Chaining Preferred

A hash table (or hash map) is a data structure that allows for fast data retrieval, insertion, and deletion by using a
key-value pair mechanism. It uses a hashing function to map keys to specific indices in an array, making it efficient
to find the corresponding value for a given key. Hash tables are commonly used for scenarios where we need fast lookups,
such as databases, caches, and dictionaries.

Key Concepts in Hash Tables:
Hash Function: A function that takes a key and returns an index in the array where the corresponding value is stored.
Collision: A situation where two different keys hash to the same index in the array. There are techniques to handle this:
Chaining: Store multiple values at the same index using a linked list or other data structures.
Open Addressing: Use probing (linear, quadratic, or double hashing) to find another empty slot in the array.
Hash Table Operations:
Insert: Insert a key-value pair into the hash table.
Search: Retrieve the value associated with a given key.
Delete: Remove a key-value pair from the hash table.

Explanation:
Insert: The key is hashed to find the appropriate bucket (linked list). If the key already exists, its value is updated. If not, the key-value pair is added to the linked list.
Search: The key is hashed, and the corresponding linked list is searched to find the key-value pair.
Delete: The key is hashed, and the linked list is traversed to find and remove the node.
Example Output:
yaml
Copy code
Value for key 1: Apple
Value for key 2: Banana
Value for key 12: Cherry
Value for key 2 after deletion: null

Chaining preferred.
 */
public class HashTable {
    // A class to represent key-value pairs
    class HashNode {
        int key;
        String value;
        HashNode next;

        public HashNode(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Array of linked lists to store the hash table
    private LinkedList<HashNode>[] table;
    private int size;

    // Constructor
    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];

        // Initialize each bucket as an empty linked list
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to calculate the index for a key
    private int hashFunction(int key) {
        return key % size;
    }

    // Insert a key-value pair into the hash table
    public void insert(int key, String value) {
        int index = hashFunction(key);
        HashNode newNode = new HashNode(key, value);

        // Check if key already exists, update value if found
        for (HashNode node : table[index]) {
            if (node.key == key) {
                node.value = value; // Update the value for the existing key
                return;
            }
        }

        // If key doesn't exist, add it to the linked list
        table[index].add(newNode);
    }

    // Search for a value by key
    public String search(int key) {
        int index = hashFunction(key);

        // Traverse the linked list at the calculated index
        for (HashNode node : table[index]) {
            if (node.key == key) {
                return node.value;
            }
        }
        return null; // Key not found
    }

    // Delete a key-value pair by key
    public void delete(int key) {
        int index = hashFunction(key);
        HashNode toRemove = null;

        // Traverse the linked list to find the node to delete
        for (HashNode node : table[index]) {
            if (node.key == key) {
                toRemove = node;
                break;
            }
        }

        if (toRemove != null) {
            table[index].remove(toRemove);
        }
    }

    // Main method to test the hash table
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        // Insert key-value pairs
        hashTable.insert(1, "Apple");
        hashTable.insert(2, "Banana");
        hashTable.insert(12, "Cherry"); // Collision with key 2
        hashTable.insert(3, "Date");

        // Search for values
        System.out.println("Value for key 1: " + hashTable.search(1)); // Output: Apple
        System.out.println("Value for key 2: " + hashTable.search(2)); // Output: Banana
        System.out.println("Value for key 12: " + hashTable.search(12)); // Output: Cherry

        // Delete a key
        hashTable.delete(2);
        System.out.println("Value for key 2 after deletion: " + hashTable.search(2)); // Output: null
    }
}

