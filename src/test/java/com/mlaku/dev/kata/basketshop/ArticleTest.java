package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.*;
import com.mlaku.dev.kata.basketshop.visitor.ConcreteVisitor;
import com.mlaku.dev.kata.basketshop.visitor.ConcreteVisitorWithReduction;
import com.mlaku.dev.kata.basketshop.visitor.Visitor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleTest {


    @Test
    public void returnsNewTotalAfterAddingNewArticlesAdidasShoesToTheCollection() {
        int actualResult = 250;
        Visitor visitor = new ConcreteVisitor();
        ShopBasket shopBasket = new ShopBasket(visitor);
        Article item1 = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
        Article item2 = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(150)).withQuantity(Quantity.factory(1)).build();
        shopBasket.addItem(item1);
        shopBasket.addItem(item2);
        int expectedResult = shopBasket.totalBasket();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnTotal200WhenHaving2Articles() {

        Visitor visitor = new ConcreteVisitor();
        ShopBasket shopBasket = new ShopBasket(visitor);
        Article dress = Dress.instance().withItemCode("dress").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
        Article sneakers = Sneakers.instance().withItemCode("dress").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
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
        Visitor visitor = new ConcreteVisitor();
        ShopBasket shopBasket = new ShopBasket(visitor);
        Article dress = Dress.instance().withItemCode("dress").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        Article sneakers = Sneakers.instance().withItemCode("dress").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
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
        int actualResult = 2000;
        Visitor visitor = new ConcreteVisitorWithReduction();
        ShopBasket shopBasket = new ShopBasket(visitor);
        Article dress = Dress.instance().withItemCode("dress").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        Article sneakers = Sneakers.instance().withItemCode("dress").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
        shopBasket.addItem(dress);
        shopBasket.addItem(sneakers);

        // ACT
        int expectedResult = shopBasket.calculateTotal();

        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    public void shouldReturnTotal400WhenHaving3DifferentArticles() {
        // ARRANGE
        int actualResult = 300;
        Visitor visitor = new ConcreteVisitor();
        ShopBasket shopBasket = new ShopBasket(visitor);
        Article dress = Dress.instance().withItemCode("dress").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
        Article sneakers = Sneakers.instance().withItemCode("dress").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
        Article pant = Pant.instance().withItemCode("dress").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
        shopBasket.addItem(dress);
        shopBasket.addItem(sneakers);
        shopBasket.addItem(pant);

        // ACT
        int expectedResult = shopBasket.calculateTotal();

        // ASSERT
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
