package com.venkat.algorithms;

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
