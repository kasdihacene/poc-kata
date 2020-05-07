package com.mlaku.dev.kata.basketshop.articles;

import java.util.Objects;

public class Price {
    private final int aPrice;
    private Price(int aPrice) {
        this.aPrice = aPrice;
    }

    public static Price factory(int aPrice) {
        return new Price(aPrice);
    }

    int calculateTotalPrice(Quantity quantity) {
        return quantity.calculateTotal(aPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return aPrice == price1.aPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aPrice);
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + aPrice +
                '}';
    }
}
