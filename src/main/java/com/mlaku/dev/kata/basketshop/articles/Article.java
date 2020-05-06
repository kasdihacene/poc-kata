package com.mlaku.dev.kata.basketshop.articles;

import com.mlaku.dev.kata.basketshop.visitor.Visitor;

public class Article extends ArticleElement {
    private String itemCode;
    private Price price;
    private Quantity quantity;

    private Article(String itemCode, Price price, Quantity quantity) {
        this.itemCode = itemCode;
        this.price = price;
        this.quantity = quantity;
    }

    public Article() {
    }

    public int calculateTotal() {
        return price.calculateTotalPrice(this.quantity);
    }

    public static Builder instance() {
        return new Builder();
    }

    public boolean isItemCode(String itemCode) {
        return itemCode.equals(this.itemCode);
    }

    public Price price() {
        return this.price;
    }

    public boolean isQuantityEqualsToOne() {
        return this.quantity.equals(new Quantity(1));
    }

    public void decrementQuantity() {
        this.quantity.decrement();
    }

    @Override
    public int accept(Visitor visitor) {
        return calculateTotal();
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
            return new Article(itemCode, price, quantity);
        }
    }
}
