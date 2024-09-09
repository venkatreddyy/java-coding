package com.venkat.designpatterns.sturctural;

import java.util.HashMap;
import java.util.Map;

// Flyweight
class ProductFlyweight {
    private String name;

    public ProductFlyweight(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Flyweight Factory
class ProductFactory {
    private static Map<String, ProductFlyweight> products = new HashMap<>();

    public static ProductFlyweight getProduct(String name) {
        if (!products.containsKey(name)) {
            products.put(name, new ProductFlyweight(name));
        }
        return products.get(name);
    }
}

// Usage
public class FlyweightPatternExample {
    public static void main(String[] args) {
        ProductFlyweight phone = ProductFactory.getProduct("Phone");
        ProductFlyweight laptop = ProductFactory.getProduct("Laptop");
        ProductFlyweight anotherPhone = ProductFactory.getProduct("Phone");

        System.out.println("Product: " + phone.getName());
        System.out.println("Product: " + laptop.getName());
        System.out.println("Product: " + anotherPhone.getName());

        System.out.println("Phone objects are the same instance: " + (phone == anotherPhone));
    }
}

