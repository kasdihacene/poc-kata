package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.*;
import com.mlaku.dev.kata.basketshop.strategy.PaymentPaypal;
import com.mlaku.dev.kata.basketshop.strategy.PaymentStrategy;
import com.mlaku.dev.kata.basketshop.visitor.ConcreteVisitor;
import com.mlaku.dev.kata.basketshop.visitor.Visitor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PaymentTest {

    @Test
    public void shouldReturnsTrueWhenPayingOurBasketWithPaypalStrategy() {

        // ARRANGE
        Visitor visitor = new ConcreteVisitor();
        ShopBasket shopBasket = new ShopBasket(visitor);
        Article dress = Dress.instance().withItemCode("C&A").withPrice(new Price(100)).withQuantity(new Quantity(2)).build();
        Article sneakers = Sneakers.instance().withItemCode("Adidas").withPrice(new Price(100)).withQuantity(new Quantity(1)).build();
        shopBasket.addItem(dress);
        shopBasket.addItem(sneakers);
        PaymentStrategy strategy = new PaymentPaypal("Hacene", "aaaa");

        //ACT
        boolean actualResult = shopBasket.pay(strategy);

        // ASSERT
        Assertions.assertThat(actualResult).isTrue();
    }

    @Test
    public void shouldReturnsTrueWhenPayingOurBasketWithCreditCard() {

        // ARRANGE
        Visitor visitor = new ConcreteVisitor();
        ShopBasket shopBasket = new ShopBasket(visitor);
        Article dress = Dress.instance().withItemCode("C&A").withPrice(new Price(100)).withQuantity(new Quantity(2)).build();
        Article sneakers = Sneakers.instance().withItemCode("Adidas").withPrice(new Price(100)).withQuantity(new Quantity(1)).build();
        shopBasket.addItem(dress);
        shopBasket.addItem(sneakers);
        PaymentStrategy strategy = new PaymentCard("1878HK", 2020, "Hacene company");

        //ACT
        boolean actualResult = shopBasket.pay(strategy);

        // ASSERT
        Assertions.assertThat(actualResult).isTrue();
    }

}
