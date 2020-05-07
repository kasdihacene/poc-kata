package com.mlaku.dev.kata.basketshop.strategy;

public class PaymentPaypal implements PaymentStrategy {
    public PaymentPaypal(String hacene, String aaaa) {

    }

    @Override
    public boolean pay(int total) {
        return true;
    }
}
