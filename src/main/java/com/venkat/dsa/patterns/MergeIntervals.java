package com.venkat.dsa.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Overlapping Intervals:
The problem of overlapping intervals involves merging intervals that overlap with each other. If intervals overlap, they can be combined into a single interval. This is a common problem in time scheduling or range management systems.

Example:
You are given an array of intervals where each interval is a pair [start, end], and you need to merge the overlapping intervals.

For example, given the intervals [[1,3], [2,6], [8,10], [15,18]], the merged output would be [[1,6], [8,10], [15,18]].

Approach:
To solve this, we follow these steps:

Sort the intervals by the start time.
Iterate through the sorted intervals:
If the current interval does not overlap with the last merged interval, add it to the result.
If it overlaps, merge the intervals by adjusting the end time of the last merged interval.

Output:
For the input intervals [[1, 3], [2, 6], [8, 10], [15, 18]], the output will be:

csharp
Copy code
Merged Intervals:
[1, 6]
[8, 10]
[15, 18]
Edge Cases:
If the intervals array is empty, simply return an empty array.
If there is only one interval, return the interval itself since no merging is required.
This approach efficiently solves the overlapping intervals problem by leveraging sorting and a linear scan.

 */
public class MergeIntervals {

    // Method to merge overlapping intervals
    public static int[][] merge(int[][] intervals) {
        // If there's one or no interval, return it as no merging is needed
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by the starting point of each interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // 'a[0]' refers to the start of the first interval, 'b[0]' refers to the start of the second interval

        // A list to store the merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();

        // Start with the first interval (already sorted)
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval); // Add the first interval to the merged list

        // Iterate through all intervals
        for (int[] interval : intervals) {
            // Extract the start and end points of the current merged interval
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];

            // Extract the start and end points of the next interval in the array
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // Check if the current interval overlaps with the next interval
            if (currentEnd >= nextStart) {
                // If they overlap, merge the intervals by updating the end of the current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // If there's no overlap, move to the next interval and add it to the merged list
                currentInterval = interval; // Current interval is now the new interval
                mergedIntervals.add(currentInterval); // Add the non-overlapping interval to the result
            }
        }

        // Convert the merged intervals from List to a 2D array before returning
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        // Example input: array of intervals
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        // Call the merge function to merge the overlapping intervals
        int[][] result = merge(intervals);

        // Output the merged intervals
        System.out.println("Merged Intervals: ");
        for (int[] interval : result) {
            // Print each interval in the format [start, end]
            System.out.println(Arrays.toString(interval));
        }
    }
}


