package com.mlaku.dev.kata.basketshop;

public class Quantity {
    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public int calculateTotal(int price) {
        return price * quantity;
    }
}
