package com.mlaku.dev.kata.basketshop.strategy;

public class PaymentCard implements PaymentStrategy {
    private final String id;
    private final int code;
    private final String company;

    public PaymentCard(String id, int code, String company) {
        this.id = id;
        this.code = code;
        this.company = company;
    }

    @Override
    public boolean pay(int total) {
        String message = String.format("The payment was done with Credit Card - amount : %s £ - company : %s", total, this.company);
        System.out.println(message);
        return true;
    }
}
