package com.venkat.design;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private int branchId;
    private String branchName;
    private List<Account> accounts = new ArrayList<>();  // Composition: Branch contains Accounts
    private List<Employee> employees = new ArrayList<>();  // Composition: Branch contains Employees

    public Branch(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String getBranchName() {
        return branchName;
    }
}

