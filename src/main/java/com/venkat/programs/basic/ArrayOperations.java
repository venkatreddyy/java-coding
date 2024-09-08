package com.venkat.programs.basic;

import java.util.*;
/*
Java Features Explained:
Stream API (stream()): Java 8 introduced the Stream API, which allows for functional-style operations on sequences of elements.
Optional Enhancements (orElseThrow()): Also introduced in Java 8, this is used for handling optional values without needing null checks.
distinct() and sorted() in Streams: Java 8 allows you to remove duplicates with distinct() and sort elements using sorted().
Arrays.copyOf(): Available since Java 6, this method copies arrays efficiently.
Enhanced collections (HashMap.getOrDefault()): This is a Java 8 feature that simplifies accessing default values from a Map.
This class leverages modern Java features while being backward compatible with Java 17.
 */
public class ArrayOperations {

    // 1) Copy all elements of one array into another array
    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length); // Arrays.copyOf() is available since Java 6
    }

    // 2) Find the frequency of each element in the array
    public static void findFrequency(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // getOrDefault() is from Java 8
        }
        System.out.println(frequencyMap);
    }

    // 3) Left rotate the elements of an array
    public static void leftRotate(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int first = array[0];
            System.arraycopy(array, 1, array, 0, array.length - 1); // System.arraycopy() is available since Java 1.0
            array[array.length - 1] = first;
        }
        System.out.println(Arrays.toString(array)); // Arrays.toString() is available since Java 1.2
    }

    // 4) Print the duplicate elements of an array
    public static void printDuplicateElements(int[] array) {
        Set<Integer> duplicates = new HashSet<>(); // Set is available since Java 1.2
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : array) {
            if (!uniqueElements.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println(duplicates);
    }

    // 5) Print the elements of an array
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array)); // Arrays.toString() is available since Java 1.2
    }

    // 6) Print the elements of an array in reverse order
    public static void printReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 7) Print the elements of an array present on even position
    public static void printEvenPosition(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 8) Print the elements of an array present on odd position
    public static void printOddPosition(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 9) Print the largest element in an array
    public static int findLargestElement(int[] array) {
        return Arrays.stream(array).max().orElseThrow(); // Arrays.stream() and orElseThrow() are from Java 8
    }

    // 10) Print the smallest element in an array
    public static int findSmallestElement(int[] array) {
        return Arrays.stream(array).min().orElseThrow(); // Arrays.stream() and orElseThrow() are from Java 8
    }

    // 11) Print the number of elements present in an array
    public static int countElements(int[] array) {
        return array.length; // Available since Java 1.0
    }

    // 12) Print the sum of all the items of the array
    public static int sumOfElements(int[] array) {
        return Arrays.stream(array).sum(); // Arrays.stream() and sum() are from Java 8
    }

    // 13) Right rotate the elements of an array
    public static void rightRotate(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int last = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = last;
        }
        System.out.println(Arrays.toString(array));
    }

    // 14) Sort the elements of an array in ascending order
    public static void sortAscending(int[] array) {
        Arrays.sort(array); // Arrays.sort() is available since Java 1.2
        System.out.println(Arrays.toString(array));
    }

    // 15) Sort the elements of an array in descending order
    public static void sortDescending(int[] array) {
        Arrays.sort(array); // Arrays.sort() is available since Java 1.2
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    // 16) Find 3rd largest number in an array
    public static int findThirdLargest(int[] array) {
        return Arrays.stream(array).distinct().sorted().toArray()[array.length - 3]; // distinct(), sorted(), and stream() are from Java 8
    }

    // 17) Find 2nd largest number in an array
    public static int findSecondLargest(int[] array) {
        return Arrays.stream(array).distinct().sorted().toArray()[array.length - 2];
    }

    // 18) Find largest number in an array
    public static int findLargest(int[] array) {
        return Arrays.stream(array).max().orElseThrow();
    }

    // 19) Find 2nd smallest number in an array
    public static int findSecondSmallest(int[] array) {
        return Arrays.stream(array).distinct().sorted().toArray()[1];
    }

    // 20) Find smallest number in an array
    public static int findSmallest(int[] array) {
        return Arrays.stream(array).min().orElseThrow();
    }

    // 21) Remove duplicate elements in an array
    public static int[] removeDuplicates(int[] array) {
        return Arrays.stream(array).distinct().toArray(); // distinct() is from Java 8
    }

    // 22) Print odd and even numbers from an array
    public static void printOddAndEvenNumbers(int[] array) {
        System.out.print("Even Numbers: ");
        Arrays.stream(array).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " ")); // stream() and filter() are from Java 8
        System.out.println();
        System.out.print("Odd Numbers: ");
        Arrays.stream(array).filter(n -> n % 2 != 0).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    // 23) Sort an array in Java (general method)
    public static void sortArray(int[] array, boolean ascending) {
        if (ascending) {
            Arrays.sort(array); // Arrays.sort() is available since Java 1.2
        } else {
            Arrays.sort(array);
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }

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

