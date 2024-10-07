package com.venkat.programs.basic;

import java.util.*;

public class ArrayOperationsWithUtils {

    // 1) Copy all elements of one array into another array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(n) for creating the copy
    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length); // Copies the array using Java's built-in Arrays.copyOf()
    }

    // 2) Find the frequency of each element in the array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(n) for storing the frequency in a map
    public static void findFrequency(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); // Stores the frequency of each element
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // Increment count
        }
        System.out.println(frequencyMap); // Prints the frequency map
    }

    // 3) Left rotate the elements of an array
    // Time Complexity: O(n * d), where n is the length of the array, and d is the number of rotations
    // Space Complexity: O(1), no extra space except temporary variables
    public static void leftRotate(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int first = array[0]; // Store the first element
            System.arraycopy(array, 1, array, 0, array.length - 1); // Shift all elements to the left
            array[array.length - 1] = first; // Place the first element at the end
        }
        System.out.println(Arrays.toString(array)); // Print the rotated array
    }

    // 4) Print the duplicate elements of an array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(n), for storing elements in a set
    public static void printDuplicateElements(int[] array) {
        Set<Integer> duplicates = new HashSet<>(); // To store duplicates
        Set<Integer> uniqueElements = new HashSet<>(); // To store unique elements
        for (int num : array) {
            if (!uniqueElements.add(num)) { // If the element already exists, it's a duplicate
                duplicates.add(num); // Add to duplicates
            }
        }
        System.out.println(duplicates); // Print the set of duplicates
    }

    // 5) Print the elements of an array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array)); // Print array using Arrays.toString()
    }

    // 6) Print the elements of an array in reverse order
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static void printReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) { // Loop from the last index to the first
            System.out.print(array[i] + " "); // Print each element
        }
        System.out.println();
    }

    // 7) Print the elements of an array present on even positions
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static void printEvenPosition(int[] array) {
        for (int i = 1; i < array.length; i += 2) { // Start from index 1 and increment by 2
            System.out.print(array[i] + " "); // Print elements at even positions
        }
        System.out.println();
    }

    // 8) Print the elements of an array present on odd positions
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static void printOddPosition(int[] array) {
        for (int i = 0; i < array.length; i += 2) { // Start from index 0 and increment by 2
            System.out.print(array[i] + " "); // Print elements at odd positions
        }
        System.out.println();
    }

    // 9) Print the largest element in an array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static int findLargestElement(int[] array) {
        return Arrays.stream(array).max().orElseThrow(); // Use streams to find the maximum value
    }

    // 10) Print the smallest element in an array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static int findSmallestElement(int[] array) {
        return Arrays.stream(array).min().orElseThrow(); // Use streams to find the minimum value
    }

    // 11) Print the number of elements present in an array
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static int countElements(int[] array) {
        return array.length; // Return the length of the array
    }

    // 12) Print the sum of all the items of the array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static int sumOfElements(int[] array) {
        return Arrays.stream(array).sum(); // Use streams to sum up all elements
    }

    // 13) Right rotate the elements of an array
    // Time Complexity: O(n * d), where n is the length of the array, and d is the number of rotations
    // Space Complexity: O(1), no extra space except temporary variables
    public static void rightRotate(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int last = array[array.length - 1]; // Store the last element
            System.arraycopy(array, 0, array, 1, array.length - 1); // Shift elements to the right
            array[0] = last; // Move last element to the first position
        }
        System.out.println(Arrays.toString(array)); // Print the rotated array
    }

    // 14) Sort the elements of an array in ascending order
    // Time Complexity: O(n log n), due to Arrays.sort() method
    // Space Complexity: O(1) if in-place sorting
    public static void sortAscending(int[] array) {
        Arrays.sort(array); // Sort the array in ascending order
        System.out.println(Arrays.toString(array)); // Print sorted array
    }

    // 15) Sort the elements of an array in descending order
    // Time Complexity: O(n log n) for sorting + O(n) for reversing
    // Space Complexity: O(1) if in-place
    public static void sortDescending(int[] array) {
        Arrays.sort(array); // Sort in ascending order
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i]; // Swap to reverse the order
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(array)); // Print the array in descending order
    }

    // 16) Find the 3rd largest number in an array
    // Time Complexity: O(n log n) for sorting
    // Space Complexity: O(n) for distinct array creation
    public static int findThirdLargest(int[] array) {
        return Arrays.stream(array).distinct().sorted().toArray()[array.length - 3]; // Find 3rd largest after sorting
    }

    // 17) Find the 2nd largest number in an array
    // Time Complexity: O(n log n) for sorting
    // Space Complexity: O(n) for distinct array creation
    public static int findSecondLargest(int[] array) {
        return Arrays.stream(array).distinct().sorted().toArray()[array.length - 2]; // Find 2nd largest after sorting
    }

    // 18) Find the largest number in an array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static int findLargest(int[] array) {
        return Arrays.stream(array).max().orElseThrow(); // Use streams to find the maximum value
    }

    // 19) Find the 2nd smallest number in an array
    // Time Complexity: O(n log n) for sorting
    // Space Complexity: O(n) for distinct array creation
    public static int findSecondSmallest(int[] array) {
        return Arrays.stream(array).distinct().sorted().toArray()[1]; // Find 2nd smallest after sorting
    }

    // 20) Find the smallest number in an array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static int findSmallest(int[] array) {
        return Arrays.stream(array).min().orElseThrow(); // Use streams to find the minimum value
    }

    // 21) Remove duplicate elements in an array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(n) for distinct elements array
    public static int[] removeDuplicates(int[] array) {
        return Arrays.stream(array).distinct().toArray(); // Remove duplicates and return a new array
    }

    // 22) Print odd and even numbers from an array
    // Time Complexity: O(n), where n is the length of the array
    // Space Complexity: O(1)
    public static void printOddAndEvenNumbers(int[] array) {
        System.out.print("Even Numbers: ");
        Arrays.stream(array).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " ")); // Print even numbers
        System.out.println();
        System.out.print("Odd Numbers: ");
        Arrays.stream(array).filter(n -> n % 2 != 0).forEach(n -> System.out.print(n + " ")); // Print odd numbers
        System.out.println();
    }

    // 23) Sort an array in ascending or descending order based on a flag
    // Time Complexity: O(n log n) for sorting + O(n) for reversing if needed
    // Space Complexity: O(1) if in-place sorting
    public static void sortArray(int[] array, boolean ascending) {
        if (ascending) {
            Arrays.sort(array); // Sort in ascending order
        } else {
            Arrays.sort(array); // Sort in ascending order
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i]; // Reverse the order for descending
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
        }
        System.out.println(Arrays.toString(array)); // Print the sorted array
    }

    // Main method to test all functions
    public static void main(String[] args) {
        // Test array
        int[] array = {4, 2, 9, 1, 5, 6, 7, 2, 5, 3};

        // Test all methods
        System.out.println("Original Array: " + Arrays.toString(array));
        System.out.println("Copied Array: " + Arrays.toString(copyArray(array)));
        System.out.print("Frequency of elements: ");
        findFrequency(array);
        System.out.print("Left Rotated Array: ");
        leftRotate(array, 2);
        System.out.print("Right Rotated Array: ");
        rightRotate(array, 2);
        System.out.print("Duplicate Elements: ");
        printDuplicateElements(array);
        System.out.print("Array Elements: ");
        printArray(array);
        System.out.print("Array in Reverse: ");
        printReverse(array);
        System.out.print("Elements on Even Position: ");
        printEvenPosition(array);
        System.out.print("Elements on Odd Position: ");
        printOddPosition(array);
        System.out.println("Largest Element: " + findLargestElement(array));
        System.out.println("Smallest Element: " + findSmallestElement(array));
        System.out.println("Number of Elements: " + countElements(array));
        System.out.println("Sum of Elements: " + sumOfElements(array));
        System.out.print("Array in Ascending Order: ");
        sortAscending(array);
        System.out.print("Array in Descending Order: ");
        sortDescending(array);
        System.out.println("3rd Largest Element: " + findThirdLargest(array));
        System.out.println("2nd Largest Element: " + findSecondLargest(array));
        System.out.println("Largest Element: " + findLargest(array));
        System.out.println("2nd Smallest Element: " + findSecondSmallest(array));
        System.out.println("Smallest Element: " + findSmallest(array));
        System.out.print("Without Duplicates: " + Arrays.toString(removeDuplicates(array)));
        System.out.println();
        printOddAndEvenNumbers(array);
        System.out.print("Array Sorted (Descending): ");
        sortArray(array, false);
    }
}
