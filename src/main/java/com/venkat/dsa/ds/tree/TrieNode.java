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
    // Array to store references to child nodes for each character ('a' to 'z')
    TrieNode[] children = new TrieNode[26];

    // Flag to indicate whether this node marks the end of a valid word
    boolean isEndOfWord;

    // Constructor to initialize the node
    public TrieNode() {
        isEndOfWord = false; // Initially, no word ends at this node
        for (int i = 0; i < 26; i++) {
            children[i] = null; // Initialize all child pointers to null (no children yet)
        }
    }
}

class Trie {
    private TrieNode root; // The root node of the Trie

    // Constructor to initialize the Trie
    public Trie() {
        root = new TrieNode(); // Start with an empty root node
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root; // Start at the root node
        // Iterate over each character in the word
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // Convert the character into an index (0 to 25) based on 'a'

            // If the corresponding child node does not exist, create a new node
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            // Move to the child node representing the current character
            node = node.children[index];
        }
        // After processing all characters, mark the last node as the end of a word
        node.isEndOfWord = true;
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root; // Start at the root node
        // Iterate over each character in the word
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // Convert the character into an index (0 to 25)

            // If the corresponding child node does not exist, the word is not in the Trie
            if (node.children[index] == null) {
                return false;
            }

            // Move to the child node representing the current character
            node = node.children[index];
        }
        // Return true if the last node marks the end of a word
        return node.isEndOfWord;
    }

    // Method to check if any words in the Trie start with a given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root; // Start at the root node
        // Iterate over each character in the prefix
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a'; // Convert the character into an index (0 to 25)

            // If the corresponding child node does not exist, no words with this prefix exist
            if (node.children[index] == null) {
                return false;
            }

            // Move to the child node representing the current character
            node = node.children[index];
        }
        // If we have successfully traversed all characters, the prefix exists in the Trie
        return true;
    }

    // Main method for testing the Trie functionality
    public static void main(String[] args) {
        Trie trie = new Trie(); // Create a new Trie

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("ball");

        // Search for words
        System.out.println(trie.search("apple"));  // Output: true (word exists)
        System.out.println(trie.search("app"));    // Output: true (word exists)
        System.out.println(trie.search("bat"));    // Output: true (word exists)
        System.out.println(trie.search("ball"));   // Output: true (word exists)
        System.out.println(trie.search("baller")); // Output: false (word does not exist)
        System.out.println(trie.search("cat"));    // Output: false (word does not exist)

        // Check for prefixes
        System.out.println(trie.startsWith("app")); // Output: true (prefix exists)
        System.out.println(trie.startsWith("ba"));  // Output: true (prefix exists)
        System.out.println(trie.startsWith("ca"));  // Output: false (prefix does not exist)
    }
}
