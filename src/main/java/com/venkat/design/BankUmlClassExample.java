package com.venkat.design;


/*
Explanation:
Encapsulation:
All the class attributes (name, address, accountNumber, etc.) are marked private and accessed through public getters and setters.
Abstraction:

The Person class is abstract, and its method getPersonDetails() is implemented by the Customer and Employee classes.
Inheritance:

Both Customer and Employee inherit from Person, so they share the common properties and behaviors defined in Person.
Polymorphism:

The getPersonDetails() method is overridden in both Customer and Employee classes. We see runtime polymorphism when calling getPersonDetails() on an object of Person but assigned to an instance of Employee.
Association:

A Customer has an Account and can take Loans. An Employee can manage Accounts.
Aggregation:

A Customer can have multiple Loans, but these loans can exist independently of the customer (if the customer is removed, loans might still exist).
Composition:

A Bank contains Branches, a Branch contains Accounts and Employees. If the Bank is dissolved, the branches will cease to exist, representing composition.
Sample Output:
yaml
Copy code
Managing account: 123456789
Bank: Global Bank
Branch: Main Branch
Customer: Alice
Account Balance: 1000.0
Loan Details: Loan ID: 3001, Amount: 5000.0
Employee ID: 2001, Name: John, Address: 123 Main St
 */
public class BankUmlClassExample {
    public static void main(String[] args) {
        // Create Bank
        Bank bank = new Bank("Global Bank");

        // Create Branch
        Branch mainBranch = new Branch(101, "Main Branch");
        bank.addBranch(mainBranch);

        // Create Employees
        Employee employee1 = new Employee("John", "123 Main St", 2001);
        mainBranch.addEmployee(employee1);

        // Create Customer
        Customer customer1 = new Customer("Alice", "456 Pine St", 1001);

        // Create Account for Customer
        Account account1 = new Account("123456789", 1000.0);
        customer1.setAccount(account1);
        mainBranch.addAccount(account1);

        // Employee manages the customer's account
        employee1.manageAccount(account1);

        // Customer takes a loan
        Loan loan1 = new Loan(3001, 5000.0);
        customer1.takeLoan(loan1);

        // Output some information
        System.out.println("Bank: " + bank.getName());
        System.out.println("Branch: " + mainBranch.getBranchName());
        System.out.println("Customer: " + customer1.getName());
        System.out.println("Account Balance: " + customer1.getAccount().getBalance());
        System.out.println("Loan Details: " + customer1.getLoans().get(0).getLoanDetails());

        // Polymorphism: Using Person reference to refer to Employee object
        Person person = employee1;
        System.out.println(person.getPersonDetails());
    }
}
