package com.mlaku.dev.kata.basketshop;

import java.util.List;

public class ShopBasket {

    private List<Article> articleCollection;

    public ShopBasket(List<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    public int totalBasket() {

        return this.articleCollection.stream()
                .map(Article::calculateTotal)
                .reduce(0, Integer::sum);
    }
}
