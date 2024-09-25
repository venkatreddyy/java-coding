package com.venkat.programs.basic;


public class StringOperations {

    // 1) Count total number of characters in a string (without using length method)
    public static int countTotalCharacters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count++;
        }
        return count;
    }

    // 2) Count total number of punctuation characters in a string
    public static int countPunctuationCharacters(String str) {
        int count = 0;
        for (int i = 0; i < countTotalCharacters(str); i++) {
            char c = str.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && !(c >= '0' && c <= '9') && c != ' ') {
                count++;
            }
        }
        return count;
    }

    // 3) Count total number of vowels and consonants in a string
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < countTotalCharacters(str); i++) {
            char c = str.charAt(i);
            if ((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
                vowels++;
            } else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // 4) Check if two strings are anagrams (without using built-in sort)
    public static boolean areAnagrams(String str1, String str2) {
        if (countTotalCharacters(str1) != countTotalCharacters(str2)) return false;

        int[] freq1 = new int[256]; // ASCII characters frequency array
        int[] freq2 = new int[256];

        for (int i = 0; i < countTotalCharacters(str1); i++) {
            freq1[str1.charAt(i)]++;
            freq2[str2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    // 5) Divide a string into 'N' equal parts
    public static void divideStringIntoNParts(String str, int n) {
        int totalLength = countTotalCharacters(str);
        int partSize = totalLength / n;

        for (int i = 0; i < totalLength; i += partSize) {
            for (int j = i; j < i + partSize; j++) {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }

    // 6) Find all subsets of a string (without using substring function)
    public static void findAllSubsets(String str) {
        int totalLength = countTotalCharacters(str);
        for (int i = 0; i < totalLength; i++) {
            for (int j = i + 1; j <= totalLength; j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(str.charAt(k));
                }
                System.out.println();
            }
        }
    }

    // 7) Find the longest repeating sequence in a string
    public static String findLongestRepeatingSequence(String str) {
        String longest = "";
        int totalLength = countTotalCharacters(str);
        for (int i = 0; i < totalLength; i++) {
            for (int j = i + 1; j < totalLength; j++) {
                int k = 0;
                while (j + k < totalLength && str.charAt(i + k) == str.charAt(j + k)) {
                    k++;
                }
                if (k > longest.length()) {
                    longest = "";
                    for (int x = 0; x < k; x++) {
                        longest += str.charAt(i + x);
                    }
                }
            }
        }
        return longest;
    }

    // 8) Reverse a string (without using built-in reverse)
    public static String reverseString(String str) {
        int totalLength = countTotalCharacters(str);
        char[] reversed = new char[totalLength];
        for (int i = 0; i < totalLength; i++) {
            reversed[totalLength - i - 1] = str.charAt(i);
        }
        return new String(reversed);
    }

    // 9) Check if a string is palindrome (without using reverse function)
    public static boolean isPalindrome(String str) {
        int totalLength = countTotalCharacters(str);
        for (int i = 0; i < totalLength / 2; i++) {
            if (str.charAt(i) != str.charAt(totalLength - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 10) Reverse string word by word (without using split or reverse functions)
    public static String reverseStringWordByWord(String str) {
        StringBuilder result = new StringBuilder();
        int totalLength = countTotalCharacters(str);
        int end = totalLength;
        for (int i = totalLength - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ' || i == 0) {
                int start = i == 0 ? i : i + 1;
                for (int j = start; j < end; j++) {
                    result.append(str.charAt(j));
                }
                if (i != 0) result.append(' ');
                end = i;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Total Characters: " + countTotalCharacters("Hello World"));
        System.out.println("Punctuation Characters: " + countPunctuationCharacters("Hello, World!"));
        countVowelsAndConsonants("Hello World");
        System.out.println("Are Anagrams: " + areAnagrams("listen", "silent"));
        divideStringIntoNParts("abcdefgh", 4);
        findAllSubsets("abc");
        System.out.println("Longest Repeating Sequence: " + findLongestRepeatingSequence("abcabc"));
        System.out.println("Reversed String: " + reverseString("Hello World"));
        System.out.println("Is Palindrome: " + isPalindrome("madam"));
        System.out.println("Reversed Word by Word: " + reverseStringWordByWord("Hello World"));
    }
}
