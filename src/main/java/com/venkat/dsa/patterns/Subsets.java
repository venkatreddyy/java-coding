package com.venkat.dsa.patterns;

import java.util.ArrayList;
import java.util.List;
/*
Backtracking is a general algorithmic technique that incrementally builds solutions to problems, and abandons a partial solution ("backtracks") if it determines that the solution cannot be completed to a valid solution. Backtracking is particularly useful for solving combinatorial and decision problems, such as generating all permutations, subsets, and solving puzzles like Sudoku or the N-Queens problem.

Key Concepts of Backtracking:
Recursive Approach: Backtracking typically involves recursive calls to explore all possible options.
Pruning: If a partial solution cannot be extended to a valid solution, the algorithm backtracks and tries another path (prunes the recursion tree).
State Space Tree: The problem is represented as a tree where each node represents a decision.
Common Problems Solved with Backtracking:
Generating all permutations or combinations of a set.
Solving constraint problems (e.g., N-Queens problem).
Subset sum problems.
Sudoku solving.
Example 1: Solving the N-Queens Problem
The N-Queens problem asks you to place N queens on an N×N chessboard so that no two queens threaten each other (no two queens can be in the same row, column, or diagonal).

Approach:
We start by placing queens row by row.
At each step, we check if placing a queen in a given column is safe (i.e., it doesn't conflict with previously placed queens).
If placing a queen is safe, we move to the next row. If no valid positions are found in the current row, we backtrack to the previous row and try a different column.


All subsets:
[]
[1]
[1, 2]
[1, 2, 3]
[1, 3]
[2]
[2, 3]
[3]

 */
public class Subsets {

    // Main function to generate all subsets of a set
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    // Backtracking function to generate subsets
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset (tempList) to the result
        result.add(new ArrayList<>(tempList));

        // Explore all options by adding elements one by one
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // Include the current element
            backtrack(result, tempList, nums, i + 1); // Recurse with the next element
            tempList.remove(tempList.size() - 1); // Backtrack: remove the last added element
        }
    }

    // Main function to test the subsets function
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);

        // Print all subsets
        System.out.println("All subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
