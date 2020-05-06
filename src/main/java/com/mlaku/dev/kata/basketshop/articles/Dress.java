package com.mlaku.dev.kata.basketshop.articles;

import com.mlaku.dev.kata.basketshop.visitor.Visitor;

public class Dress extends Article {

    @Override
    public int accept(Visitor visitor) {
        return visitor.visitTotal(this);
    }

}
