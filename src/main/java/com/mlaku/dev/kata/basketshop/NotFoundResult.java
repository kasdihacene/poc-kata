package com.mlaku.dev.kata.basketshop;

import java.util.Objects;

public class NotFoundResult extends Result {
    private String itemCode;

    public NotFoundResult(String itemCode) {
        super();
        this.itemCode = itemCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotFoundResult that = (NotFoundResult) o;
        return Objects.equals(itemCode, that.itemCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCode);
    }
}
