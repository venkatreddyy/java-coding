package com.venkat.dsa.javaCollections;
/*


A Binary Search Tree (BST) is a special type of binary tree where each node has at most two children, and the following properties hold:

Left Subtree: The left child of a node contains only nodes with values less than the node's value.
Right Subtree: The right child of a node contains only nodes with values greater than the node's value.
No Duplicates: Typically, binary search trees do not contain duplicate values.
Key Operations in a Binary Search Tree:
Insertion: Insert a node into the BST while maintaining the BST properties.
Search: Search for a node with a given value.
Deletion: Remove a node from the BST while ensuring the BST properties remain intact.
Traversal: In-order, Pre-order, Post-order, or Level-order traversals can be used to visit the nodes.
Code Implementation of a Binary Search Tree in Java
BST Node Class:
The Node class represents a node in the tree. Each node has a value, a reference to the left child, and a reference to the right child.

Binary Search Tree Class:
The BinarySearchTree class implements the key operations like insertion, search, and deletion.

Code Exam


In-order traversal:
20 30 40 50 60 70 80

Search 40: true
Search 90: false

In-order traversal after deleting 40:
20 30 50 60 70 80

Traversal Methods:
In-order Traversal: Left subtree → Root → Right subtree (gives sorted order in BST).
Pre-order Traversal: Root → Left subtree → Right subtree.
Post-order Traversal: Left subtree → Right subtree → Root.
 */
public class BinarySearchTree {
}
