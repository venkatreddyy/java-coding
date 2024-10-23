package com.venkat.challenges;

import java.util.*;
public class SuperExample {
    public static void main(String[] args) {
        // Create a list that can accept objects of Animal and its superclasses
        List<? super Animal> animalList = new ArrayList<>();

        // You can add instances of Animal, Dog, or Cat (since Dog and Cat are subclasses of Animal)
        animalList.add(new Animal());
        animalList.add(new Dog());
        animalList.add(new Cat());

        // But you cannot retrieve specific types from the list without casting
        // Object obj = animalList.get(0); // This is allowed since Object is a superclass of everything

        // Example of retrieving and processing elements using a cast:
        for (Object obj : animalList) {
            if (obj instanceof Animal) {
                Animal animal = (Animal) obj;
                animal.sound();  // Calls the appropriate sound() method based on runtime type
            }
        }
    }
}

