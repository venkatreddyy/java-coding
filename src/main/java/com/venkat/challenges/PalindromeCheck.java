package com.venkat.challenges;

public class PalindromeCheck {

    // Method to check if a given string is a palindrome
    public static boolean isPalindrome(String str) {
        // Initialize two pointers: 'left' starts at the beginning of the string and 'right' at the end
        int left = 0, right = str.length() - 1;

        // Continue checking characters while 'left' is less than 'right'
        while (left < right) {
            // If the characters at the 'left' and 'right' indices are not equal, it's not a palindrome
            if (str.charAt(left) != str.charAt(right)) {
                return false;  // Return false immediately if a mismatch is found
            }
            // Move the 'left' pointer one step forward and the 'right' pointer one step backward
            left++;
            right--;
        }

        // If the loop completes without finding a mismatch, the string is a palindrome
        return true;
    }

    // Main method to test the isPalindrome function
    public static void main(String[] args) {
        // Test with the string "madam"
        System.out.println(isPalindrome("madam"));  // Output: true

        // Test with the string "hello"
        System.out.println(isPalindrome("hello"));  // Output: false
    }
}


