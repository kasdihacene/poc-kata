package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.Article;
import com.mlaku.dev.kata.basketshop.context.Result;
import com.mlaku.dev.kata.basketshop.visitor.ConcreteVisitor;
import com.mlaku.dev.kata.basketshop.visitor.ConcreteVisitorWithReduction;
import com.mlaku.dev.kata.basketshop.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ShopBasket {

    private Visitor visitor;
    private List<Article> articleCollection;

    public ShopBasket(List<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    public ShopBasket(Visitor visitor) {
        this.visitor = visitor;
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

    public int calculateWithoutReduction() {
        Visitor visitor = new ConcreteVisitor();
        return this.articleCollection.stream()
                .map(article -> article.accept(visitor))
                .reduce(0, Integer::sum);
    }

    public int calculateWithReduction() {
        Visitor visitor = new ConcreteVisitorWithReduction();
        return this.articleCollection.stream()
                .map(article -> article.accept(visitor))
                .reduce(0, Integer::sum);
    }
    public int calculateTotal(){
        return this.articleCollection.stream()
                .map(article -> article.accept(visitor))
                .reduce(0, Integer::sum);
    }
}
