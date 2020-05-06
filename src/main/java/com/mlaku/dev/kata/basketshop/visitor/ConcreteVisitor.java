package com.mlaku.dev.kata.basketshop.visitor;

import com.mlaku.dev.kata.basketshop.Sneakers;
import com.mlaku.dev.kata.basketshop.articles.Dress;

public class ConcreteVisitor extends Visitor {

    @Override
    public int visitTotal(Dress dress) {
        return dress.calculateTotal();
    }

    @Override
    public int visitTotal(Sneakers sneakers) {
        return sneakers.calculateTotal();
    }
}
