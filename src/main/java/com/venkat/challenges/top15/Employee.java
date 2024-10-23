package com.venkat.challenges.top15;

// Employee class implementing Cloneable interface
class Employee implements Cloneable {
    String name; // Employee's name
    Address address; // Employee's address (nested object of Address class)

    // Constructor to initialize Employee object with name and address
    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy using default clone method provided by Object class
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Calls the default clone() method which performs a shallow copy
        return super.clone();
    }

    // Deep copy method by explicitly cloning the nested Address object
    protected Employee deepClone() throws CloneNotSupportedException {
        // First, perform a shallow copy of the Employee object
        Employee cloned = (Employee) super.clone();
        // Then, deep copy the Address object by invoking its clone method
        cloned.address = (Address) address.clone();
        return cloned; // Return the deep cloned Employee object
    }

    // Main method to demonstrate shallow and deep copying
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create an Address object
        Address address = new Address("New York");

        // Create an Employee object with name and address
        Employee emp1 = new Employee("John", address);

        // Perform a shallow copy of emp1 using the clone method
        Employee emp2 = (Employee) emp1.clone(); // Shallow copy

        // Perform a deep copy of emp1 using the deepClone method
        Employee emp3 = emp1.deepClone(); // Deep copy

        // Modify the address of the shallow copied object
        emp2.address.city = "Los Angeles"; // This affects emp1 as well (shallow copy)

        // Output the address city of emp1, which is changed due to shallow copy
        System.out.println("Emp1 City: " + emp1.address.city); // Output: Los Angeles (shallow copy)

        // Output the address city of emp3, which remains unchanged due to deep copy
        System.out.println("Emp3 City: " + emp3.address.city); // Output: New York (deep copy)
    }
}

// Address class implementing Cloneable interface
class Address implements Cloneable {
    String city; // Address city

    // Constructor to initialize the Address object
    public Address(String city) {
        this.city = city;
    }

    // Clone method to create a shallow copy of the Address object
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Calls the default clone method from Object class
        return super.clone();
    }
}


