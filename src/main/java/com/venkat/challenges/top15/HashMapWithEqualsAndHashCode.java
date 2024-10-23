package com.venkat.challenges.top15;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Custom Key Class with equals() and hashCode() overridden
class Employee23 {
    private int id;
    private String name;

    public Employee23(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override equals() to compare Employee objects based on 'id' and 'name'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Check if both references point to the same object
        if (o == null || getClass() != o.getClass()) return false; // Check if objects are of the same type
        Employee23 employee = (Employee23) o;
        return id == employee.id && Objects.equals(name, employee.name); // Compare id and name
    }

    // Override hashCode() to return consistent hash for equal objects
    @Override
    public int hashCode() {
        return Objects.hash(id, name); // Generate a hash based on id and name
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

public class HashMapWithEqualsAndHashCode {
    public static void main(String[] args) {
        // Creating a HashMap with custom Employee object as the key
        Map<Employee23, String> employeeMap = new HashMap<>();

        // Adding entries with custom Employee key
        Employee23 emp1 = new Employee23(101, "John Doe");
        Employee23 emp2 = new Employee23(102, "Jane Doe");

        employeeMap.put(emp1, "Developer");
        employeeMap.put(emp2, "Manager");

        // Creating another Employee object with the same data as emp1
        Employee23 emp1Duplicate = new Employee23(101, "John Doe");

        // This will now work correctly, because equals() and hashCode() are overridden
        System.out.println("Original Employee 1: " + employeeMap.get(emp1));          // Output: Developer
        System.out.println("Duplicate Employee 1: " + employeeMap.get(emp1Duplicate)); // Output: Developer
    }
}

