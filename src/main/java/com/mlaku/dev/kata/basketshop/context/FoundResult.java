package com.mlaku.dev.kata.basketshop.context;

import com.mlaku.dev.kata.basketshop.articles.Price;

import java.util.Objects;

public class FoundResult extends Result {

    private Price price;

    public FoundResult(Price price) {
        super();
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoundResult that = (FoundResult) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
