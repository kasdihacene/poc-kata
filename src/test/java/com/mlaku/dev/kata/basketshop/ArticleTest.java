package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleTest {


    @Test
    public void shouldReturnTotal200WhenHaving2Articles() {
        ShopBasket shopBasket = new ShopBasket();
        Article dress = Dress.instance().withItemCode("dress").withPrice(new Price(100)).withQuantity(new Quantity(1)).build();
        Article sneakers = Sneakers.instance().withItemCode("dress").withPrice(new Price(100)).withQuantity(new Quantity(1)).build();
        shopBasket.addItem(dress);
        shopBasket.addItem(sneakers);
        int expectedResult = shopBasket.calculateTotal();
        int actualResult = 200;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnTotal300WhenHaving3Articles() {
        // ARRANGE
        int actualResult = 300;
        ShopBasket shopBasket = new ShopBasket();
        Article dress = Dress.instance().withItemCode("dress").withPrice(new Price(100)).withQuantity(new Quantity(2)).build();
        Article sneakers = Sneakers.instance().withItemCode("dress").withPrice(new Price(100)).withQuantity(new Quantity(1)).build();
        shopBasket.addItem(dress);
        shopBasket.addItem(sneakers);

        // ACT
        int expectedResult = shopBasket.calculateTotal();

        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnTotal300WhenHaving3ArticlesWithReduction() {
        // ARRANGE
        int actualResult = 300;
        ShopBasket shopBasket = new ShopBasket();
        Article dress = Dress.instance().withItemCode("dress").withPrice(new Price(100)).withQuantity(new Quantity(2)).build();
        Article sneakers = Sneakers.instance().withItemCode("dress").withPrice(new Price(100)).withQuantity(new Quantity(1)).build();
        shopBasket.addItem(dress);
        shopBasket.addItem(sneakers);

        // ACT
        int expectedResult = shopBasket.calculateTotal();

        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
