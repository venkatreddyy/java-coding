package com.venkat.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

// Iterator Interface
interface ProductIterator {
    boolean hasNext();
    ProductITR next();
}

// Collection Interface
interface ProductCollection {
    ProductIterator iterator();
}

// Concrete Iterator
class ProductListIterator implements ProductIterator {
    private List<ProductITR> products;
    private int position = 0;

    public ProductListIterator(List<ProductITR> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return position < products.size();
    }

    @Override
    public ProductITR next() {
        return products.get(position++);
    }
}

// Concrete Collection
class ProductList implements ProductCollection {
    private List<ProductITR> products = new ArrayList<>();

    public void addProduct(ProductITR product) {
        products.add(product);
    }

    @Override
    public ProductIterator iterator() {
        return new ProductListIterator(products);
    }
}

// Product Class
class ProductITR {
    private String name;

    public ProductITR(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Usage
public class IteratorPatternExample {
    public static void main(String[] args) {
        ProductList productList = new ProductList();
        productList.addProduct(new ProductITR("Phone"));
        productList.addProduct(new ProductITR("Laptop"));

        ProductIterator iterator = productList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

