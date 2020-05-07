package com.mlaku.dev.kata.basketshop.articles;

import com.mlaku.dev.kata.basketshop.visitor.Visitor;

public abstract class Article {

    protected String itemCode;
    protected Price price;
    protected Quantity quantity;

    public abstract int accept(Visitor visitor);

    public int calculateTotal(){
        return price.calculateTotalPrice(this.quantity);
    }

    public boolean isItemCode(String itemCode) {
        return itemCode.equals(this.itemCode);
    }

    public Price price() {
        return this.price;
    }

    public boolean isQuantityEqualsToOne() {
        return this.quantity.equals(Quantity.factory(1));
    }

    public void decrementQuantity() {
        this.quantity.decrement();
    }


}
