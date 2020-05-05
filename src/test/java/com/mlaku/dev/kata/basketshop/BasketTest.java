package com.mlaku.dev.kata.basketshop;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    @Test
    public void shouldReturnThePriceWhenHavingOneArticle() {

        int actualResult = 20;
        Price price = new Price(20);
        Quantity quantity = new Quantity(1);
        List<Article> articleCollection = Arrays.asList(Article.instance().withItemCode("SHOE").withPrice(price).withQuantity(quantity).build());
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        int result = shopBasket.totalBasket();
        int expectedResult = result;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnThePriceWhenHavingTheSameArticleTwoTimes() {

        int actualResult = 40;
        Price price = new Price(20);
        Quantity quantity = new Quantity(2);
        List<Article> articleCollection = Arrays.asList(Article.instance().withItemCode("SHOE").withPrice(price).withQuantity(quantity).build());
        int result = new ShopBasket(articleCollection).totalBasket();
        int expectedResult = result;
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    public void ShouldReturn120AsTotalPriceOfArticlesInBasket() {
        // ARRANGE
        int actualResult = 120;
        Article article1 = Article.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        Article article2 = Article.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        Article article3 = Article.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article1, article2, article3);
        // ACT
        int expectedResult = new ShopBasket(articleCollection).totalBasket();
        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void ShouldReturn80AsTotalPriceOfArticlesInBasket() {
        // ARRANGE
        int actualResult = 80;
        Article article2 = Article.instance().withItemCode("SANDAL").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        Article article3 = Article.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        // ACT
        int expectedResult = new ShopBasket(articleCollection).totalBasket();
        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void ShouldReturn100AsTotalPriceOfShoeAndOtherArticleInBasket() {
        // ARRANGE
        int actualResult = 100;
        Article article2 = Article.instance().withItemCode("SANDAL").withPrice(new Price(30)).withQuantity(new Quantity(2)).build();
        Article article3 = Article.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        // ACT
        int expectedResult = new ShopBasket(articleCollection).totalBasket();
        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }


}
