package com.mlaku.dev.kata.basketshop.visitor;

import com.mlaku.dev.kata.basketshop.articles.Pant;
import com.mlaku.dev.kata.basketshop.articles.Sneakers;
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

    @Override
    public int visitTotal(Pant pant) {
        return pant.calculateTotal();
    }
}
