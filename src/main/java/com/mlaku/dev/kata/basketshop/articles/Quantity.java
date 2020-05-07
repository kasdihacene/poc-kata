package com.mlaku.dev.kata.basketshop.articles;

import com.mlaku.dev.kata.basketshop.exceptions.ZeroQuantityException;

import java.util.Objects;

public class Quantity {
    private int aQuantity;

    public Quantity(int aQuantity) {
        // Unchecked exception
        if (aQuantity == 0) throw new ZeroQuantityException("quantity should not be equal to zero");
        this.aQuantity = aQuantity;
    }

    public int calculateTotal(int price) {
        return price * aQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return aQuantity == quantity1.aQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aQuantity);
    }

    public void decrement() {
        this.aQuantity--;
    }
}
