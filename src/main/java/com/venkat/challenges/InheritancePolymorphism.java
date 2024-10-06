package com.venkat.challenges;

class Animal {
    void sound() {
        System.out.println("Animal is making a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog is barking");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat is meowing");
    }
}

public class InheritancePolymorphism {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.sound();  // Output: Dog is barking
        myCat.sound();  // Output: Cat is meowing
    }
}
