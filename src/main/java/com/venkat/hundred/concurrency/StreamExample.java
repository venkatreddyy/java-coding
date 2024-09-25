package com.venkat.hundred.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
 class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}


public class StreamExample {
    public static void main(String[] args) {
        // Creating a list of Person objects
        List<Person> persons = Arrays.asList(
                new Person("Alice", 30, "New York"),
                new Person("Bob", 20, "San Francisco"),
                new Person("Charlie", 25, "Los Angeles"),
                new Person("David", 35, "Chicago"),
                new Person("Eve", 28, "New York")
        );

        // 1. Filtering: Get all persons older than 25
        List<Person> filteredPersons = persons.stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList());
        System.out.println("Filtered Persons (Age > 25): " + filteredPersons);

        // 2. Mapping: Get a list of all the names
        List<String> names = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("Names of Persons: " + names);

        // 3. Sorting: Sort persons by name
        List<Person> sortedByName = persons.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());
        System.out.println("Sorted by Name: " + sortedByName);

        // 4. Collecting to a map: Group persons by city
        Map<String, List<Person>> personsByCity = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        System.out.println("Grouped by City: " + personsByCity);

        // 5. Limit: Get only the first 3 persons
        List<Person> firstThree = persons.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First 3 Persons: " + firstThree);

        // 6. Parallel Stream: Perform filtering in parallel
        List<Person> filteredParallel = persons.parallelStream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList());
        System.out.println("Filtered Persons (Age > 25, Parallel): " + filteredParallel);

        // 7. Reducing: Get the sum of all ages
        int totalAge = persons.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);
        System.out.println("Total Age of all Persons: " + totalAge);

        // 8. AnyMatch: Check if any person is from New York
        boolean anyFromNY = persons.stream()
                .anyMatch(p -> "New York".equals(p.getCity()));
        System.out.println("Is there anyone from New York?: " + anyFromNY);

        // 9. AllMatch: Check if all persons are older than 18
        boolean allAdults = persons.stream()
                .allMatch(p -> p.getAge() > 18);
        System.out.println("Are all persons older than 18?: " + allAdults);
    }
}

