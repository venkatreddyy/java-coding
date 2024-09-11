package com.venkat.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;
/*
You can implement a simple HashMap using an ArrayList in Java. To simulate a HashMap,
we can store key-value pairs in an ArrayList where each element is an entry consisting of a key and value.
We’ll also need to handle hash collisions (for simplicity, we’ll use separate chaining with linked lists or
nested ArrayLists to resolve collisions).

Explanation:
CustomHashMap:

A class that mimics the behavior of a HashMap using an ArrayList of buckets.
Each bucket (index) in the ArrayList is another ArrayList that stores entries (key-value pairs).
hashFunction:

This function computes the hash code of the key and reduces it to a valid index in the bucket list using the modulus operator.
put(K key, V value):

Adds a key-value pair to the map. If the key already exists, it updates the value; otherwise, it adds a new entry.
get(K key):

Retrieves the value for a given key. If the key is not present, it returns null.
remove(K key):

Removes the key-value pair associated with the given key.
containsKey(K key):

Checks if the key is present in the map.
printMap:

Prints the contents of the CustomHashMap.




Key Points:
The map is implemented using ArrayList for buckets and each bucket is also an ArrayList that holds key-value pairs (entries).
The hashFunction computes the bucket index based on the key’s hash code.
Collisions are handled by storing multiple entries in the same bucket (separate chaining).

 */
public class CustomHashMap<K, V> {
    private final int size;
    private final List<List<Entry<K, V>>> buckets;

    public CustomHashMap(int size) {
        this.size = size;
        this.buckets = new ArrayList<>(size);
        // Initialize each bucket as an empty list
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    // Hash function to compute the index
    private int hashFunction(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    // Add a key-value pair to the map
    public void put(K key, V value) {
        int index = hashFunction(key);
        List<Entry<K, V>> bucket = buckets.get(index);

        // Check if the key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing value
                return;
            }
        }

        // If the key does not exist, add a new entry
        bucket.add(new Entry<>(key, value));
    }

    // Get the value for a given key
    public V get(K key) {
        int index = hashFunction(key);
        List<Entry<K, V>> bucket = buckets.get(index);

        // Iterate through the bucket to find the key
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Return null if key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = hashFunction(key);
        List<Entry<K, V>> bucket = buckets.get(index);

        // Iterate through the bucket and remove the entry if found
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                bucket.remove(i);
                return;
            }
        }
    }

    // Check if a key exists in the map
    public boolean containsKey(K key) {
        int index = hashFunction(key);
        List<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Print the map's contents
    public void printMap() {
        System.out.println("Custom HashMap contents:");
        for (int i = 0; i < size; i++) {
            List<Entry<K, V>> bucket = buckets.get(i);
            if (!bucket.isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : bucket) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    // Inner class to represent key-value pairs
    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Main method to test the CustomHashMap
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(10);

        // Adding key-value pairs
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("Diana", 40);
        map.put("Alice", 26); // Updating the value for "Alice"

        // Printing map contents
        map.printMap();

        // Accessing elements
        System.out.println("\nCharlie's age: " + map.get("Charlie"));

        // Checking if a key exists
        System.out.println("Contains 'Bob': " + map.containsKey("Bob"));

        // Removing a key-value pair
        System.out.println("Removing 'Diana'");
        map.remove("Diana");

        // Printing map after removal
        map.printMap();
    }
}
