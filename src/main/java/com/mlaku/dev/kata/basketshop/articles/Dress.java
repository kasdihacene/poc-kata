package com.mlaku.dev.kata.basketshop.articles;

import com.mlaku.dev.kata.basketshop.visitor.Visitor;

public class Dress extends Article {

    public Dress(String itemCode, Price price, Quantity quantity) {
        super.itemCode = itemCode;
        super.price = price;
        super.quantity = quantity;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visitTotal(this);
    }

    public static Builder instance() {
        return new Builder();
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
            return new Dress(itemCode, price, quantity);
        }
    }
}
