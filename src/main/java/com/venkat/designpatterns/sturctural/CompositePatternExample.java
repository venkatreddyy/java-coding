package com.venkat.designpatterns.sturctural;

import java.util.ArrayList;
import java.util.List;

// Component
interface ProductComponent {
    void showDetails();
}

// Leaf
class Product implements ProductComponent {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Product: " + name);
    }
}

// Composite
class ProductCategory implements ProductComponent {
    private String name;
    private List<ProductComponent> products = new ArrayList<>();

    public ProductCategory(String name) {
        this.name = name;
    }

    public void addProduct(ProductComponent product) {
        products.add(product);
    }

    @Override
    public void showDetails() {
        System.out.println("Category: " + name);
        for (ProductComponent product : products) {
            product.showDetails();
        }
    }
}

// Usage
public class CompositePatternExample {
    public static void main(String[] args) {
        ProductComponent phone = new Product("Phone");
        ProductComponent laptop = new Product("Laptop");

        ProductCategory electronics = new ProductCategory("Electronics");
        electronics.addProduct(phone);
        electronics.addProduct(laptop);

        electronics.showDetails();
    }
}

