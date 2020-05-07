package com.mlaku.dev.kata.basketshop.exceptions;

public class ZeroQuantityException extends RuntimeException {
    public ZeroQuantityException(String message) {
        super(message);
    }
}
