package com.venkat.design.solid;

// Separate interfaces for distinct responsibilities (follows ISP)
interface Payable {
    void calculateSalary();  // For salary calculation
}

interface Workable {
    void submitTimesheet();  // For submitting timesheets
}

interface Manageable {
    void approveLeave();     // For leave approval (only for managers)
}

// Developer only implements relevant interfaces (follows ISP)
class Developer1 implements Payable, Workable {
    public void calculateSalary() {
        System.out.println("Developer salary calculated.");
    }

    public void submitTimesheet() {
        System.out.println("Developer timesheet submitted.");
    }
}

public class ISPAfter {
    public static void main(String[] args) {
        Developer1 dev = new Developer1();
        dev.calculateSalary();     // Developer calculates salary
        dev.submitTimesheet();     // Developer submits timesheet
        // No irrelevant approveLeave method
    }
}

