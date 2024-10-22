package com.venkat.challenges.top15;

class Employee implements Cloneable {
    String name;
    Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy using default clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep copy by cloning nested objects
    protected Employee deepClone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.address = (Address) address.clone();
        return cloned;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Employee emp1 = new Employee("John", address);
        Employee emp2 = (Employee) emp1.clone(); // Shallow copy
        Employee emp3 = emp1.deepClone(); // Deep copy

        emp2.address.city = "Los Angeles"; // Modifies the shared object

        System.out.println("Emp1 City: " + emp1.address.city); // Output: Los Angeles (shallow copy)
        System.out.println("Emp3 City: " + emp3.address.city); // Output: New York (deep copy)
    }
}

class Address implements Cloneable {
    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

