package com.mlaku.dev.kata.basketshop.context;

import com.mlaku.dev.kata.basketshop.articles.Price;

public abstract class Result {

    public static Result articleFound(Price price){
        return new FoundResult(price);
    }

    public static Result articleNotFound(String itemCode){
        return new NotFoundResult(itemCode);
    }

    public static Result exception(String itemCode){
        return new ExceptionResult(itemCode);
    }

}
