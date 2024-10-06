package com.venkat.design;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private int customerId;
    private Account account;  // Association: Customer has one Account
    private List<Loan> loans = new ArrayList<>();  // Aggregation: Customer can have multiple Loans

    public Customer(String name, String address, int customerId) {
        super(name, address);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void takeLoan(Loan loan) {
        loans.add(loan);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public String getPersonDetails() {
        return "Customer ID: " + customerId + ", Name: " + getName() + ", Address: " + getAddress();
    }
}

