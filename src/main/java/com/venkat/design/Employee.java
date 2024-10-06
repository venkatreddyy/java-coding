package com.venkat.design;

public class Employee extends Person {
    private int employeeId;

    public Employee(String name, String address, int employeeId) {
        super(name, address);
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    // Polymorphism: Employee's version of getPersonDetails
    @Override
    public String getPersonDetails() {
        return "Employee ID: " + employeeId + ", Name: " + getName() + ", Address: " + getAddress();
    }

    // Association: Employee manages an account
    public void manageAccount(Account account) {
        System.out.println("Managing account: " + account.getAccountNumber());
    }
}

