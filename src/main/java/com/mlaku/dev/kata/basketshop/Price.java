package com.mlaku.dev.kata.basketshop;

public class Price {
    private final int price;
    public Price(int price) {
        this.price = price;
    }

    int calculateTotalPrice(Quantity quantity) {
        return quantity.calculateTotal(price);
    }
}
