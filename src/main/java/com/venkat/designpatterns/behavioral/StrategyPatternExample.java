package com.venkat.designpatterns.behavioral;

// Strategy Interface
interface Strategy {
    void execute();
}

// Concrete Strategy A
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy A");
    }
}

// Concrete Strategy B
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy B");
    }
}

// Context Class
class ContextStrategy {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}

// Usage
public class StrategyPatternExample {
    public static void main(String[] args) {
        ContextStrategy context = new ContextStrategy();

        context.setStrategy(new ConcreteStrategyA());
        context.executeStrategy();  // Executes strategy A

        context.setStrategy(new ConcreteStrategyB());
        context.executeStrategy();  // Executes strategy B
    }
}

