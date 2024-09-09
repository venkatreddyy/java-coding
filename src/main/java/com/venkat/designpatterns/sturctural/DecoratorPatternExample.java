package com.venkat.designpatterns.sturctural;

// Component Interface
interface OrderComponent {
    double getCost();
    String getDescription();
}

// Concrete Component
class BasicOrder implements OrderComponent {
    @Override
    public double getCost() {
        return 50.0; // base price
    }

    @Override
    public String getDescription() {
        return "Basic Order";
    }
}

// Decorator
abstract class OrderDecorator implements OrderComponent {
    protected OrderComponent order;

    public OrderDecorator(OrderComponent order) {
        this.order = order;
    }

    @Override
    public double getCost() {
        return order.getCost();
    }

    @Override
    public String getDescription() {
        return order.getDescription();
    }
}

// Concrete Decorators
class DiscountDecorator extends OrderDecorator {
    public DiscountDecorator(OrderComponent order) {
        super(order);
    }

    @Override
    public double getCost() {
        return order.getCost() * 0.9; // 10% discount
    }

    @Override
    public String getDescription() {
        return order.getDescription() + " with Discount";
    }
}

// Usage
public class DecoratorPatternExample {
    public static void main(String[] args) {
        OrderComponent basicOrder = new BasicOrder();
        OrderComponent discountedOrder = new DiscountDecorator(basicOrder);

        System.out.println(discountedOrder.getDescription() + " costs $" + discountedOrder.getCost());
    }
}

