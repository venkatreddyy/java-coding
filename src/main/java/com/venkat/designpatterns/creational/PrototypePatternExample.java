package com.venkat.designpatterns.creational;

// Product Prototype Interface
interface ProductPrototype extends Cloneable {
    ProductPrototype clone();
}

// Concrete Product Implementation
class LaptopPrototype implements ProductPrototype {
    private String configuration;

    public LaptopPrototype(String configuration) {
        this.configuration = configuration;
    }

    @Override
    public ProductPrototype clone() {
        return new LaptopPrototype(this.configuration);
    }

    @Override
    public String toString() {
        return "LaptopPrototype Configuration: " + configuration;
    }
}

// Usage
public class PrototypePatternExample {
    public static void main(String[] args) {
        LaptopPrototype originalLaptop = new LaptopPrototype("16GB RAM, 512GB SSD");
        LaptopPrototype clonedLaptop = (LaptopPrototype) originalLaptop.clone();

        System.out.println(originalLaptop);
        System.out.println(clonedLaptop);
    }
}

