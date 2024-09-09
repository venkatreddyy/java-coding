package com.venkat.designpatterns.creational;

// Singleton Product Catalog
class ProductCatalogSingleton {
    private static ProductCatalogSingleton instance;

    private ProductCatalogSingleton() {
        // private constructor
    }

    public static ProductCatalogSingleton getInstance() {
        if (instance == null) {
            instance = new ProductCatalogSingleton();
        }
        return instance;
    }

    public void showProducts() {
        System.out.println("Showing product catalog (Singleton).");
    }
}

// Usage
public class SingletonPatternExample {
    public static void main(String[] args) {
        ProductCatalogSingleton catalog = ProductCatalogSingleton.getInstance();
        catalog.showProducts();
    }
}

