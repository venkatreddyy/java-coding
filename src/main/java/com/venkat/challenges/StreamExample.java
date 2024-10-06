package com.venkat.challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Explanation of Concepts:
Filtering (filter): Filters the stream based on a predicate. In this case, it filters persons whose age is greater than 25.
Mapping (map): Transforms each element of the stream. Here, it converts each Person object into their name.
Sorting (sorted): Sorts the stream. This example sorts Person objects by their name.
Collecting (collect): Collects the stream into a collection, such as a list or a map. We use it here to group persons by their city and collect them into a List.
Limiting (limit): Limits the stream to a specific number of elements.
Parallel Stream (parallelStream): A parallel stream runs in parallel and can improve performance for large datasets. Here, it processes filtering in parallel.
Reducing (reduce): Combines elements of the stream into a single result. In this case, it sums the ages of all persons.
AnyMatch (anyMatch): Checks if any element of the stream matches a given predicate. Here, it checks if any person is from New York.
AllMatch (allMatch): Checks if all elements of the stream match a given predicate. It checks if all persons are adults in this case.
Output:
less
Copy code
Filtered Persons (Age > 25): [Person{name='Alice', age=30, city='New York'}, Person{name='David', age=35, city='Chicago'}, Person{name='Eve', age=28, city='New York'}]
Names of Persons: [Alice, Bob, Charlie, David, Eve]
Sorted by Name: [Person{name='Alice', age=30, city='New York'}, Person{name='Bob', age=20, city='San Francisco'}, Person{name='Charlie', age=25, city='Los Angeles'}, Person{name='David', age=35, city='Chicago'}, Person{name='Eve', age=28, city='New York'}]
Grouped by City: {New York=[Person{name='Alice', age=30, city='New York'}, Person{name='Eve', age=28, city='New York'}], San Francisco=[Person{name='Bob', age=20, city='San Francisco'}], Los Angeles=[Person{name='Charlie', age=25, city='Los Angeles'}], Chicago=[Person{name='David', age=35, city='Chicago'}]}
First 3 Persons: [Person{name='Alice', age=30, city='New York'}, Person{name='Bob', age=20, city='San Francisco'}, Person{name='Charlie', age=25, city='Los Angeles'}]
Filtered Persons (Age > 25, Parallel): [Person{name='Alice', age=30, city='New York'}, Person{name='David', age=35, city='Chicago'}, Person{name='Eve', age=28, city='New York'}]
Total Age of all Persons: 138
Is there anyone from New York?: true
Are all persons older than 18?: true
 */
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
                .sorted(Comparator.comparing(Person::getName))
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

