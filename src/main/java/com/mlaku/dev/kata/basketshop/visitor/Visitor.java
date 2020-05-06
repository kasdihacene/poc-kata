package com.mlaku.dev.kata.basketshop.visitor;

import com.mlaku.dev.kata.basketshop.articles.Sneakers;
import com.mlaku.dev.kata.basketshop.articles.Dress;

public abstract class Visitor {

    public abstract int visitTotal(Dress dress);
    public abstract int visitTotal(Sneakers sneakers);
}
