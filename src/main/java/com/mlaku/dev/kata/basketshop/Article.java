package com.mlaku.dev.kata.basketshop;

public class Article {
    private final String itemCode;
    private final Price price;
    private final Quantity quantity;

    public Article(String itemCode, Price price, Quantity quantity) {
        this.itemCode = itemCode;
        this.price = price;
        this.quantity = quantity;
    }

    int calculateTotal() {
        return price.calculateTotalPrice(this.quantity);
    }

}
