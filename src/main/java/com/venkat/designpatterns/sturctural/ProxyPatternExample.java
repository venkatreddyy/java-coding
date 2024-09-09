package com.venkat.designpatterns.sturctural;

/*
The Proxy Pattern provides a surrogate or placeholder to control access to an object.
 In this example, the ShippingProxy class controls access to the RealShippingService.
 The proxy ensures that access control checks are performed before delegating the actual work to the real service.
 If the real service hasn't been instantiated yet, the proxy lazily creates it.
 This pattern adds a level of indirection, allowing control over how and when a real object is accessed,
 often used for lazy initialization, security, or logging.
 */
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

