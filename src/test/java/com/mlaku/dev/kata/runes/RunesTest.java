package com.mlaku.dev.kata.runes;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RunesTest {

    @Test
    public void shouldReturn3Possibilities() {
        BinaryExpression expression = new BinaryExpression("458?--6312=66?");
        Set<Integer> integers = Runes.getPossibleIntegers(expression.getAllIntegers());
        assertTrue(integers.size() == 3);
    }

    @Test
    public void additionShouldFailWhenExpressionIncorrect() {
        BinaryExpression expression = new BinaryExpression("33?+6312=66?");
        Set<Integer> integers = Runes.seekForCorrectEquation(expression);
        assertTrue(integers.isEmpty());
    }

    @Test
    public void additionShouldSucceedWhenExpressionIsCorrect() {
        BinaryExpression expression = new BinaryExpression("10+1?=??");
        Set<Integer> integers = Runes.seekForCorrectEquation(expression);
        assertTrue(integers.size() == 1);
    }

    @Test
    public void subsShouldFailWhenIntegerContainsOnly00() {
        BinaryExpression expression = new BinaryExpression("10-1?=??");
        Set<Integer> integers = Runes.seekForCorrectEquation(expression);
        assertTrue(integers.isEmpty());
    }

    @Test
    public void subsShouldSucceedWhenOnlyOneSuggestionFound() {
        BinaryExpression expression = new BinaryExpression("123--123=24?");
        Set<Integer> integers = Runes.seekForCorrectEquation(expression);
        assertTrue(integers.size() == 1);
    }

    @Test
    public void subsShouldChooseTheLowestNumber() {
        assertEquals("Answer for expression '1*2?=2?' ", 0, Runes.solveExpression("1*2?=2?"));
    }

    @Test
    public void testSample() {
        assertEquals( "Answer for expression '1+1=?' " , 2 , Runes.solveExpression("1+1=?") );
        assertEquals( "Answer for expression '123*45?=5?088' " , 6 , Runes.solveExpression("123*45?=5?088") );
        assertEquals( "Answer for expression '-5?*-1=5?' " , 0 , Runes.solveExpression("-5?*-1=5?") );
        assertEquals( "Answer for expression '19--45=5?' " , -1 , Runes.solveExpression("19--45=5?") );
        assertEquals( "Answer for expression '??*??=302?' " , 5 , Runes.solveExpression("??*??=302?") );
        assertEquals( "Answer for expression '?*11=??' " , 2 , Runes.solveExpression("?*11=??") );
        assertEquals( "Answer for expression '??*1=??' " , 2 , Runes.solveExpression("??*1=??") );
        assertEquals( "Answer for expression '??+??=??' " , -1 , Runes.solveExpression("??+??=??") );
    }

}