package com.venkat.designpatterns.creational;

// Order Class
class OrderBuilder {
    private String product;
    private double price;
    private String discount;
    private String shipping;
    private String invoice;

    // Builder class
    public static class Builder {
        private String product;
        private double price;
        private String discount;
        private String shipping;
        private String invoice;

        public Builder(String product, double price) {
            this.product = product;
            this.price = price;
        }

        public Builder discount(String discount) {
            this.discount = discount;
            return this;
        }

        public Builder shipping(String shipping) {
            this.shipping = shipping;
            return this;
        }

        public Builder invoice(String invoice) {
            this.invoice = invoice;
            return this;
        }

        public OrderBuilder build() {
            OrderBuilder order = new OrderBuilder();
            order.product = this.product;
            order.price = this.price;
            order.discount = this.discount;
            order.shipping = this.shipping;
            order.invoice = this.invoice;
            return order;
        }
    }

    @Override
    public String toString() {
        return "OrderBuilder: Product = " + product + ", Price = $" + price + ", Discount = " + discount +
                ", Shipping = " + shipping + ", Invoice = " + invoice;
    }
}

// Usage
public class BuilderPatternExample {
    public static void main(String[] args) {
        OrderBuilder order = new OrderBuilder.Builder("Laptop", 1000)
                .discount("10%")
                .shipping("Express")
                .invoice("Email")
                .build();

        System.out.println(order);
    }
}

