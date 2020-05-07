package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.*;
import com.mlaku.dev.kata.basketshop.exceptions.EmptyBasketException;
import com.mlaku.dev.kata.basketshop.strategy.PaymentCard;
import com.mlaku.dev.kata.basketshop.strategy.PaymentPaypal;
import com.mlaku.dev.kata.basketshop.strategy.PaymentStrategy;
import com.mlaku.dev.kata.basketshop.visitor.ConcreteVisitor;
import com.mlaku.dev.kata.basketshop.visitor.Visitor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PaymentTest {

    @Test
    public void shouldReturnsTrueWhenPayingOurBasketWithPaypalStrategy() throws EmptyBasketException {

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
    public void shouldReturnsTrueWhenPayingOurBasketWithCreditCard() throws EmptyBasketException {

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

    @Test(expected = EmptyBasketException.class)
    public void shouldThrowsExceptionWhenPayingAnEmptyBasketWithCreditCard() throws EmptyBasketException {

        // ARRANGE
        Visitor visitor = new ConcreteVisitor();
        ShopBasket shopBasket = new ShopBasket(visitor);
        PaymentStrategy strategy = new PaymentCard("1878HK", 2020, "Hacene company");

        Article sneakers = Sneakers.instance().withItemCode("Adidas").withPrice(new Price(100)).withQuantity(new Quantity(0)).build();
        shopBasket.addItem(sneakers);

        //ACT
        shopBasket.pay(strategy);
    }

}
