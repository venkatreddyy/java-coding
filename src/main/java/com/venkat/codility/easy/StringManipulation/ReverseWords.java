package com.venkat.codility.easy.StringManipulation;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        String result = reverseWords("  Hello World  ");
        System.out.println("Reversed Words: " + result); // Output: "World Hello"
    }
}

