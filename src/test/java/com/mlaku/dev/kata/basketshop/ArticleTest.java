package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.Article;
import com.mlaku.dev.kata.basketshop.articles.Dress;
import com.mlaku.dev.kata.basketshop.articles.Price;
import com.mlaku.dev.kata.basketshop.articles.Quantity;
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
        int expectedResult = shopBasket.calculateWithoutReduction();
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
        int expectedResult = shopBasket.calculateWithoutReduction();

        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }


}
