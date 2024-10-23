package com.venkat.challenges.top15;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Custom Key Class with equals() and hashCode() overridden
class Employee23 {
    private int id;    // Private field to store the employee's ID
    private String name; // Private field to store the employee's name

    // Constructor to initialize the Employee23 object with id and name
    public Employee23(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override equals() method to compare two Employee23 objects based on 'id' and 'name'
    @Override
    public boolean equals(Object o) {
        // If the current object and the object being compared are the same instance, return true
        if (this == o) return true;

        // If the object being compared is null or not of the same class, return false
        if (o == null || getClass() != o.getClass()) return false;

        // Typecast the object to Employee23 to compare specific fields
        Employee23 employee = (Employee23) o;

        // Compare both id and name fields for equality
        return id == employee.id && Objects.equals(name, employee.name);
    }

    // Override hashCode() method to return a consistent hash code for equal Employee23 objects
    @Override
    public int hashCode() {
        // Generate a hash based on id and name using Objects.hash() for consistency
        return Objects.hash(id, name);
    }

    // Override toString() method to represent Employee23 object as a readable string
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}"; // Return a string representation of the Employee23 object
    }
}

public class HashMapWithEqualsAndHashCode {
    public static void main(String[] args) {
        // Creating a HashMap with Employee23 objects as keys and Strings (job titles) as values
        Map<Employee23, String> employeeMap = new HashMap<>();

        // Creating Employee23 objects and adding them as keys with job titles as values
        Employee23 emp1 = new Employee23(101, "John Doe"); // Employee with id=101 and name="John Doe"
        Employee23 emp2 = new Employee23(102, "Jane Doe"); // Employee with id=102 and name="Jane Doe"

        // Putting the Employee23 objects as keys in the map, with job titles as values
        employeeMap.put(emp1, "Developer");  // emp1 mapped to "Developer"
        employeeMap.put(emp2, "Manager");    // emp2 mapped to "Manager"

        // Creating another Employee23 object with the same id and name as emp1
        // This object has the same data but is a different instance
        Employee23 emp1Duplicate = new Employee23(101, "John Doe");

        // Demonstrating how the overridden equals() and hashCode() allow this duplicate to be treated as the same key
        System.out.println("Original Employee 1: " + employeeMap.get(emp1));          // Output: Developer
        System.out.println("Duplicate Employee 1: " + employeeMap.get(emp1Duplicate)); // Output: Developer

        // Both emp1 and emp1Duplicate have the same hash code and are equal based on their content (id and name),
        // so the HashMap correctly retrieves the value ("Developer") for emp1Duplicate.
    }
}


