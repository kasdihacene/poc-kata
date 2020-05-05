package com.mlaku.dev.kata.basketshop;

public class Article {
    private final String itemCode;
    private final Price price;
    private final Quantity quantity;

    private Article(String itemCode, Price price, Quantity quantity) {
        this.itemCode = itemCode;
        this.price = price;
        this.quantity = quantity;
    }

    int calculateTotal() {
        return price.calculateTotalPrice(this.quantity);
    }

    public static Builder instance() {
        return new Builder();
    }

    protected static final class Builder {
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
            return new Article(itemCode, price, quantity);
        }
    }
}
