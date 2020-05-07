package com.mlaku.dev.kata.basketshop.strategy;

public class PaymentPaypal implements PaymentStrategy {
    private final String id;
    private final String secret;

    public PaymentPaypal(String id, String secret) {
        this.id = id;
        this.secret = secret;
    }

    @Override
    public boolean pay(int total) {
        String message = String.format("The payment was done with Paypal - amount : %s £",total);
        System.out.println(message);
        return true;
    }
}
