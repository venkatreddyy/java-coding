package com.venkat.hundred;

import java.util.*;

public class ArrayPrograms {

    // 1. Find the Largest and Second Largest Elements in an Array
    public static void findLargestAndSecondLargest(int[] arr) {
        // Initialize 'largest' and 'secondLargest' with the minimum possible value.
        // This ensures any number in the array will be greater than these initial values.
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

        // Loop through each element of the array
        for (int num : arr) {
            // If the current number is greater than 'largest',
            // update 'secondLargest' to be 'largest' (the old largest value)
            // and then set 'largest' to the current number
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            // If the current number is greater than 'secondLargest' and not equal to 'largest',
            // then update 'secondLargest' to the current number.
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        // Print out the largest and second largest numbers found in the array
        System.out.println("Largest: " + largest + ", Second Largest: " + secondLargest);
    }


    // 2. Find the Missing Number in an Array (Assume numbers from 1 to n)
    public static int findMissingNumber(int[] arr, int n) {
        // Calculate the total sum of numbers from 1 to n using the formula: n * (n + 1) / 2
        // This gives the sum of the first n natural numbers.
        int total = n * (n + 1) / 2;

        // Variable to store the sum of elements in the input array 'arr'
        int sum = 0;

        // Loop through the array to compute the sum of the elements
        for (int num : arr) {
            sum += num; // Add each number from the array to 'sum'
        }

        // The missing number is the difference between the total sum (sum of 1 to n)
        // and the sum of the numbers present in the array.
        return total - sum;
    }


    // 3. Find the Duplicates in an Array
    public static void findDuplicates(int[] arr) {
        // 'seen' set is used to store unique elements as we iterate through the array
        Set<Integer> seen = new HashSet<>();

        // 'duplicates' set is used to store elements that are duplicates
        Set<Integer> duplicates = new HashSet<>();

        // Loop through each element in the input array
        for (int num : arr) {
            // Try to add the current number to the 'seen' set
            // If it fails to add (i.e., the number already exists in the 'seen' set),
            // then the number is a duplicate, so we add it to the 'duplicates' set
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        // Print the set of duplicates found in the array
        System.out.println("Duplicates: " + duplicates);
    }


    // 4. Rotate an Array by k Positions
    public static void rotateArray(int[] arr, int k) {
        // Get the length of the array
        int n = arr.length;

        // If k is larger than n, we use k % n to ensure the rotation count doesn't exceed the array length.
        // For example, rotating an array of length 5 by 6 steps is the same as rotating it by 1 step.
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(arr, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(arr, 0, k - 1);

        // Step 3: Reverse the remaining n - k elements
        reverse(arr, k, n - 1);

        // Print the rotated array
        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }

    // Helper method to reverse a portion of the array
    private static void reverse(int[] arr, int start, int end) {
        // Swap the elements from 'start' to 'end' to reverse the array or sub-array
        while (start < end) {
            // Swap the elements at 'start' and 'end' indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move towards the center
            start++;
            end--;
        }
    }


    // 5. Find the Intersection and Union of Two Arrays
    public static void findIntersectionAndUnion(int[] arr1, int[] arr2) {
        // 'union' set will store the union of both arrays, which contains all unique elements
        Set<Integer> union = new HashSet<>();

        // 'intersection' set will store the intersection of both arrays, which contains common elements
        Set<Integer> intersection = new HashSet<>();

        // 'seen' set will store elements from the first array to help check for intersections
        Set<Integer> seen = new HashSet<>();

        // Loop through the first array
        for (int num : arr1) {
            // Add each element of arr1 to 'union' (as a set, duplicates will automatically be ignored)
            union.add(num);

            // Add each element of arr1 to 'seen' to help track the elements seen in arr1
            seen.add(num);
        }

        // Loop through the second array
        for (int num : arr2) {
            // Add each element of arr2 to 'union', duplicates will automatically be ignored
            union.add(num);

            // If an element in arr2 exists in 'seen', it means it's a common element
            if (seen.contains(num)) {
                intersection.add(num); // Add to 'intersection' set
            }
        }

        // Print the union of the two arrays (all unique elements)
        System.out.println("Union: " + union);

        // Print the intersection of the two arrays (common elements)
        System.out.println("Intersection: " + intersection);
    }


    // 6. Merge Two Sorted Arrays
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        // Get the lengths of the two input arrays
        int n = arr1.length, m = arr2.length;

        // Create a new array to hold the merged result with a size of n + m
        int[] result = new int[n + m];

        // Initialize three pointers:
        // i for traversing arr1, j for traversing arr2, and k for inserting into the result array
        int i = 0, j = 0, k = 0;

        // Merge the arrays by comparing elements from arr1 and arr2
        while (i < n && j < m) {
            // If the current element of arr1 is smaller, add it to the result array and move the pointer i
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            }
            // Otherwise, add the current element from arr2 to the result array and move the pointer j
            else {
                result[k++] = arr2[j++];
            }
        }

        // Copy any remaining elements from arr1 into the result array (if any)
        while (i < n) {
            result[k++] = arr1[i++];
        }

        // Copy any remaining elements from arr2 into the result array (if any)
        while (j < m) {
            result[k++] = arr2[j++];
        }

        // Return the merged sorted array
        return result;
    }


    // 7. Move All Zeros to the End of an Array
    public static void moveZerosToEnd(int[] arr) {
        int nonZeroIndex = 0; // Position for the next non-zero element

        // Move non-zero elements forward
        for (int num : arr) {
            if (num != 0) {
                arr[nonZeroIndex++] = num;
            }
        }
        // Fill the remaining spaces with zeros
        while (nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
        System.out.println("Array after moving zeros: " + Arrays.toString(arr));
    }

    // 8. Find the Longest Increasing Subsequence in an Array
    public static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // dp[i] will store the length of LIS ending at index i
        Arrays.fill(dp, 1); // Every element is an increasing subsequence of length 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt(); // Maximum length of LIS
    }

    // 9. Find Pairs in an Array that Sum to a Given Value
    public static void findPairsWithSum(int[] arr, int sum) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = sum - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
            }
            seen.add(num); // Add current number to the set
        }
    }

    // 10. Sort an Array using Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted Array (Bubble Sort): " + Arrays.toString(arr));
    }

    // 11. Find the Maximum Product Subarray
    public static int maxProductSubarray(int[] arr) {
        int maxProd = arr[0], minProd = arr[0], result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                // Swap max and min when a negative number is encountered
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);

            result = Math.max(result, maxProd);
        }
        return result;
    }

    // 12. Find the Minimum Number of Jumps to Reach the End of an Array
    public static int minJumps(int[] arr) {
        if (arr.length <= 1) return 0; // No jump needed if array has 1 element
        if (arr[0] == 0) return -1; // Can't jump if first element is 0

        int jumps = 1, farthest = arr[0], steps = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return jumps; // Reached the end

            farthest = Math.max(farthest, i + arr[i]);
            steps--;

            if (steps == 0) {
                jumps++;
                if (i >= farthest) return -1; // Can't move forward
                steps = farthest - i;
            }
        }
        return -1; // Not reachable
    }

    // 13. Find the Contiguous Subarray with Maximum Sum (Kadane's Algorithm)
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0], currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    // 14. Rearrange Array Alternating Positive and Negative Elements
    public static void rearrangePositiveAndNegative(int[] arr) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int num : arr) {
            if (num >= 0) positive.add(num);
            else negative.add(num);
        }

        int i = 0, pos = 0, neg = 0;

        // Alternate between positive and negative elements
        while (pos < positive.size() && neg < negative.size()) {
            arr[i++] = positive.get(pos++);
            arr[i++] = negative.get(neg++);
        }

        // If any elements remain in either list, append them
        while (pos < positive.size()) arr[i++] = positive.get(pos++);
        while (neg < negative.size()) arr[i++] = negative.get(neg++);

        System.out.println("Rearranged Array: " + Arrays.toString(arr));
    }

    // 15. Find Triplets in an Array that Sum to Zero
    public static void findTripletsWithZeroSum(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) { // Avoid duplicates
                int left = i + 1, right = arr.length - 1;
                while (left < right) {
                    int sum = arr[i] + arr[left] + arr[right];
                    if (sum == 0) {
                        System.out.println("Triplet found: (" + arr[i] + ", " + arr[left] + ", " + arr[right] + ")");
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
    }

    // 16. Find the Kth Smallest and Kth Largest Element in an Array
    public static int findKthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1]; // Return the Kth smallest element
    }

    public static int findKthLargest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k]; // Return the Kth largest element
    }

    // 17. Sort an Array of 0s, 1s, and 2s (Dutch National Flag Problem)
    public static void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low++, mid++);
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high--);
            }
        }
        System.out.println("Sorted 0s, 1s, and 2s: " + Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 18. Find the Frequency of Elements in an Array
    public static void findFrequency(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Frequency of Elements: " + freqMap);
    }

    // 19. Find the Element that Appears More than N/2 Times (Majority Element)
    public static int findMajorityElement(int[] arr) {
        int count = 0, candidate = -1;

        // Find the candidate for majority element
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if the candidate is indeed the majority element
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }
        if (count > arr.length / 2) {
            return candidate;
        } else {
            return -1; // No majority element found
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 3, 7, 8, 5, 0, 9};
        findLargestAndSecondLargest(arr); // Example: Largest: 9, Second Largest: 8

        int[] arr2 = {1, 2, 4, 5};
        System.out.println("Missing Number: " + findMissingNumber(arr2, 5)); // Example: Missing number is 3

        findDuplicates(arr); // Example: Duplicates: [3, 5]
        rotateArray(arr, 2); // Rotated Array by 2 positions

        int[] arr3 = {1, 3, 4, 5};
        int[] arr4 = {3, 5, 7, 9};
        findIntersectionAndUnion(arr3, arr4); // Example: Union: [1, 3, 4, 5, 7, 9], Intersection: [3, 5]

        int[] mergedArray = mergeSortedArrays(arr3, arr4);
        System.out.println("Merged Array: " + Arrays.toString(mergedArray)); // Merged sorted arrays

        moveZerosToEnd(arr); // Example: Array after moving zeros: [3, 5, 6, 3, 7, 8, 5, 9, 0]

        int[] lisArray = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of LIS: " + longestIncreasingSubsequence(lisArray)); // Example: 5

        findPairsWithSum(arr, 12); // Example: Pair found: (5, 7), (3, 9)

        int[] bubbleSortArray = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(bubbleSortArray); // Sorted Array: [11, 12, 22, 25, 34, 64, 90]

        int[] productArray = {6, -3, -10, 0, 2};
        System.out.println("Maximum Product Subarray: " + maxProductSubarray(productArray)); // Example: 180

        int[] jumpsArray = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Minimum Jumps: " + minJumps(jumpsArray)); // Example: 3

        int[] kadaneArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum(kadaneArray)); // Example: 6

        rearrangePositiveAndNegative(arr); // Rearranged Array: [3, 0, 5, 9, 6, 8, 3, 7, 5]

        int[] tripletArray = {-1, 0, 1, 2, -1, -4};
        findTripletsWithZeroSum(tripletArray); // Example: (-1, 0, 1), (-1, -1, 2)

        int[] kthArray = {7, 10, 4, 3, 20, 15};
        System.out.println("Kth Smallest: " + findKthSmallest(kthArray, 3)); // Example: 7
        System.out.println("Kth Largest: " + findKthLargest(kthArray, 3)); // Example: 10

        int[] dutchArray = {0, 1, 2, 1, 2, 0, 1, 2};
        sort012(dutchArray); // Example: Sorted 0s, 1s, and 2s: [0, 0, 1, 1, 1, 2, 2, 2]

        int[] freqArray = {2, 3, 2, 4, 5, 6, 2, 3};
        findFrequency(freqArray); // Frequency of Elements: {2=3, 3=2, 4=1, 5=1, 6=1}

        int[] majorityArray = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Majority Element: " + findMajorityElement(majorityArray)); // Example: 4
    }
}

