package com.venkat.codility.hard.StringManipulation;
/*
o solve the Longest Palindromic Subsequence problem in Java, we can use dynamic programming. The longest palindromic subsequence problem involves finding the length of the longest subsequence in a given string that is also a palindrome.

Approach:
Define Subproblems:
Use a 2D DP array dp[i][j], where dp[i][j] represents the length of the longest palindromic subsequence in the substring s[i...j].
Base Cases:
A single character is a palindrome of length 1, so dp[i][i] = 1 for all i.
Fill the DP Array:
For substrings of length 2 and more, if the characters at both ends match (s[i] == s[j]), then dp[i][j] = dp[i + 1][j - 1] + 2.
If the characters at both ends don’t match, then the result for dp[i][j] is the maximum of dp[i + 1][j] and dp[i][j - 1].
Result:
The value dp[0][n-1] (where n is the length of the string) will contain the length of the longest palindromic subsequence for the entire string.


Explanation
Initialization:

Each single character is a palindromic subsequence of length 1, so dp[i][i] = 1 for all i.
Filling DP Array:

We consider all possible substring lengths (starting from 2 up to the length of the string).
For each substring, if the characters at the current ends i and j are equal, they contribute to the palindromic subsequence length, adding 2 to the result of the substring s[i + 1 ... j - 1].
If the characters do not match, the longest subsequence is the maximum length found by either moving i forward or j backward.
Result:

The final answer for the entire string’s longest palindromic subsequence is stored in dp[0][n-1].
Example
For the input string "bbbab":

Longest Palindromic Subsequence: "bbbb" (length 4)
Output:

Example
For the input string "bbbab":

Longest Palindromic Subsequence: "bbbb" (length 4)
Output:

mathematica
Copy code
Longest Palindromic Subsequence Length: 4
Complexity Analysis
Time Complexity:
𝑂
(
𝑛
2
)
O(n
2
 ), where
𝑛
n is the length of the string, due to the nested loop filling the DP array.
Space Complexity:
𝑂
(
𝑛
2
)
O(n
2
 ), for storing the dp table.

 */
public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: Single character substrings are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the dp array for substrings of length 2 and more
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // The answer is in dp[0][n-1], the longest palindromic subsequence in the entire string
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        int result = longestPalindromeSubseq(s);
        System.out.println("Longest Palindromic Subsequence Length: " + result); // Expected Output: 4
    }
}

