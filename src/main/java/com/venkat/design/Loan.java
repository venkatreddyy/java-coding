package com.venkat.design;

public class Loan {
    private int loanId;
    private double amount;

    public Loan(int loanId, double amount) {
        this.loanId = loanId;
        this.amount = amount;
    }

    public String getLoanDetails() {
        return "Loan ID: " + loanId + ", Amount: " + amount;
    }
}

