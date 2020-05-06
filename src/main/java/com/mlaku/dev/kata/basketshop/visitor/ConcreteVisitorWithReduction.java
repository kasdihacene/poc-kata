package com.mlaku.dev.kata.basketshop.visitor;

import com.mlaku.dev.kata.basketshop.articles.Dress;
import com.mlaku.dev.kata.basketshop.articles.Pant;
import com.mlaku.dev.kata.basketshop.articles.Sneakers;

public class ConcreteVisitorWithReduction extends Visitor {
    @Override
    public int visitTotal(Dress dress) {
        return 1000;
    }

    @Override
    public int visitTotal(Sneakers sneakers) {
        return 1000;
    }

    @Override
    public int visitTotal(Pant pant) {
        return 500;
    }
}
