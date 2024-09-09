package com.venkat.designpatterns.behavioral;

// Expression Interface
interface DiscountExpression {
    boolean interpret(String context);
}

// Concrete Expressions
class ContainsDiscountKeyword implements DiscountExpression {
    private String keyword;

    public ContainsDiscountKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(keyword);
    }
}

// Interpreter Class
class DiscountRuleInterpreter {
    private DiscountExpression expression;

    public DiscountRuleInterpreter(DiscountExpression expression) {
        this.expression = expression;
    }

    public boolean evaluate(String context) {
        return expression.interpret(context);
    }
}

// Usage
public class InterpreterPatternExample {
    public static void main(String[] args) {
        DiscountExpression expression = new ContainsDiscountKeyword("DISCOUNT");
        DiscountRuleInterpreter interpreter = new DiscountRuleInterpreter(expression);

        String rule = "APPLY_DISCOUNT";
        System.out.println("Discount applied? " + interpreter.evaluate(rule));
    }
}

