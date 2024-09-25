package com.venkat.hundred;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


public class StringPrograms {

    // 1. Reverse a String
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // 2. Check if a String is a Palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equals(reversed);
    }

    // 3. Find the First Non-repeated Character in a String
    public static Character firstNonRepeatedChar(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    // 4. Check if Two Strings are Anagrams
    /*
    Characteristics of Anagrams:
The words have the same length.
They use the same letters, with the same frequency, but in different orders.
Example Anagrams:
"listen" and "silent"
"evil" and "vile"
"elbow" and "below"
     */
    public static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // 5. Count the Number of Words in a String
    public static int countWords(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        /*
        In the context of regular expressions in Java, \s is often used when you need to find or replace any kind of whitespace.
        \s+ matches one or more consecutive whitespace characters (spaces, tabs, newlines, etc.).It’s useful for collapsing multiple spaces into one, splitting text by spaces or other whitespace, or cleaning up strings that may have irregular spacing.
         */
        String[] words = str.split("\\s+");
        return words.length;
    }

    // 6. Remove Duplicate Characters from a String
    public static String removeDuplicates(String str) {
        Set<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

    // 7. Find All Permutations of a String
    public static void findPermutations(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            findPermutations(ros, ans + ch);
        }
    }

    // 8. Reverse Each Word in a Sentence
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        return result.toString().trim();
    }

    // 9. Convert a String to an Integer
    public static int stringToInt(String str) {
        return Integer.parseInt(str);
    }

    // 10. Check if a String Contains Only Digits
    public static boolean containsOnlyDigits(String str) {
        return str.matches("\\d+");
    }

    // 11. Longest Substring Without Repeating Characters
    public static int longestSubstringWithoutRepeatingChars(String str) {
        // A set to keep track of characters in the current window (substring) without duplicates
        Set<Character> seen = new HashSet<>();

        // 'left' pointer will indicate the start of the sliding window, initialized to 0
        int left = 0;

        // 'maxLen' will store the maximum length of substrings without repeating characters, initialized to 0
        int maxLen = 0;

        // Loop through each character in the string using the 'right' pointer to expand the sliding window
        for (int right = 0; right < str.length(); right++) {

            // If the current character at 'right' pointer is already in the set (i.e., duplicate character found)
            while (seen.contains(str.charAt(right))) {
                // Remove the character at 'left' pointer to shrink the window until there are no duplicates
                seen.remove(str.charAt(left++));
            }

            // Add the current character at 'right' pointer to the set (extend the window)
            seen.add(str.charAt(right));

            // Calculate the length of the current valid substring (right - left + 1)
            // Update 'maxLen' if the current substring is longer than the previous longest one
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Return the maximum length of the substring without repeating characters
        return maxLen;
    }


    // 12. Find the Longest Palindromic Substring
    public static String longestPalindromicSubstring(String str) {
        // If the input string is null or empty, return an empty string as there is no valid palindrome
        if (str == null || str.length() < 1) return "";

        // Variables 'start' and 'end' will keep track of the starting and ending indices of the longest palindrome found
        int start = 0, end = 0;

        // Loop through each character of the string, treating each as a potential center of a palindrome
        for (int i = 0; i < str.length(); i++) {

            // Case 1: Expand around a single character (odd-length palindrome)
            int len1 = expandFromCenter(str, i, i);

            // Case 2: Expand around two consecutive characters (even-length palindrome)
            int len2 = expandFromCenter(str, i, i + 1);

            // Take the maximum length between the odd-length and even-length palindrome found at this index
            int len = Math.max(len1, len2);

            // If the current palindrome length is greater than the previously found maximum length
            if (len > end - start) {
                // Update the 'start' index of the longest palindrome found
                // The new start index is calculated using the center index 'i' and the length of the palindrome
                start = i - (len - 1) / 2;

                // Update the 'end' index of the longest palindrome found
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring using the calculated 'start' and 'end' indices
        return str.substring(start, end + 1);
    }

    // Helper function that expands around the center and returns the length of the palindrome
    private static int expandFromCenter(String str, int left, int right) {
        // While the characters at 'left' and 'right' are equal, expand the window outwards
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;  // Move the left pointer leftwards
            right++; // Move the right pointer rightwards
        }
        // Return the length of the palindrome found, which is the difference between 'right' and 'left' indices
        return right - left - 1;
    }


    // 13. Remove All Vowels from a String
    public static String removeVowels(String str) {
        return str.replaceAll("[AEIOUaeiou]", "");
    }

    // 14. Implement String Compression (e.g., "aabcccccaaa" becomes "a2b1c5a3")
    public static String compressString(String str) {
        // StringBuilder to store the compressed version of the string.
        StringBuilder compressed = new StringBuilder();

        // Variable to count the occurrences of each character, initialized to 1.
        int count = 1;

        // Loop through each character of the input string.
        for (int i = 0; i < str.length(); i++) {

            // If the next character is the same as the current one, increment the count.
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                // If the next character is different, append the current character and its count to the compressed string.
                compressed.append(str.charAt(i)).append(count);

                // Reset the count to 1 for the next character.
                count = 1;
            }
        }

        // If the compressed string is shorter than the original, return the compressed version.
        // Otherwise, return the original string.
        return compressed.length() < str.length() ? compressed.toString() : str;
    }


    // 15. Check if a String is a Valid Shuffle of Two Strings
    public static boolean isValidShuffle(String str1, String str2, String result) {
        if (str1.length() + str2.length() != result.length()) {
            return false;
        }
        int i = 0, j = 0, k = 0;
        while (k < result.length()) {
            if (i < str1.length() && str1.charAt(i) == result.charAt(k)) {
                i++;
            } else if (j < str2.length() && str2.charAt(j) == result.charAt(k)) {
                j++;
            } else {
                return false;
            }
            k++;
        }
        return i == str1.length() && j == str2.length();
    }

    public static void main(String[] args) {
        // Testing each method

        // 1. Reverse String
        // Input: "hello"
        // Output: "olleh"
        System.out.println("Reverse String: " + reverseString("hello"));

        // 2. Is Palindrome
        // Input: "madam"
        // Output: true
        System.out.println("Is Palindrome: " + isPalindrome("madam"));

        // 3. First Non-Repeated Character
        // Input: "swiss"
        // Output: 'w'
        System.out.println("First Non-Repeated Char: " + firstNonRepeatedChar("swiss"));

        // 4. Are Anagrams
        // Input: "listen", "silent"
        // Output: true
        System.out.println("Are Anagrams: " + areAnagrams("listen", "silent"));

        // 5. Count Words
        // Input: "This is a test string"
        // Output: 5
        System.out.println("Word Count: " + countWords("This is a test string"));

        // 6. Remove Duplicates
        // Input: "programming"
        // Output: "progamin"
        System.out.println("Remove Duplicates: " + removeDuplicates("programming"));

        // 7. Find All Permutations
        // Input: "abc"
        // Output: (prints all permutations) abc, acb, bac, bca, cab, cba
        System.out.println("All Permutations:");
        findPermutations("abc", "");

        // 8. Reverse Each Word
        // Input: "hello world"
        // Output: "olleh dlrow"
        System.out.println("Reverse Each Word: " + reverseEachWord("hello world"));

        // 9. String to Integer
        // Input: "1234"
        // Output: 1234
        System.out.println("String to Integer: " + stringToInt("1234"));

        // 10. Contains Only Digits
        // Input: "1234"
        // Output: true
        System.out.println("Contains Only Digits: " + containsOnlyDigits("1234"));

        // 11. Longest Substring Without Repeating Characters
        // Input: "abcabcbb"
        // Output: 3 (the longest substring is "abc")
        System.out.println("Longest Substring Without Repeating Characters: " + longestSubstringWithoutRepeatingChars("abcabcbb"));

        // 12. Longest Palindromic Substring
        // Input: "babad"
        // Output: "bab" (or "aba" since both are valid)
        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstring("babad"));

        // 13. Remove Vowels
        // Input: "beautiful"
        // Output: "btfl"
        System.out.println("Remove Vowels: " + removeVowels("beautiful"));

        // 14. String Compression
        // Input: "aabcccccaaa"
        // Output: "a2b1c5a3"
        System.out.println("String Compression: " + compressString("aabcccccaaa"));

        // 15. Is Valid Shuffle
        // Input: "abc", "def", "adbcef"
        // Output: true
        System.out.println("Is Valid Shuffle: " + isValidShuffle("abc", "def", "adbcef"));
    }
}

