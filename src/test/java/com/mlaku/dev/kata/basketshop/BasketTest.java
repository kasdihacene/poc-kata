package com.mlaku.dev.kata.basketshop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    @Test
    public void init() {
        assertThat(false).isFalse();
    }

    @Test
    public void shouldReturnThePriceWhenHavingOneArticle() {

        int actualResult = 20;
        int expectedResult = ShopCalculator.total(new Article("SHOE", 20,1));
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
