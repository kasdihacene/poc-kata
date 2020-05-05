package com.mlaku.dev.kata.basketshop;

public class Article {
    private final String itemCode;
    private final int price;
    private final int quantity;

    public Article(String itemCode, int price, int quantity) {
        this.itemCode = itemCode;
        this.price = price;
        this.quantity = quantity;
    }

    int calculateTotal() {
        return this.getPrice() * this.getQuantity();
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return quantity;
    }
}
