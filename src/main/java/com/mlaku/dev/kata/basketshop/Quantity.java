package com.mlaku.dev.kata.basketshop;

import java.util.Objects;

public class Quantity {
    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public int calculateTotal(int price) {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return quantity == quantity1.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    public void decrement() {
        this.quantity--;
    }
}
