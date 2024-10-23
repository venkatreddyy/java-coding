package com.venkat.challenges;

import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Implement the compareTo method to compare Student objects by age
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
/*
Comparable:
Defined inside the class itself.
Uses compareTo() method.
Provides a single natural ordering.
Modifies the class by implementing Comparable<T>.
Less flexible—supports only one way of sorting.
Used with Collections.sort(list) or Arrays.sort(array).
Suitable when there is a single natural way to order objects (e.g., by age).
Comparator:
Defined outside the class (can be in a separate class or a lambda expression).
Uses compare() method.
Can provide multiple custom orderings.
Does not modify the class itself.
More flexible—supports multiple sorting strategies.
Used with Collections.sort(list, comparator) or Arrays.sort(array, comparator).
Suitable when multiple sorting criteria are needed (e.g., by name, age, etc.).
These points summarize the key differences between Comparable and Comparator.
 */

public class ComparatorAndComparableExample {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 32));
        students.add(new Student("Bob", 25));
        students.add(new Student("Charlie", 40));
        students.add(new Student("David", 25));

        // 1. Using Comparable (Sort by Age using the compareTo method)
        Collections.sort(students);
        System.out.println("Sorted by age (Comparable): " + students);

        // 2. Using an Anonymous Class (Sort by Name)
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });
        System.out.println("Sorted by name (anonymous class): " + students);

        // 3. Using Lambda Expression (Sort by Age)
        students.sort((s1, s2) -> Integer.compare(s1.age, s2.age));
        System.out.println("Sorted by age (lambda expression): " + students);

        // 4. Using Method Reference (Sort by Age)
        students.sort(Comparator.comparingInt(Student::getAge));
        System.out.println("Sorted by age (method reference): " + students);

        // 5. Combining Comparators (Sort by Age, then by Name)
        students.sort(Comparator.comparingInt(Student::getAge)
                .thenComparing(Student::getName));
        System.out.println("Sorted by age, then by name (combined comparators): " + students);

        // 6. Using Reverse Order (Sort by Age in Descending Order)
        students.sort(Comparator.comparingInt(Student::getAge).reversed());
        System.out.println("Sorted by age in descending order (reversed order): " + students);
    }
}
