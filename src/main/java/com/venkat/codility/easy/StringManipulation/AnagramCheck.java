package com.venkat.codility.easy.StringManipulation;

import java.util.Arrays;

public class AnagramCheck {
    public static boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        boolean result = isAnagram("listen", "silent");
        System.out.println("Is Anagram: " + result); // Output: true
    }
}

