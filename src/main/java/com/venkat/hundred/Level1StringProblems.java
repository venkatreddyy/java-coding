package com.venkat.hundred;

import java.util.*;
/*
Explanation of Each Problem and Test Cases:
Reverse Words in a String: Reverses the words in a given string.

Output: "blue is sky the"
Longest Common Prefix: Finds the longest common prefix among an array of strings.

Output: "fl"
Roman Number to Integer: Converts a Roman numeral string to an integer.

Output: 1994
Integer to Roman: Converts an integer to a Roman numeral string.

Output: "MCMXCIV"
Hamming Distance (Closest Strings): Computes the Hamming distance between two strings.

Output: 3
Divisible by 7: Checks if a number represented as a string is divisible by 7.

Output: true
Encrypt the String: Compresses a string by counting consecutive characters.

Output: "a3b2c4"
Equal Point in a String of Brackets: Finds the index where the number of opening and closing brackets are equal.

Output: 4
Isomorphic Strings: Checks if two strings are isomorphic.

Output: true
k-Anagrams: Checks if two strings are k-anagrams (can be made anagrams by changing at most k characters).

Output: true
Pangram Checking: Checks if a string contains every letter of the alphabet at least once.

Output: true
Minimum Deletions to Make a String a Palindrome: Finds the minimum number of deletions required to make a string a palindrome.

Output: 1
Number of Distinct Subsequences: Finds how many distinct subsequences of a string match a target string.

Output: 3
Check if String is Rotated by Two Places: Checks if one string is a rotation of another by exactly two places.

Output: true

 */
public class Level1StringProblems {

    // 1. Reverse words in a given string
    // Time Complexity: O(n), where n is the length of the string
    // Space Complexity: O(n), for storing the result
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // Split the string by spaces
        Collections.reverse(Arrays.asList(words)); // Reverse the array of words
        return String.join(" ", words); // Join the words back together
    }

    // 2. Longest Common Prefix
    // Time Complexity: O(n * m), where n is the number of strings and m is the length of the shortest string
    // Space Complexity: O(1), no extra space used except for a few variables
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return ""; // Edge case: empty input
        String prefix = strs[0]; // Start with the first string as the prefix
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // While current string does not start with the prefix
                prefix = prefix.substring(0, prefix.length() - 1); // Reduce the prefix by 1 character
                if (prefix.isEmpty()) return ""; // If no common prefix, return empty string
            }
        }
        return prefix; // Return the longest common prefix
    }

    // 3. Roman Number to Integer
    // Time Complexity: O(n), where n is the length of the Roman numeral
    // Space Complexity: O(1), fixed space for a few variables
    public static int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentVal = roman.get(s.charAt(i));
            // If the current value is less than the next value, subtract it, otherwise add it
            if (i < s.length() - 1 && currentVal < roman.get(s.charAt(i + 1))) {
                total -= currentVal;
            } else {
                total += currentVal;
            }
        }
        return total;
    }

    // 4. Integer to Roman
    // Time Complexity: O(1), since the number range is limited from 1 to 3999
    // Space Complexity: O(1), fixed space for string arrays and variables
    public static String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"}; // Thousands
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // Hundreds
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // Tens
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // Ones

        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10]; // Concatenate the Roman numerals
    }

    // 5. Closest Strings (Hamming Distance)
    // Time Complexity: O(n), where n is the length of the strings
    // Space Complexity: O(1), no extra space is used
    public static int hammingDistance(String s1, String s2) {
        if (s1.length() != s2.length()) return -1; // Hamming distance is only defined for strings of equal length
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++; // Count the number of differing characters
        }
        return count;
    }

    // 6. Divisible by 7
    // Time Complexity: O(n), where n is the number of digits in the number
    // Space Complexity: O(1), only a few variables are used
    public static boolean isDivisibleBy7(String num) {
        int remainder = 0;
        for (int i = 0; i < num.length(); i++) {
            remainder = (remainder * 10 + (num.charAt(i) - '0')) % 7; // Compute remainder when divided by 7
        }
        return remainder == 0; // Return true if divisible by 7, else false
    }

    // 7. Encrypt the String – II (Count characters in sequence and append count)
    // Time Complexity: O(n), where n is the length of the string
    // Space Complexity: O(n), for storing the result
    public static String encryptString(String s) {
        StringBuilder encrypted = new StringBuilder();
        int count = 1; // Initialize count of current character
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // If the current character matches the previous one, increment count
            } else {
                encrypted.append(s.charAt(i - 1)).append(count); // Append the character and its count
                count = 1; // Reset count for the new character
            }
        }
        encrypted.append(s.charAt(s.length() - 1)).append(count); // Append the last character and its count
        return encrypted.toString(); // Return the encrypted string
    }

    // 8. Equal point in a string of brackets (balanced string)
    // Time Complexity: O(n), where n is the length of the string
    // Space Complexity: O(1), only a few variables are used
    public static int equalPointInBrackets(String s) {
        int open = 0, close = 0;
        // Traverse the string and count the number of closing brackets
        for (char c : s.toCharArray()) {
            if (c == ')') close++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') close--; // Decrease closing brackets count
            if (s.charAt(i) == '(') open++; // Increase open brackets count
            if (open == close) return i + 1; // If open equals close, return the current index
        }
        return -1; // No equal point found
    }

    // 9. Isomorphic Strings
    // Time Complexity: O(n), where n is the length of the strings
    // Space Complexity: O(1), since there are fixed mappings for ASCII characters
    public static boolean isIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
            } else {
                map1.put(c1, c2);
            }
            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) return false;
            } else {
                map2.put(c2, c1);
            }
        }
        return true;
    }

    // 10. Check if two strings are k-anagrams or not
    // Time Complexity: O(n), where n is the length of the strings
    // Space Complexity: O(1), for fixed character array of size 26
    public static boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length()) return false;
        int[] count = new int[26]; // To count the frequency of characters
        for (char c : s1.toCharArray()) count[c - 'a']++; // Count characters in s1
        for (char c : s2.toCharArray()) count[c - 'a']--; // Decrease count for characters in s2
        int difference = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) difference += count[i]; // Count the number of differing characters
        }
        return difference <= k; // If the difference is <= k, return true
    }

// 11.
// 11. Panagram Checking
// Time Complexity: O(n), where n is the length of the string
// Space Complexity: O(1), because we only use a fixed array of size 26
public static boolean isPangram(String s) {
    boolean[] present = new boolean[26]; // Array to mark the presence of each letter
    for (char c : s.toLowerCase().toCharArray()) {
        if (c >= 'a' && c <= 'z') { // Consider only lowercase letters
            present[c - 'a'] = true; // Mark the letter as present
        }
    }
    for (boolean p : present) {
        if (!p) return false; // If any letter is missing, return false
    }
    return true; // Return true if all letters are present
}

    // 12. Minimum Deletions to make a string palindrome
    // Time Complexity: O(n^2), where n is the length of the string (due to dynamic programming)
    // Space Complexity: O(n^2), for the DP table
    public static int minimumDeletionsToPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // DP table to store minimum deletions
        for (int i = 0; i < n; i++) dp[i][i] = 0; // Base case: single character is already a palindrome

        for (int len = 2; len <= n; len++) { // Length of substring
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1; // End index of substring
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1]; // If characters match, no deletion needed
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]); // Otherwise, delete one character
                }
            }
        }
        return dp[0][n - 1]; // Minimum deletions for the entire string
    }

    // 13. Number of Distinct Subsequences
    // Time Complexity: O(n * m), where n is the length of the target and m is the length of the source
    // Space Complexity: O(n * m), for the DP table
    public static int distinctSubsequences(String source, String target) {
        int m = source.length();
        int n = target.length();
        int[][] dp = new int[n + 1][m + 1]; // DP table to store subsequences

        for (int j = 0; j <= m; j++) dp[0][j] = 1; // Base case: empty target string

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (target.charAt(i - 1) == source.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]; // Count subsequences with and without current character
                } else {
                    dp[i][j] = dp[i][j - 1]; // If characters don't match, ignore current character in source
                }
            }
        }
        return dp[n][m]; // Return number of distinct subsequences for the entire string
    }

    // 14. Check if string is rotated by two places
    // Time Complexity: O(n), where n is the length of the string
    // Space Complexity: O(n), for storing concatenated string
    public static boolean isRotatedByTwoPlaces(String s1, String s2) {
        if (s1.length() != s2.length()) return false; // Lengths must be the same
        String clockwise = s1.substring(2) + s1.substring(0, 2); // Clockwise rotation
        String counterClockwise = s1.substring(s1.length() - 2) + s1.substring(0, s1.length() - 2); // Counter-clockwise rotation
        return s2.equals(clockwise) || s2.equals(counterClockwise); // Check if s2 matches any rotation
    }

    // Main method to test all the functions
    public static void main(String[] args) {
        // Test case 1: Reverse words in a string
        System.out.println("Reverse Words: " + reverseWords("the sky is blue")); // Expected: "blue is sky the"

        // Test case 2: Longest Common Prefix
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs)); // Expected: "fl"

        // Test case 3: Roman to Integer
        System.out.println("Roman to Integer: " + romanToInt("MCMXCIV")); // Expected: 1994

        // Test case 4: Integer to Roman
        System.out.println("Integer to Roman: " + intToRoman(1994)); // Expected: "MCMXCIV"

        // Test case 5: Closest Strings (Hamming Distance)
        System.out.println("Hamming Distance: " + hammingDistance("karolin", "kathrin")); // Expected: 3

        // Test case 6: Divisible by 7
        System.out.println("Divisible by 7: " + isDivisibleBy7("343")); // Expected: true

        // Test case 7: Encrypt the String
        System.out.println("Encrypt String: " + encryptString("aaabbcccc")); // Expected: "a3b2c4"

        // Test case 8: Equal point in a string of brackets
        System.out.println("Equal Point in Brackets: " + equalPointInBrackets("(()))(")); // Expected: 4

        // Test case 9: Isomorphic Strings
        System.out.println("Is Isomorphic: " + isIsomorphic("egg", "add")); // Expected: true

        // Test case 10: k-Anagrams
        System.out.println("Are k-Anagrams: " + areKAnagrams("fodr", "gork", 2)); // Expected: true

        // Test case 11: Panagram Checking
        System.out.println("Is Pangram: " + isPangram("The quick brown fox jumps over the lazy dog")); // Expected: true

        // Test case 12: Minimum Deletions to make a string palindrome
        System.out.println("Minimum Deletions: " + minimumDeletionsToPalindrome("abdbca")); // Expected: 1

        // Test case 13: Number of Distinct Subsequences
        System.out.println("Distinct Subsequences: " + distinctSubsequences("rabbbit", "rabbit")); // Expected: 3

        // Test case 14: Check if string is rotated by two places
        System.out.println("Is Rotated by Two Places: " + isRotatedByTwoPlaces("amazon", "onamaz")); // Expected: true
    }
}

