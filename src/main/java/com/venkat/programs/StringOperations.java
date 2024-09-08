package com.venkat.programs;

import java.util.*;

public class StringOperations {

    // 1) Count total number of characters in a string
    public static int countTotalCharacters(String str) {
        return str.length();
    }

    // 2) Count total number of characters in a string 2 (alternative)
    public static int countTotalCharactersWithoutLength(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count++;
        }
        return count;
    }

    // 3) Count total number of punctuation characters in a string
    public static int countPunctuationCharacters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                count++;
            }
        }
        return count;
    }

    // 4) Count total number of vowels and consonants in a string
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        String vowelsList = "aeiouAEIOU";
        for (char c : str.toCharArray()) {
            if (vowelsList.indexOf(c) != -1) {
                vowels++;
            } else if (Character.isLetter(c)) {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // 5) Check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // 6) Divide a string into 'N' equal parts
    public static void divideStringIntoNParts(String str, int n) {
        int partSize = str.length() / n;
        for (int i = 0; i < str.length(); i += partSize) {
            System.out.println(str.substring(i, i + partSize));
        }
    }

    // 7) Find all subsets of a string
    public static void findAllSubsets(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

    // 8) Find the longest repeating sequence in a string
    public static String findLongestRepeatingSequence(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String subseq = str.substring(i, j);
                if (str.indexOf(subseq, j) != -1 && subseq.length() > longest.length()) {
                    longest = subseq;
                }
            }
        }
        return longest;
    }

    // 9) Find all permutations of a string
    public static void findAllPermutations(String str) {
        permute(str, 0, str.length() - 1);
    }

    private static void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    // 10) Remove all white spaces from a string
    public static String removeWhiteSpaces(String str) {
        return str.replaceAll("\\s+", "");
    }

    // 11) Replace lower-case characters with upper-case and vice versa
    public static String swapCase(String str) {
        StringBuilder swapped = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                swapped.append(Character.toLowerCase(c));
            } else {
                swapped.append(Character.toUpperCase(c));
            }
        }
        return swapped.toString();
    }

    // 12) Replace the spaces of a string with a specific character
    public static String replaceSpacesWithChar(String str, char ch) {
        return str.replace(' ', ch);
    }

    // 13) Check if a string is palindrome
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // 14) Check if one string is a rotation of another
    public static boolean isRotation(String str1, String str2) {
        return (str1 + str1).contains(str2);
    }

    // 15) Find maximum and minimum occurring character in a string
    public static void findMaxMinOccurringCharacters(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        char maxChar = Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        char minChar = Collections.min(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Max occurring character: " + maxChar);
        System.out.println("Min occurring character: " + minChar);
    }

    // 16) Reverse a string
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 17) Find duplicate characters in a string
    public static void findDuplicateCharacters(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    // 18) Find duplicate words in a string
    public static void findDuplicateWords(String str) {
        String[] words = str.split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    // 19) Find the frequency of characters
    public static void findCharacterFrequency(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(freqMap);
    }

    // 20) Find the largest and smallest word in a string
    public static void findLargestAndSmallestWord(String str) {
        String[] words = str.split("\\s+");
        String smallest = words[0], largest = words[0];
        for (String word : words) {
            if (word.length() > largest.length()) {
                largest = word;
            }
            if (word.length() < smallest.length()) {
                smallest = word;
            }
        }
        System.out.println("Smallest word: " + smallest);
        System.out.println("Largest word: " + largest);
    }

    // 21) Find the most repeated word in a text file
    public static void findMostRepeatedWord(String str) {
        String[] words = str.split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        String mostRepeated = Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most repeated word: " + mostRepeated);
    }

    // 22) Find the number of words in the given text
    public static int countWords(String str) {
        return str.split("\\s+").length;
    }

    // 23) Separate the individual characters from a string
    public static void separateCharacters(String str) {
        for (char c : str.toCharArray()) {
            System.out.println(c);
        }
    }

    // 24) Swap two string variables without using third or temp variable
    public static void swapStrings(String str1, String str2) {
        str1 = str1 + str2;
        str2 = str1.substring(0, str1.length() - str2.length());
        str1 = str1.substring(str2.length());
        System.out.println("Swapped Strings: " + str1 + ", " + str2);
    }

    // 25) Print smallest and biggest possible palindrome word in a given string
    public static void findSmallestAndBiggestPalindromeWord(String str) {
        String[] words = str.split("\\s+");
        String smallestPalindrome = "", largestPalindrome = "";
        for (String word : words) {
            if (isPalindrome(word)) {
                if (smallestPalindrome.isEmpty() || word.length() < smallestPalindrome.length()) {
                    smallestPalindrome = word;
                }
                if (word.length() > largestPalindrome.length()) {
                    largestPalindrome = word;
                }
            }
        }
        System.out.println("Smallest Palindrome: " + smallestPalindrome);
        System.out.println("Largest Palindrome: " + largestPalindrome);
    }

    // 26) Reverse string word by word
    public static String reverseStringWordByWord(String str) {
        String[] words = str.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }

    // 27) Reverse a string without using the reverse() function
    public static String reverseStringWithoutReverseFunction(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        // Test cases to call each method
        System.out.println("Total Characters: " + countTotalCharacters("Hello World"));
        System.out.println("Total Characters Without Length: " + countTotalCharactersWithoutLength("Hello World"));
        System.out.println("Punctuation Characters: " + countPunctuationCharacters("Hello, World!"));
        countVowelsAndConsonants("Hello World");
        System.out.println("Are Anagrams: " + areAnagrams("listen", "silent"));
        divideStringIntoNParts("abcdefgh", 4);
        findAllSubsets("abc");
        System.out.println("Longest Repeating Sequence: " + findLongestRepeatingSequence("abcabc"));
        findAllPermutations("ABC");
        System.out.println("Without Spaces: " + removeWhiteSpaces("H e l l o"));
        System.out.println("Swap Case: " + swapCase("Hello World"));
        System.out.println("Replace Spaces with '_': " + replaceSpacesWithChar("Hello World", '_'));
        System.out.println("Is Palindrome: " + isPalindrome("madam"));
        System.out.println("Is Rotation: " + isRotation("abcd", "cdab"));
        findMaxMinOccurringCharacters("Hello World");
        System.out.println("Reversed String: " + reverseString("Hello World"));
        findDuplicateCharacters("programming");
        findDuplicateWords("this is a test and this test is easy");
        findCharacterFrequency("character");
        findLargestAndSmallestWord("Java is a robust language");
        findMostRepeatedWord("this is a test test is easy easy easy");
        System.out.println("Word Count: " + countWords("Java is awesome"));
        separateCharacters("Hello");
        swapStrings("hello", "world");
        findSmallestAndBiggestPalindromeWord("madam racecar level noon abcdefg");
        System.out.println("Reversed Word by Word: " + reverseStringWordByWord("Hello World"));
        System.out.println("Reversed Without Function: " + reverseStringWithoutReverseFunction("Hello World"));
    }
}

