package com.venkat.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;

public class HashSet {
    public static void main(String[] args) {
        CustomHashSet hashSet = new CustomHashSet(10);

        hashSet.add("Charlotte");
        hashSet.add("Thomas");
        hashSet.add("Jens");
        hashSet.add("Peter");
        hashSet.add("Lisa");
        hashSet.add("Adele");
        hashSet.add("Michaela");
        hashSet.add("Bob");

        hashSet.printSet();

        System.out.println("\n'Peter' is in the set: " + hashSet.contains("Peter"));
        System.out.println("Removing 'Peter'");
        hashSet.remove("Peter");
        System.out.println("'Peter' is in the set: " + hashSet.contains("Peter"));
        System.out.println("'Adele' has hash code: " + hashSet.hashFunction("Adele"));
    }

    static class CustomHashSet {
        private final int size;
        private final List<List<String>> buckets;

        public CustomHashSet(int size) {
            this.size = size;
            this.buckets = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                buckets.add(new ArrayList<>()); // Use ArrayList for the buckets
            }
        }

        private int hashFunction(String value) {
            return value.chars().reduce(0, Integer::sum) % size;
        }

        public void add(String value) {
            int index = hashFunction(value);
            List<String> bucket = buckets.get(index);
            if (!bucket.contains(value)) {
                bucket.add(value);
            }
        }

        public boolean contains(String value) {
            int index = hashFunction(value);
            List<String> bucket = buckets.get(index);
            return bucket.contains(value);
        }

        public void remove(String value) {
            int index = hashFunction(value);
            List<String> bucket = buckets.get(index);
            bucket.remove(value);
        }

        public void printSet() {
            System.out.println("Hash Set Contents:");
            for (int index = 0; index < buckets.size(); index++) {
                List<String> bucket = buckets.get(index);
                System.out.println("Bucket " + index + ": " + bucket);
            }
        }
    }
}

