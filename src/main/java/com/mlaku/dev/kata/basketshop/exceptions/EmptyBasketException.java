package com.mlaku.dev.kata.basketshop.exceptions;

public class EmptyBasketException extends Throwable {
    public EmptyBasketException(String message) {
        super(message);
    }
}
