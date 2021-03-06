package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.articles.*;
import com.mlaku.dev.kata.basketshop.exceptions.EmptyBasketException;
import com.mlaku.dev.kata.basketshop.exceptions.ZeroQuantityException;
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
        Article dress = Dress.instance().withItemCode("C&A").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        Article sneakers = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
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
        Article dress = Dress.instance().withItemCode("C&A").withPrice(Price.factory(100)).withQuantity(Quantity.factory(2)).build();
        Article sneakers = Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(1)).build();
        shopBasket.addItem(dress);
        shopBasket.addItem(sneakers);
        PaymentStrategy strategy = new PaymentCard("1878HK", 2020, "Hacene company");

        //ACT
        boolean actualResult = shopBasket.pay(strategy);

        // ASSERT
        Assertions.assertThat(actualResult).isTrue();
    }

    @Test(expected = ZeroQuantityException.class)
    public void shouldThrowsExceptionWhenPayingAnEmptyBasketWithCreditCard() {
        Sneakers.instance().withItemCode("Adidas").withPrice(Price.factory(100)).withQuantity(Quantity.factory(0)).build();
    }

}
