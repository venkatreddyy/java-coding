package com.venkat.challenges.top15;

import java.util.HashMap;
import java.util.Map;

// Custom Key Class without overriding equals() and hashCode()
class Employee22 {
    private int id;
    private String name;

    public Employee22(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}
/*
Explanation of the Issue:
We created an Employee object (emp1) and stored it as a key in the HashMap with the value "Developer".
We then created another Employee object (emp1Duplicate) with the same id and name as emp1.
When trying to retrieve the value using emp1Duplicate, we expect it to return "Developer" since both emp1 and emp1Duplicate have the same data.
However, the HashMap returns null because:

Default hashCode(): The default hashCode() method in the Object class returns a hash based on the memory address of the object. Since emp1 and emp1Duplicate are different objects, they have different memory addresses and thus different hash codes.

Default equals(): The default equals() method compares object references. Since emp1 and emp1Duplicate are two different objects, equals() returns false, even though their data (id and name) are the same.

Because of these default behaviors, the HashMap cannot find the correct key (emp1Duplicate), and it returns null instead of "Developer".

Correct Approach:
To resolve this issue, you need to override the equals() and hashCode() methods in the Employee class. This will ensure that two Employee objects with the same id and name are considered equal and have the same hash code, allowing the HashMap to function as expected.

Would you like me to provide the corrected version of this example with the equals() and hashCode() methods overridden?
 */
public class HashMapWithoutEqualsAndHashCode {
    public static void main(String[] args) {
        // Creating a HashMap with custom Employee object as the key
        Map<Employee22, String> employeeMap = new HashMap<>();

        // Adding entries with custom Employee key
        Employee22 emp1 = new Employee22(101, "John Doe");
        Employee22 emp2 = new Employee22(102, "Jane Doe");

        employeeMap.put(emp1, "Developer");
        employeeMap.put(emp2, "Manager");

        // Trying to access the value using a new Employee object with the same data as emp1
        Employee22 emp1Duplicate = new Employee22(101, "John Doe");

        // This will not work as expected, because equals() and hashCode() are not overridden
        System.out.println("Original Employee 1: " + employeeMap.get(emp1)); // Output: Developer
        System.out.println("Duplicate Employee 1: " + employeeMap.get(emp1Duplicate)); // Output: null
    }
}

