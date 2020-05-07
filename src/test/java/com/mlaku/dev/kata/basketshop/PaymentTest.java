package com.mlaku.dev.kata.basketshop;

import com.mlaku.dev.kata.basketshop.strategy.PaymentPaypal;
import com.mlaku.dev.kata.basketshop.strategy.PaymentStrategy;
import com.mlaku.dev.kata.basketshop.visitor.ConcreteVisitor;
import com.mlaku.dev.kata.basketshop.visitor.Visitor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PaymentTest {

    @Test
    public void shouldReturnsTrueWhenPayingOurBasket() {

        PaymentStrategy strategy = new PaymentPaypal("Hacene", "aaaa");
        Visitor visitor = new ConcreteVisitor();
        ShopBasket shopBasket = new ShopBasket(visitor);
        boolean actualResult = shopBasket.pay(strategy);
        Assertions.assertThat(actualResult).isTrue();

    }
}
