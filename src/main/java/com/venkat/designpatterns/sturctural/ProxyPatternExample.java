package com.venkat.designpatterns.sturctural;

// Service Interface
interface ShippingService {
    void shipOrder();
}

// Real Service
class RealShippingService implements ShippingService {
    @Override
    public void shipOrder() {
        System.out.println("Order shipped using real shipping service.");
    }
}

// Proxy
class ShippingProxy implements ShippingService {
    private RealShippingService realShippingService;

    @Override
    public void shipOrder() {
        if (realShippingService == null) {
            realShippingService = new RealShippingService();
        }
        System.out.println("Performing access control checks...");
        realShippingService.shipOrder();
    }
}

// Usage
public class ProxyPatternExample {
    public static void main(String[] args) {
        ShippingService shippingService = new ShippingProxy();
        shippingService.shipOrder();
    }
}

