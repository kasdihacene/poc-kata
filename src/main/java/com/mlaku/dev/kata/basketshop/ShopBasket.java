package com.mlaku.dev.kata.basketshop;

import java.util.ArrayList;
import java.util.List;

public class ShopBasket {

    private List<Article> articleCollection;

    public ShopBasket(List<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    public ShopBasket() {
        this.articleCollection = new ArrayList<>();
    }

    public int totalBasket() {

        return this.articleCollection.stream()
                .map(Article::calculateTotal)
                .reduce(0, Integer::sum);
    }

    public void addItem(Article item) {
        articleCollection.add(item);
    }

    public Price fetch(String itemCode) {
        for (Article article : articleCollection) {
            if (article.isItemCode(itemCode)) {
                return article.price();
            }
        }
        return null;
    }
}
