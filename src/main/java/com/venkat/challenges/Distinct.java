package com.venkat.challenges;

import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;
/*
Time Complexity of the Original Solution:
Sorting: O(n log n).
Loop for counting duplicates: O(n).
So, the overall time complexity is O(n log n).
The improved solution with a Set has a time complexity of O(n)
 */
public class Distinct {
    public static void main (String[] args) {
        int[] A = new int[] {2, 1, 1, 2, 3};
        System.out.println(solution(A));  // Output: 3
    }

    public static int solution(int[] A) {
        Set<Integer> distinctElements = new HashSet<>();
        for (int num : A) {
            distinctElements.add(num);  // HashSet automatically handles duplicates
        }
        return distinctElements.size();  // Return the size of the Set
    }
}

