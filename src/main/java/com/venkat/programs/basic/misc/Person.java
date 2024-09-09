package com.venkat.programs.basic.misc;

import java.util.HashSet;

/*
In Java, overriding the equals and hashCode methods is crucial when you're creating custom objects that need to be compared or stored in collections that rely on equality, such as HashMap, HashSet, and HashTable. Here's why:

1. equals Method:
The equals method is used to determine whether two objects are "equal." By default, the equals method in the Object class (which is the superclass of all classes in Java) compares the memory addresses of the objects, which means two objects are considered equal only if they refer to the exact same instance in memory.

If you want to compare two objects based on their content (e.g., comparing two Person objects based on their name and age fields), you need to override the equals method to provide a meaningful equality check.

Example:
java
Copy code
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Person person = (Person) obj;
    return age == person.age && Objects.equals(name, person.name);
}
2. hashCode Method:
The hashCode method returns an integer representation of the object, which is used in hashing-based collections like HashMap, HashSet, and HashTable. When you override equals, you must also override hashCode to ensure that two objects that are considered equal (using equals) also have the same hash code.

This is important because:

Hash-based collections (like HashMap) use the hash code to determine where to store the object in a hash table.
If two objects are equal according to the equals method, they must have the same hash code so they can be placed in the same bucket in the hash table.
Failing to override hashCode while overriding equals can cause objects that are "equal" to be stored in different locations in the hash-based collections, leading to unexpected behavior.
Example:
java
Copy code
@Override
public int hashCode() {
    return Objects.hash(name, age);
}
The Contract Between equals and hashCode:
The Java documentation specifies the contract between equals and hashCode:

Consistent: Multiple invocations of hashCode must consistently return the same integer, provided no information used in equals comparisons on the object is modified.

Equality: If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.

Inequality: It is not required that if two objects are unequal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.

Conclusion:
Overriding equals and hashCode is essential when you need to:

Compare objects based on their content rather than their reference.
Use objects in hash-based collections like HashMap, HashSet, or HashTable.

 */
/*
Equality Check:
The equals method is not overridden,
so the default implementation from the Object class is used, which compares the memory addresses of person1 and person2.
Since person1 and person2 are different objects (even though their contents are the same), person1.equals(person2)
returns false.

HashSet Behavior:
HashSet uses both hashCode and equals to determine if an object is a duplicate.
Since neither equals nor hashCode is overridden, person1 and person2 are treated as different objects,
resulting in both being stored in the HashSet. The size() method returns 2.


 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters (omitted for brevity)

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);

        // Comparing using equals (from Object class)
        System.out.println(person1.equals(person2));  // Output: false

        // Using HashSet to store persons
        HashSet<Person> people = new HashSet<>();
        people.add(person1);
        people.add(person2);

        System.out.println(people.size());  // Output: 2
    }
}

