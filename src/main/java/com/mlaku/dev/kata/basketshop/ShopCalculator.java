package com.mlaku.dev.kata.basketshop;

public class ShopCalculator {
    public static int total(Article article) {
        return article.getPrice()*article.getQuantity();
    }
}
