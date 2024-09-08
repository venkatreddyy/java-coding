package com.venkat.programs;

import java.util.*;
/*
copyArray: Copies an array using Arrays.copyOf().
findFrequency: Uses a HashMap to track the frequency of each element.
leftRotate and rightRotate: Rotate elements using array manipulation.
printArray and printReverse: Print arrays and their reverse.
printEvenPosition and printOddPosition: Print elements at even or odd positions.
findLargestElement and findSmallestElement: Use Arrays.stream() to find the largest and smallest elements.
sumOfElements: Sum all elements using Arrays.stream().sum().
sortArray: Sort arrays in ascending or descending order using Arrays.sort().
 */
public class StringOperationsLatest {

    // 1) Count total number of characters in a string
    public static int countTotalCharacters(String str) {
        return str.length();
    }

    // 2) Count total number of characters in a string 2 (alternative)
    public static int countTotalCharactersWithoutLength(String str) {
        var count = 0;
        for (var c : str.toCharArray()) {
            count++;
        }
        return count;
    }

    // 3) Count total number of punctuation characters in a string
    public static long countPunctuationCharacters(String str) {
        return str.chars().filter(c -> !Character.isLetterOrDigit(c) && !Character.isWhitespace(c)).count();
    }

    // 4) Count total number of vowels and consonants in a string
    public static void countVowelsAndConsonants(String str) {
        var vowels = 0;
        var consonants = 0;
        var vowelsList = "aeiouAEIOU";

        for (var c : str.toCharArray()) {
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
        return str1.length() == str2.length() &&
                str1.chars().sorted().toArray().equals(str2.chars().sorted().toArray());
    }

    // 6) Divide a string into 'N' equal parts
    public static void divideStringIntoNParts(String str, int n) {
        var partSize = str.length() / n;
        for (var i = 0; i < str.length(); i += partSize) {
            System.out.println(str.substring(i, i + partSize));
        }
    }

    // 7) Find all subsets of a string
    public static void findAllSubsets(String str) {
        for (var i = 0; i < str.length(); i++) {
            for (var j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

    // 8) Find the longest repeating sequence in a string
    public static String findLongestRepeatingSequence(String str) {
        var longest = "";
        for (var i = 0; i < str.length(); i++) {
            for (var j = i + 1; j < str.length(); j++) {
                var subseq = str.substring(i, j);
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
            for (var i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        var charArray = a.toCharArray();
        var temp = charArray[i];
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
        return str.chars()
                .mapToObj(c -> Character.isUpperCase(c) ? Character.toLowerCase((char) c) : Character.toUpperCase((char) c))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    // 12) Replace the spaces of a string with a specific character
    public static String replaceSpacesWithChar(String str, char ch) {
        return str.replace(' ', ch);
    }

    // 13) Check if a string is palindrome
    public static boolean isPalindrome(String str) {
        var reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // 14) Check if one string is a rotation of another
    public static boolean isRotation(String str1, String str2) {
        return (str1.length() == str2.length()) && (str1 + str1).contains(str2);
    }

    // 15) Find maximum and minimum occurring character in a string
    public static void findMaxMinOccurringCharacters(String str) {
        var freqMap = new HashMap<Character, Integer>();
        str.chars().forEach(c -> freqMap.put((char) c, freqMap.getOrDefault((char) c, 0) + 1));

        var maxChar = Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        var minChar = Collections.min(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("Max occurring character: " + maxChar);
        System.out.println("Min occurring character: " + minChar);
    }

    // 16) Reverse a string
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 17) Find duplicate characters in a string
    public static void findDuplicateCharacters(String str) {
        var freqMap = new HashMap<Character, Integer>();
        str.chars().forEach(c -> freqMap.put((char) c, freqMap.getOrDefault((char) c, 0) + 1));

        freqMap.entrySet().stream().filter(e -> e.getValue() > 1).forEach(e -> System.out.println(e.getKey()));
    }

    // 18) Find duplicate words in a string
    public static void findDuplicateWords(String str) {
        var words = str.split("\\s+");
        var freqMap = new HashMap<String, Integer>();
        Arrays.stream(words).forEach(word -> freqMap.put(word, freqMap.getOrDefault(word, 0) + 1));

        freqMap.entrySet().stream().filter(e -> e.getValue() > 1).forEach(e -> System.out.println(e.getKey()));
    }

    // 19) Find the frequency of characters
    public static void findCharacterFrequency(String str) {
        var freqMap = new HashMap<Character, Integer>();
        str.chars().forEach(c -> freqMap.put((char) c, freqMap.getOrDefault((char) c, 0) + 1));

        System.out.println(freqMap);
    }

    // 20) Find the largest and smallest word in a string
    public static void findLargestAndSmallestWord(String str) {
        var words = str.split("\\s+");
        var smallest = Arrays.stream(words).min(Comparator.comparingInt(String::length)).orElse("");
        var largest = Arrays.stream(words).max(Comparator.comparingInt(String::length)).orElse("");

        System.out.println("Smallest word: " + smallest);
        System.out.println("Largest word: " + largest);
    }

    // 21) Find the most repeated word in a text file
    public static void findMostRepeatedWord(String str) {
        var words = str.split("\\s+");
        var freqMap = new HashMap<String, Integer>();
        Arrays.stream(words).forEach(word -> freqMap.put(word, freqMap.getOrDefault(word, 0) + 1));

        var mostRepeated = Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most repeated word: " + mostRepeated);
    }

    // 22) Find the number of words in the given text
    public static long countWords(String str) {
        return str.split("\\s+").length;
    }

    // 23) Separate the individual characters from a string
    public static void separateCharacters(String str) {
        str.chars().forEach(c -> System.out.println((char) c));
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
        var words = str.split("\\s+");
        var smallestPalindrome = Arrays.stream(words).filter(StringOperationsLatest::isPalindrome)
                .min(Comparator.comparingInt(String::length)).orElse("");
        var largestPalindrome = Arrays.stream(words).filter(StringOperationsLatest::isPalindrome)
                .max(Comparator.comparingInt(String::length)).orElse("");

        System.out.println("Smallest Palindrome: " + smallestPalindrome);
        System.out.println("Largest Palindrome: " + largestPalindrome);
    }

    // 26) Reverse string word by word
    public static String reverseStringWordByWord(String str) {
        var words = str.split("\\s+");
        var reversed = String.join(" ", List.of(words).stream().sorted(Comparator.reverseOrder()).toArray(String[]::new));

        return reversed;
    }

    // 27) Reverse a string without using the reverse() function
    public static String reverseStringWithoutReverseFunction(String str) {
        var chars = str.toCharArray();
        var left = 0;
        var right = chars.length - 1;

        while (left < right) {
            var temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        // Test cases for all methods using latest Java features
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
