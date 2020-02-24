package com.mlaku.dev.kata.sumnumbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class HowManyNumbersTest {


    @Test
    public void recCombinations0(){
        LinkedList l = new LinkedList();
        System.out.println(HowManyNumbers.generateCombinations(Arrays.asList(1,2,3,4,5).stream().collect(Collectors.toCollection(ArrayList::new)),0));
    }
    @Test
    public void recCombinations1(){
        LinkedList l = new LinkedList();
        System.out.println(HowManyNumbers.generateCombinations(Arrays.asList(1,2,3,4,5).stream().collect(Collectors.toCollection(ArrayList::new)),1));
    }
    @Test
    public void recCombinations2(){
        LinkedList l = new LinkedList();
        System.out.println(HowManyNumbers.generateCombinations(Arrays.asList(1,2,3,4,5).stream().collect(Collectors.toCollection(ArrayList::new)),2));
    }
    @Test
    public void recCombinations3(){
        LinkedList l = new LinkedList();
        System.out.println(HowManyNumbers.generateCombinations(Arrays.asList(1,2,3,4,5).stream().collect(Collectors.toCollection(ArrayList::new)),4));
    }

    @Test
    public void findAllCombinations(){
        LinkedList l = new LinkedList();
        System.out.println(HowManyNumbers.findAllCombinations(10,3));
    }

    @Test
    public void booleanTest(){
        HowManyNumbers.isMaxFromTheEnd(43356);
    }

    @Test
    public void exampleTests() {
        assertEquals(Arrays.asList(1L, 999L, 999L),         HowManyNumbers.findAll(27, 3));
        assertEquals(new ArrayList<Long>(),                 HowManyNumbers.findAll(84, 4));
        assertEquals(Arrays.asList(8L, 118L, 334L),         HowManyNumbers.findAll(10, 3));
        assertEquals(Arrays.asList(123L, 116999L, 566666L), HowManyNumbers.findAll(35, 6));
    }

}