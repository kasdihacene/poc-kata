package com.mlaku.dev.kata.basketshop.articles;

import com.mlaku.dev.kata.basketshop.visitor.Visitor;

public abstract class Article {

    public abstract int accept(Visitor visitor);

    public abstract int calculateTotal();

    public abstract boolean isItemCode(String itemCode);

    public abstract Price price();

    public abstract boolean isQuantityEqualsToOne();

    public abstract void decrementQuantity();


}
