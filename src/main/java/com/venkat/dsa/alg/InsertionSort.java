package com.venkat.dsa.alg;

/*
Insertion Sort
The insertion sort algorithm builds the sorted array (or list) one item at a time.
It’s much like how we sort playing cards in our hands. The algorithm works by:

Starting from the second element (index 1), compare it with the first element.
If the second element is smaller, move it to the front.
Then, for each subsequent element, compare it to the elements in the sorted portion (from left to right) and insert it in the correct position.
Continue this process until all elements are sorted.
Example
Here's how it works with the array [4, 3, 2, 1]:
Start with 4, already sorted.
Compare 3 with 4, insert 3 in the correct position → [3, 4, 2, 1]
Compare 2 with 3 and 4, insert 2 in the correct position → [2, 3, 4, 1]
Compare 1 with 2, 3, and 4, insert 1 in the correct position → [1, 2, 3, 4]

Time Complexity
Best case: O(n) — when the array is already sorted.
Worst case: O(n²) — when the array is sorted in reverse order.

Insertion is the process of adding an element to a data structure like arrays,
linked lists, or trees. In arrays, it involves shifting elements to make space.
In linked lists, it involves updating the next pointer of the new and previous nodes.
In binary trees, the new element is compared to existing nodes and placed in the correct position to maintain
the order (e.g., left for smaller values, right for larger).
The time complexity varies: O(1) for linked lists, O(n) for arrays, and O(log n) for balanced binary trees.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {7, 12, 9, 11, 3};
        insertionSort(array);
        System.out.println("Sorted array: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    public static void insertionSort(int[] array) {
        int arrayLength = array.length;
        for (int currentIndex = 1; currentIndex < arrayLength; ++currentIndex) {
            int currentElement = array[currentIndex];
            int previousIndex = currentIndex - 1;

            // Move elements of array[0..currentIndex-1], that are greater than currentElement,
            // to one position ahead of their current position
            while (previousIndex >= 0 && array[previousIndex] > currentElement) {
                array[previousIndex + 1] = array[previousIndex];
                previousIndex = previousIndex - 1;
            }
            array[previousIndex + 1] = currentElement;
        }
    }




}
