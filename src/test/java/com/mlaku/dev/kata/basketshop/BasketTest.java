package com.mlaku.dev.kata.basketshop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    @Test
    public void shouldReturnThePriceWhenHavingOneArticle() {

        int actualResult = 20;
        Price price = new Price(20);
        Quantity quantity = new Quantity(1);
        int expectedResult = ShopCalculator.total(new Article("SHOE", price, quantity));
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnThePriceOWhenHavingTheSameArticleTwoTimes() {

        int actualResult = 40;
        Price price = new Price(20);
        Quantity quantity = new Quantity(2);
        int expectedResult = ShopCalculator.total(new Article("SHOE", price, quantity));
        assertThat(actualResult).isEqualTo(expectedResult);

    }


}
