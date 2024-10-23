package com.venkat.challenges;

import java.util.*;

class Employee  {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class ComparatorExample {

    public static void main(String[] args) {
        List<Employee> employees= new ArrayList<>();
        employees.add(new Employee("Venkat",35));
        employees.add(new Employee("Alice", 32));
        employees.add(new Employee("Bob", 25));
        employees.add(new Employee("Charlie", 40));
        employees.add(new Employee("David", 25));

        // 1. Using an Anonymous Class (Sort by Age)
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e1.age, e2.age);
            }
        });

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.age,o2.age);
            }
        });
        System.out.println("Sorted by age (anonymous class): " + employees);


        // 2. Using Lambda Expression (Sort by Name)
        employees.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println("Sorted by name (lambda expression): " + employees);

        // 2. Using Lambda Expression (Sort by Name)
        employees.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println("Sorted by name (lambda expression): " + employees);

        // 3. Using Method Reference (Sort by Age)
        employees.sort(Comparator.comparingInt(Employee::getAge));
        System.out.println("Sorted by age (method reference): " + employees);

        // 4. Combining Comparators (Sort by Age, then by Name)
        employees.sort(Comparator.comparingInt(Employee::getAge)
                .thenComparing(Employee::getName));
        System.out.println("Sorted by age, then by name (combined comparators): " + employees);
        //Can be replaced with 'Comparator.comparing'
        employees.sort(Comparator.comparingInt(Employee::getAge).thenComparing((o1, o2) -> o1.name.compareTo(o2.name))
        );
        //Can be replaced with 'Comparator.comparing'
        employees.sort(Comparator.comparingInt(Employee::getAge).thenComparing(o -> o.name)
        );

        System.out.println("using lamdata Sorted by age, then by name (combined comparators): " + employees);

        // 5. Using Reverse Order (Sort by Age in Descending Order)
        employees.sort(Comparator.comparingInt(Employee::getAge).reversed());
        System.out.println("Sorted by age in descending order (reversed order): " + employees);
    }
}

