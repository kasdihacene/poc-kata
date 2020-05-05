package com.mlaku.dev.kata.basketshop;

import java.util.Objects;

public class Price {
    private final int price;
    public Price(int price) {
        this.price = price;
    }

    int calculateTotalPrice(Quantity quantity) {
        return quantity.calculateTotal(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                '}';
    }
}
