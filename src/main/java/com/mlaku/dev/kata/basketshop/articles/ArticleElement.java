package com.mlaku.dev.kata.basketshop.articles;

import com.mlaku.dev.kata.basketshop.visitor.Visitor;

public abstract class ArticleElement {

    public abstract int accept(Visitor visitor);
}
