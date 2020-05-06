package com.mlaku.dev.kata.basketshop;

public abstract class Result {

    public static Result articleFound(Price price){
        return new FoundResult(price);
    }

    public static Result articleNotFound(String itemCode){
        return new NotFoundResult(itemCode);
    }

}
