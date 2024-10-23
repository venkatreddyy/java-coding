package com.venkat.challenges.top15;

public class PalindromeString {

    // Method to check if a given string is a palindrome
    public static boolean isPalindrome(String str) {
        // Initialize two pointers: left starts at the beginning, right starts at the end of the string
        int left = 0, right = str.length() - 1;

        // Loop until the left pointer crosses the right pointer
        while (left < right) {
            // If the characters at the left and right pointers are not the same, return false (not a palindrome)
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            // Move the left pointer to the right
            left++;
            // Move the right pointer to the left
            right--;
        }

        // If the loop completes without finding mismatched characters, return true (the string is a palindrome)
        return true;
    }

    public static void main(String[] args) {
        // Test case: defining a string to check if it's a palindrome
        String str = "madam";

        // Calling isPalindrome method and printing the result (whether the string is a palindrome or not)
        System.out.println("Is Palindrome: " + isPalindrome(str)); // Output: true
    }
}

