package com.venkat.designpatterns.behavioral;

// Element Interface
interface OrderElement {
    void accept(OrderVisitor visitor);
}

// Concrete Element: Product
class ProductElement implements OrderElement {
    private String name;
    private double price;

    public ProductElement(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Element: Service
class ServiceElement implements OrderElement {
    private String name;
    private double charge;

    public ServiceElement(String name, double charge) {
        this.name = name;
        this.charge = charge;
    }

    public String getName() {
        return name;
    }

    public double getCharge() {
        return charge;
    }

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this);
    }
}

// Visitor Interface
interface OrderVisitor {
    void visit(ProductElement product);
    void visit(ServiceElement service);
}

// Concrete Visitor: Tax Calculator
class TaxVisitor implements OrderVisitor {
    @Override
    public void visit(ProductElement product) {
        System.out.println("Calculating tax for product: " + product.getName() + ". Tax: $" + (product.getPrice() * 0.1));
    }

    @Override
    public void visit(ServiceElement service) {
        System.out.println("Calculating tax for service: " + service.getName() + ". Tax: $" + (service.getCharge() * 0.15));
    }
}

// Usage
public class VisitorPatternExample {
    public static void main(String[] args) {
        OrderElement product = new ProductElement("Laptop", 1000);
        OrderElement service = new ServiceElement("Warranty", 150);

        OrderVisitor taxVisitor = new TaxVisitor();

        product.accept(taxVisitor); // Tax for product
        service.accept(taxVisitor); // Tax for service
    }
}

