package com.mlaku.dev.kata.basketshop.context;

import java.util.Objects;

public class ExceptionResult extends Result {

    private String itemCode;

    public ExceptionResult(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExceptionResult that = (ExceptionResult) o;
        return Objects.equals(itemCode, that.itemCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCode);
    }

    @Override
    public String toString() {
        return "ExceptionResult{" +
                "itemCode='" + itemCode + '\'' +
                '}';
    }
}
