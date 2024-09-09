package com.venkat.programs.basic.misc;

import java.util.HashSet;
import java.util.Objects;

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters (omitted for brevity)

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Alice", 30);
        Employee employee2 = new Employee("Alice", 30);

        // Comparing using overridden equals
        System.out.println(employee1.equals(employee2));  // Output: true

        // Using HashSet to store employees
        HashSet<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);

        System.out.println(employees.size());  // Output: 1
    }
}
