package com.venkat.features;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
/*
Explanation of Key Operations:
Filter: Filters elements based on a condition. Here, it filters even numbers.
Map: Transforms elements. For example, squaring numbers.
Reduce: Reduces the stream to a single value, e.g., sum of numbers.
Collect: Gathers the result into a collection like List, Set, or Map.
FlatMap: Used to flatten nested structures, like converting a 2D list into a flat list.
GroupingBy: Groups elements based on a classifier, such as grouping strings by their length.
PartitioningBy: Splits elements into two groups (like even vs. odd numbers).

Filter Even Numbers: [2, 4, 6, 8, 10]
Square of Numbers: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
Sum of Numbers: 55
Even Numbers Collected: [2, 4, 6, 8, 10]
Unique Strings Collected: [banana, date, apple, cherry]
String Length Map: {date=4, banana=6, cherry=6, apple=5}
FlatMap Example: [1, 2, 3, 4, 5, 6, 7, 8, 9]
Grouped by Length: {4=[date], 5=[apple, apple], 6=[banana, cherry]}
Partitioned by Even: {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}

 */
public class StreamOperations {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "apple", "date");

        // Filtering
        System.out.println("Filter Even Numbers: " + filterEvenNumbers(numbers));

        // Mapping
        System.out.println("Square of Numbers: " + mapSquareNumbers(numbers));

        // Reducing
        System.out.println("Sum of Numbers: " + reduceSum(numbers));

        // Collecting to a List
        System.out.println("Even Numbers Collected: " + collectEvenNumbers(numbers));

        // Collecting to a Set
        System.out.println("Unique Strings Collected: " + collectUniqueStrings(strings));

        // Collecting to a Map
        System.out.println("String Length Map: " + collectToMap(strings));

        // FlatMap
        System.out.println("FlatMap Example: " + flatMapExample());

        // GroupingBy
        System.out.println("Grouped by Length: " + groupByStringLength(strings));

        // PartitioningBy
        System.out.println("Partitioned by Even: " + partitionByEvenOdd(numbers));
    }

    // Filter - Even numbers
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }

    // Map - Square of numbers
    public static List<Integer> mapSquareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
    }

    // Reduce - Sum of numbers
    public static Integer reduceSum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    // Collect - Even numbers into List
    public static List<Integer> collectEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }

    // Collect - Unique strings into Set
    public static Set<String> collectUniqueStrings(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toSet());
    }

    // Collect - Map with string as key and length as value
    public static Map<String, Integer> collectToMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (oldValue, newValue) -> oldValue));
    }

    // FlatMap - Example of a 2D list to 1D list
    public static List<Integer> flatMapExample() {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        return listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    // GroupingBy - Grouping strings by length
    public static Map<Integer, List<String>> groupByStringLength(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    // PartitioningBy - Partition numbers into even and odd
    public static Map<Boolean, List<Integer>> partitionByEvenOdd(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
    }
}

