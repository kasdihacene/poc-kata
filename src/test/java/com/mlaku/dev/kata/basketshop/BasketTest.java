package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.Article;
import com.mlaku.dev.kata.basketshop.articles.Price;
import com.mlaku.dev.kata.basketshop.articles.Quantity;
import com.mlaku.dev.kata.basketshop.articles.Sneakers;
import com.mlaku.dev.kata.basketshop.context.FoundResult;
import com.mlaku.dev.kata.basketshop.context.NotFoundResult;
import com.mlaku.dev.kata.basketshop.context.Result;
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
        List<Article> articleCollection = Arrays.asList(Sneakers.instance().withItemCode("SHOE").withPrice(price).withQuantity(quantity).build());
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        int expectedResult = shopBasket.totalBasket();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnThePriceWhenHavingTheSameArticleTwoTimes() {

        int actualResult = 40;
        Price price = new Price(20);
        Quantity quantity = new Quantity(2);
        List<Article> articleCollection = Arrays.asList(Sneakers.instance().withItemCode("SHOE").withPrice(price).withQuantity(quantity).build());
        int expectedResult = new ShopBasket(articleCollection).totalBasket();
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    public void shouldReturn120AsTotalPriceOfArticlesInBasket() {
        // ARRANGE
        int actualResult = 120;
        Article article1 = Sneakers.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        Article article2 = Sneakers.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        Article article3 = Sneakers.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article1, article2, article3);
        // ACT
        int expectedResult = new ShopBasket(articleCollection).totalBasket();
        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturn80AsTotalPriceOfArticlesInBasket() {
        // ARRANGE
        int actualResult = 80;
        Article article2 = Sneakers.instance().withItemCode("SANDAL").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        Article article3 = Sneakers.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        // ACT
        int expectedResult = new ShopBasket(articleCollection).totalBasket();
        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturn100AsTotalPriceOfShoeAndOtherArticleInBasket() {
        // ARRANGE
        int actualResult = 100;
        Article article2 = Sneakers.instance().withItemCode("SANDAL").withPrice(new Price(30)).withQuantity(new Quantity(2)).build();
        Article article3 = Sneakers.instance().withItemCode("SHOE").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        // ACT
        int expectedResult = new ShopBasket(articleCollection).totalBasket();
        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void returnsPriceOfAdidasShoesWhenItemCodeIsAdidas() {
        Result actualResult = new FoundResult(new Price(100));
        Article article2 = Sneakers.instance().withItemCode("Adidas").withPrice(new Price(100)).withQuantity(new Quantity(2)).build();
        Article article3 = Sneakers.instance().withItemCode("Rebook").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        // ACT
        Result expectedResult = shopBasket.fetch("Adidas");
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void returnsPriceOfAdidasShoesWhenItemCodeNotExists() {
        Result actualResult = new NotFoundResult("Nike");
        Article article2 = Sneakers.instance().withItemCode("Adidas").withPrice(new Price(100)).withQuantity(new Quantity(2)).build();
        Article article3 = Sneakers.instance().withItemCode("Rebook").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        // ACT
        Result expectedResult = shopBasket.fetch("Nike");
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnTrueWhenRemovingAPairOfAdidasShoes() {

        Article article2 = Sneakers.instance().withItemCode("Adidas").withPrice(new Price(100)).withQuantity(new Quantity(2)).build();
        Article article3 = Sneakers.instance().withItemCode("Rebook").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        int actualResult = 140;
        // ACT

        boolean expectedResult = shopBasket.remove("Adidas");
        assertThat(expectedResult).isTrue();

        int expectedResultTotal = shopBasket.totalBasket();
        assertThat(actualResult).isEqualTo(expectedResultTotal);
    }

    @Test
    public void shouldReturnFalseWhenRemovingABrandOfShoesThatDoesntExist() {

        Article article2 = Sneakers.instance().withItemCode("Adidas").withPrice(new Price(100)).withQuantity(new Quantity(2)).build();
        Article article3 = Sneakers.instance().withItemCode("Rebook").withPrice(new Price(20)).withQuantity(new Quantity(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        int actualResult = 240;
        // ACT

        boolean expectedResult = shopBasket.remove("Nike");
        assertThat(expectedResult).isFalse();

        int expectedResultTotal = shopBasket.totalBasket();
        assertThat(actualResult).isEqualTo(expectedResultTotal);
    }



}
