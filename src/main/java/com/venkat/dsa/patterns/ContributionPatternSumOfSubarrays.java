package com.venkat.dsa.patterns;

/*
Contribution Pattern
The Contribution Pattern is a problem-solving strategy that involves calculating how often an element or a set of elements contributes to the final result. This pattern is commonly used in combinatorial problems, especially when summing over multiple subarrays, subsequences, or intervals. Instead of calculating the result for each subarray or subsequence explicitly, the Contribution Pattern calculates how each individual element contributes to all possible subarrays or subsequences it belongs to.

Key Idea:
For each element in a sequence (array, string, etc.), determine:

How many times it contributes to the final answer.
In what ways it can contribute (e.g., as part of a subarray, subsequence, interval, etc.).
By focusing on individual contributions instead of constructing every subarray or subsequence, this pattern can significantly optimize the solution to certain problems.

Example Problem 1: Sum of All Subarrays
Given an array, find the sum of all possible subarrays. Instead of calculating the sum of each subarray explicitly, we can use the contribution pattern to determine how much each element contributes to the final sum.

Naive Approach:
A naive approach would involve generating every subarray, calculating the sum for each, and summing these sums. This would take O(n^2) time because there are n(n+1)/2 subarrays in total.

Optimized Contribution Pattern Approach:
For an element at index i, the number of subarrays in which it appears can be calculated by:

Left side: It can start from any index from 0 to i (inclusive), so it appears in i + 1 subarrays starting from earlier indices.
Right side: It can end at any index from i to n-1 (inclusive), so it appears in n - i subarrays ending at later indices.
Thus, the total number of subarrays that include the element at index i is (i + 1) * (n - i).

Formula:
For each element arr[i] at index i, its total contribution to the sum of all subarrays is:

Explanation:
Subarrays that include arr[0] = 1: It contributes to subarrays [1], [1, 2], [1, 2, 3].
Subarrays that include arr[1] = 2: It contributes to subarrays [2], [1, 2], [2, 3], [1, 2, 3].
Subarrays that include arr[2] = 3: It contributes to subarrays [3], [2, 3], [1, 2, 3].
Output:
For the array {1, 2, 3}, the sum of all subarrays is:

css
Copy code
Sum of all subarrays: 20


 */
public class ContributionPatternSumOfSubarrays {

    // Function to calculate the sum of all subarrays using the contribution pattern
    public static int sumOfAllSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        // Calculate the contribution of each element
        for (int i = 0; i < n; i++) {
            // Number of subarrays in which arr[i] appears
            int contribution = (i + 1) * (n - i);
            // Add the contribution of arr[i] to the total sum
            totalSum += arr[i] * contribution;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; // Example array
        int result = sumOfAllSubarrays(arr);
        System.out.println("Sum of all subarrays: " + result); // Output: 20
    }
}

