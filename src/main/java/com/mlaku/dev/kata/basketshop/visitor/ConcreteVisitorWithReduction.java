package com.mlaku.dev.kata.basketshop.visitor;

import com.mlaku.dev.kata.basketshop.articles.Sneakers;
import com.mlaku.dev.kata.basketshop.articles.Dress;

public class ConcreteVisitorWithReduction extends Visitor {
    @Override
    public int visitTotal(Dress dress) {
        return 1000;
    }

    @Override
    public int visitTotal(Sneakers sneakers) {
        return 1000;
    }
}
