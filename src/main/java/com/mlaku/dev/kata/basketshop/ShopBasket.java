package com.mlaku.dev.kata.basketshop;

import java.util.List;

public class ShopBasket {

    public static int totalBasket(List<Article> articleCollection) {

        return articleCollection.stream()
                .map(Article::calculateTotal)
                .reduce(0, Integer::sum);
    }
}
