package com.venkat.design.solid;

// Employee interface with irrelevant methods for certain roles (violates ISP)
interface Employee {
    void calculateSalary();   // Required for all employees
    void submitTimesheet();   // Required for all employees
    void approveLeave();      // Irrelevant for non-managers (violates ISP)
}

// Developer class forced to implement approveLeave (violates ISP)
class Developer implements Employee {
    public void calculateSalary() {
        System.out.println("Developer salary calculated.");
    }

    public void submitTimesheet() {
        System.out.println("Developer timesheet submitted.");
    }

    public void approveLeave() {
        // Not relevant for Developer (violates ISP)
        throw new UnsupportedOperationException("Developers don't approve leave");
    }
}

public class ISPBefore {
    public static void main(String[] args) {
        Developer dev = new Developer();
        dev.calculateSalary();
        dev.submitTimesheet();
        dev.approveLeave();  // Throws exception, violates ISP
    }
}

