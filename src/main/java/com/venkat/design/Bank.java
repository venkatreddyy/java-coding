package com.venkat.design;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Branch> branches = new ArrayList<>();  // Composition: Bank contains Branches

    public Bank(String name) {
        this.name = name;
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public String getName() {
        return name;
    }
}

