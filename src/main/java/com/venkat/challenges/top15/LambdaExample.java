package com.venkat.challenges.top15;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Max");

        // Lambda expression to iterate over the list
        names.forEach(name -> System.out.println(name));

        System.out.println("using method reference");
        names.forEach(System.out::println);

        // Output:
        // John
        // Jane
        // Max
    }
}

