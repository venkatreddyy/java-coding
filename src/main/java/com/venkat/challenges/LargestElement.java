package com.venkat.challenges;

public class LargestElement {
    public static int findLargest(int[] arr) {
        int largest = arr[0];
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 5};
        System.out.println(findLargest(arr));  // Output: 7
    }
}

