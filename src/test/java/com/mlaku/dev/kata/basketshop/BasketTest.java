package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.Article;
import com.mlaku.dev.kata.basketshop.articles.Price;
import com.mlaku.dev.kata.basketshop.articles.Quantity;
import com.mlaku.dev.kata.basketshop.articles.Sneakers;
import com.mlaku.dev.kata.basketshop.context.ExceptionResult;
import com.mlaku.dev.kata.basketshop.context.FoundResult;
import com.mlaku.dev.kata.basketshop.context.NotFoundResult;
import com.mlaku.dev.kata.basketshop.context.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    @Test
    public void shouldReturnThePriceWhenHavingOneArticle() {

        int actualResult = 20;
        Price price = Price.factory(20);
        Quantity quantity = Quantity.factory(1);
        List<Article> articleCollection = Arrays.asList(Sneakers.instance().withItemCode("SHOE").withPrice(price).withQuantity(quantity).build());
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        int expectedResult = shopBasket.totalBasket();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnThePriceWhenHavingTheSameArticleTwoTimes() {

        int actualResult = 40;
        Price price = Price.factory(20);
        Quantity quantity = Quantity.factory(2);
        List<Article> articleCollection = Arrays.asList(Sneakers.instance().withItemCode("SHOE").withPrice(price).withQuantity(quantity).build());
        int expectedResult = new ShopBasket(articleCollection).totalBasket();
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    public void shouldReturn120AsTotalPriceOfArticlesInBasket() {
        // ARRANGE
        int actualResult = 120;
        Article article1 = Sneakers.instance().withItemCode("SHOE").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
        Article article2 = Sneakers.instance().withItemCode("SHOE").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
        Article article3 = Sneakers.instance().withItemCode("SHOE").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
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
        Article article2 = Sneakers.instance().withItemCode("SANDAL").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
        Article article3 = Sneakers.instance().withItemCode("SHOE").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
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
        Article article2 = Sneakers.instance().withItemCode("SANDAL").withPrice(Price.factory(30)).withQuantity(Quantity.factory(2)).build();
        Article article3 = Sneakers.instance().withItemCode("SHOE").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        // ACT
        int expectedResult = new ShopBasket(articleCollection).totalBasket();
        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void returnsPriceOfAdidasShoesWhenItemCodeIsAdidas() {
        Result actualResult = new FoundResult(Price.factory(100));
        Article article2 = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        Article article3 = Sneakers.instance().withItemCode("Rebook").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        // ACT
        Result expectedResult = shopBasket.fetch("Adidas");
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void returnsExceptionResultWhenHavingAnEmptyListArticles() {
        String itemCode = "Adidas";
        Result actualResult = new ExceptionResult(itemCode);
        ShopBasket shopBasket = new ShopBasket(new ArrayList<>());
        // ACT
        Result expectedResult = shopBasket.fetch(itemCode);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void returnsPriceOfAdidasShoesWhenItemCodeNotExists() {
        Result actualResult = new NotFoundResult("Nike");
        Article article2 = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        Article article3 = Sneakers.instance().withItemCode("Rebook").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        // ACT
        Result expectedResult = shopBasket.fetch("Nike");
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnTrueWhenRemovingAPairOfAdidasShoes() {

        Article article2 = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        Article article3 = Sneakers.instance().withItemCode("Rebook").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
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
    public void shouldReturnTrueWhenRemovingOnePairOfAdidasShoes() {

        Article article2 = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        Article article3 = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        List<Article> articleCollection = Arrays.asList(article2, article3);
        ShopBasket shopBasket = new ShopBasket(articleCollection);
        int actualResult = 300;
        // ACT

        boolean expectedResult = shopBasket.remove("Adidas");
        assertThat(expectedResult).isTrue();

        int expectedResultTotal = shopBasket.totalBasket();
        assertThat(actualResult).isEqualTo(expectedResultTotal);
    }

    @Test
    public void shouldReturnFalseWhenRemovingABrandOfShoesThatDoesntExist() {

        Article article2 = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        Article article3 = Sneakers.instance().withItemCode("Rebook").withPrice(Price.factory(20)).withQuantity(Quantity.factory(2)).build();
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
