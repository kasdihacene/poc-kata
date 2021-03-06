package com.mlaku.dev.kata.basketshop.articles;

import com.mlaku.dev.kata.basketshop.visitor.Visitor;

public class Pant extends Article {

    public Pant(String itemCode, Price price, Quantity quantity) {

        super.itemCode = itemCode;
        super.price = price;
        super.quantity = quantity;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visitTotal(this);
    }

    public static Pant.Builder instance() {
        return new Pant.Builder();
    }

    public static final class Builder {
        private String itemCode;
        private Price price;
        private Quantity quantity;

        private Builder() {
        }

        public Builder withItemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        public Builder withPrice(Price price) {
            this.price = price;
            return this;
        }

        public Builder withQuantity(Quantity quantity) {
            this.quantity = quantity;
            return this;
        }

        public Article build() {
            return new Pant(itemCode, price, quantity);
        }
    }
}
