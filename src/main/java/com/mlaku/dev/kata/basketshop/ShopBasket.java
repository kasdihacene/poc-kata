package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.Article;
import com.mlaku.dev.kata.basketshop.context.Result;

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

    public Result fetch(String itemCode) {
        for (Article article : articleCollection) {
            if (article.isItemCode(itemCode)) {
                return Result.articleFound(article.price());
            }
        }
        return Result.articleNotFound(itemCode);
    }

    public boolean remove(String itemCode) {
        for (Article article : articleCollection) {
            if (article.isItemCode(itemCode)) {
                if (article.isQuantityEqualsToOne()) articleCollection.remove(article);
                else article.decrementQuantity();
                return true;
            }
        }
        return false;
    }
}
