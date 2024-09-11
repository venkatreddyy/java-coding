package com.venkat.dsa.datastructures;
/*
Collision Handling Techniques:
Chaining: As shown in the above example, this technique uses a linked list (or another data structure) to store multiple values at the same index.
Open Addressing: This method finds another open slot in the hash table array when a collision occurs. There are different techniques within open addressing:
Linear Probing: Look for the next available slot in a sequential manner.
Quadratic Probing: Look for the next available slot with a quadratic interval.
Double Hashing: Use a second hash function to calculate the next available slot.

 */
public class HashTableLinearProbing {
    private int[] keys;
    private String[] values;
    private int size;
    private int currentSize;

    // Constructor
    public HashTableLinearProbing(int size) {
        this.size = size;
        keys = new int[size];
        values = new String[size];
        currentSize = 0;
    }

    // Hash function
    private int hashFunction(int key) {
        return key % size;
    }

    // Insert key-value pair with linear probing
    public void insert(int key, String value) {
        if (currentSize == size) {
            System.out.println("Hash Table is full.");
            return;
        }

        int index = hashFunction(key);
        while (keys[index] != 0) { // If collision, move to the next slot
            index = (index + 1) % size;
        }

        keys[index] = key;
        values[index] = value;
        currentSize++;
    }

    // Search for a value by key
    public String search(int key) {
        int index = hashFunction(key);

        while (keys[index] != 0) {
            if (keys[index] == key) {
                return values[index];
            }
            index = (index + 1) % size; // Linear probing
        }

        return null; // Key not found
    }

    // Delete a key-value pair by key
    public void delete(int key) {
        int index = hashFunction(key);

        while (keys[index] != 0) {
            if (keys[index] == key) {
                keys[index] = 0;
                values[index] = null;
                currentSize--;
                return;
            }
            index = (index + 1) % size;
        }
    }

    public static void main(String[] args) {
        HashTableLinearProbing hashTable = new HashTableLinearProbing(10);

        hashTable.insert(1, "Apple");
        hashTable.insert(2, "Banana");
        hashTable.insert(12, "Cherry"); // Collision with key 2
        hashTable.insert(3, "Date");

        System.out.println("Value for key 1: " + hashTable.search(1)); // Output: Apple
        System.out.println("Value for key 12: " + hashTable.search(12)); // Output: Cherry

        hashTable.delete(2);
        System.out.println("Value for key 2 after deletion: " + hashTable.search(2)); // Output: null
    }
}

