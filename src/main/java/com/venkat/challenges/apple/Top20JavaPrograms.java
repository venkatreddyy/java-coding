package com.venkat.challenges.apple;

import java.util.*;

public class Top20JavaPrograms {

    public static void main(String[] args) {
        System.out.println("1. Reverse a String: " + reverseString("hello"));
        System.out.println("2. Palindrome Check: " + isPalindrome("madam"));
        System.out.println("3. Duplicate Characters: " + findDuplicateChars("programming"));
        System.out.println("4. First Non-Repeating Character: " + firstNonRepeatingChar("aabbcde"));
        System.out.println("5. Reverse Number: " + reverseNumber(1234));
        System.out.println("6. Is Prime (17): " + isPrime(17));
        System.out.print("7. Fibonacci (5): "); fibonacciSeries(5);
        System.out.println("\n8. Factorial (5): " + factorial(5));
        int a = 5, b = 10;
        int[] swapped = swapWithoutTemp(a, b);
        System.out.println("9. Swapped: a=" + swapped[0] + ", b=" + swapped[1]);
        System.out.println("10. Largest/Second Largest: " + Arrays.toString(largestTwo(new int[]{10, 5, 20, 8, 25})));
        System.out.println("11. Bubble Sort: " + Arrays.toString(bubbleSort(new int[]{5, 2, 8, 1, 3})));
        System.out.println("12. Missing Number: " + findMissingNumber(new int[]{1, 2, 4, 5}, 5));
        System.out.println("13. Are Anagrams: " + areAnagrams("listen", "silent"));
        System.out.println("14. Word Count: " + wordFrequency("Java is is fun fun fun"));
        System.out.println("15. Remove Duplicates: " + Arrays.toString(removeDuplicates(new int[]{1, 2, 2, 3, 4, 4})));
        System.out.println("16. Reverse Linked List: "); reverseLinkedListDemo();
        System.out.println("17. Detect Cycle in Linked List: " + detectCycleDemo());
        System.out.println("18. Singleton: " + Singleton.getInstance().hashCode());
        System.out.println("19. Immutable Class Example: " + new ImmutableUser("Alice", 30));
        System.out.println("20. Runnable Thread: "); new Thread(new MyTask()).start();
    }

    // 1. Reverse a String
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 2. Check Palindrome
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    // 3. Find Duplicate Characters
    public static Set<Character> findDuplicateChars(String s) {
        Set<Character> seen = new HashSet<>(), duplicates = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!seen.add(c)) duplicates.add(c);
        }
        return duplicates;
    }

    // 4. First Non-Repeating Character
    public static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : map.keySet()) if (map.get(c) == 1) return c;
        return '_';
    }

    // 5. Reverse a Number
    public static int reverseNumber(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    // 6. Prime Number
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    // 7. Fibonacci Series
    public static void fibonacciSeries(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }

    // 8. Factorial
    public static int factorial(int n) {
        return (n <= 1) ? 1 : n * factorial(n - 1);
    }

    // 9. Swap Without Temp
    public static int[] swapWithoutTemp(int a, int b) {
        a = a + b; b = a - b; a = a - b;
        return new int[]{a, b};
    }

    // 10. Largest & Second Largest
    public static int[] largestTwo(int[] arr) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) { second = max; max = num; }
            else if (num > second && num != max) second = num;
        }
        return new int[]{max, second};
    }

    // 11. Bubble Sort
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // 12. Find Missing Number
    public static int findMissingNumber(int[] arr, int n) {
        int sum = n * (n + 1) / 2;
        for (int num : arr) sum -= num;
        return sum;
    }

    // 13. Anagram Strings
    public static boolean areAnagrams(String a, String b) {
        char[] ac = a.toCharArray(), bc = b.toCharArray();
        Arrays.sort(ac); Arrays.sort(bc);
        return Arrays.equals(ac, bc);
    }

    // 14. Word Frequency
    public static Map<String, Integer> wordFrequency(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : str.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    // 15. Remove Duplicates
    public static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    // 16. Reverse Linked List
    static class Node {
        int val; Node next;
        Node(int val) { this.val = val; }
    }
    public static void reverseLinkedListDemo() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        while (prev != null) {
            System.out.print(prev.val + " ");
            prev = prev.next;
        }
        System.out.println();
    }

    // 17. Detect Cycle in Linked List
    public static boolean detectCycleDemo() {
        Node a = new Node(1), b = new Node(2), c = new Node(3);
        a.next = b; b.next = c; c.next = a; // cycle
        Node slow = a, fast = a;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // 18. Singleton Class
    static class Singleton {
        private static Singleton instance = null;
        private Singleton() {}
        public static Singleton getInstance() {
            if (instance == null) instance = new Singleton();
            return instance;
        }
    }

    // 19. Immutable Class
    static final class ImmutableUser {
        private final String name;
        private final int age;
        public ImmutableUser(String name, int age) {
            this.name = name; this.age = age;
        }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String toString() { return name + " (" + age + ")"; }
    }

    // 20. Runnable Thread
    static class MyTask implements Runnable {
        public void run() {
            System.out.println("Running in thread: " + Thread.currentThread().getName());
        }
    }
}

