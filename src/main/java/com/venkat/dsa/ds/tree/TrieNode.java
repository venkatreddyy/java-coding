package com.venkat.dsa.ds.tree;
/*

A Trie (also known as a Prefix Tree) is a type of search tree used to store a dynamic set of strings where keys are usually strings. Unlike a binary search tree, a Trie does not store the key associated with a node. Instead, a node’s position in the Trie defines the key with which it is associated.

Key Characteristics of a Trie:
Efficient for prefix searches: A Trie allows for efficient searching of prefixes of words, which makes it useful in applications like autocomplete, spell checkers, and IP routing.
Space complexity: Tries can be space-efficient when a large set of strings share common prefixes because the common prefixes are only stored once.
Time complexity: The time complexity for insert, search, and delete operations is O(m), where m is the length of the word.
Structure:
Each node in a Trie represents a character.bnbnnb
The root node represents an empty string.
Each edge represents a character in the alphabet.
Words are terminated by a special "end of word" marker (which can be a boolean flag).
Basic Operations:
Insert: Adding a word to the Trie. The word is added by following the path from the root node, creating new nodes if necessary for each character.
Search: Searching for a word in the Trie is done by following the path through the Trie that corresponds to the characters in the word.
Delete: To remove a word, we reverse the insertion process and prune any unnecessary nodes.

 */


class TrieNode {
    TrieNode[] children; // Array to hold references to child nodes
    boolean isEndOfWord; // Flag to check if the node marks the end of a word

    public TrieNode() {
        this.children = new TrieNode[26]; // Since we are considering lowercase English letters only
        this.isEndOfWord = false;
    }
}

 class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode(); // Root is an empty node
    }

    // 1. Insert a word into the Trie
    // Time Complexity: O(n), where n is the length of the word
    // Space Complexity: O(n), for creating new nodes if necessary
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int index = currentChar - 'a'; // Calculate the index based on 'a' (ASCII offset)
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create a new node if not already present
            }
            node = node.children[index];
        }
        node.isEndOfWord = true; // Mark the end of the word
    }

    // 2. Search for a word in the Trie
    // Time Complexity: O(n), where n is the length of the word
    // Space Complexity: O(1), no extra space used
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int index = currentChar - 'a';
            if (node.children[index] == null) return false; // If character is not found, return false
            node = node.children[index];
        }
        return node.isEndOfWord; // Return true if the word exists and ends here
    }

    // 3. Check if there is any word in the Trie that starts with the given prefix
    // Time Complexity: O(n), where n is the length of the prefix
    // Space Complexity: O(1), no extra space used
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            int index = currentChar - 'a';
            if (node.children[index] == null) return false; // If the prefix is not found, return false
            node = node.children[index];
        }
        return true; // Return true if the prefix exists
    }

    // Main method to test the Trie implementation
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("batman");

        // Test search
        System.out.println("Search 'apple': " + trie.search("apple")); // Expected: true
        System.out.println("Search 'app': " + trie.search("app")); // Expected: true
        System.out.println("Search 'bat': " + trie.search("bat")); // Expected: true
        System.out.println("Search 'ball': " + trie.search("ball")); // Expected: true
        System.out.println("Search 'batman': " + trie.search("batman")); // Expected: true
        System.out.println("Search 'batwoman': " + trie.search("batwoman")); // Expected: false

        // Test startsWith (prefix search)
        System.out.println("Starts with 'app': " + trie.startsWith("app")); // Expected: true
        System.out.println("Starts with 'bat': " + trie.startsWith("bat")); // Expected: true
        System.out.println("Starts with 'batman': " + trie.startsWith("batman")); // Expected: true
        System.out.println("Starts with 'xyz': " + trie.startsWith("xyz")); // Expected: false
    }
}

