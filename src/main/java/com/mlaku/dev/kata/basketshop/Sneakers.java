package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.Article;
import com.mlaku.dev.kata.basketshop.visitor.Visitor;

public class Sneakers extends Article {

    @Override
    public int accept(Visitor visitor) {
        return visitor.visitTotal(this);
    }
}
