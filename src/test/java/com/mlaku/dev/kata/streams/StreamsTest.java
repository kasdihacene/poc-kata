package com.mlaku.dev.kata.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StreamsTest {

    @Test
    public void shouldReturnDivisorOfTheNumber(){
        List<Object> generatedList = StreamsPoc.generateDivisorsNumber(Arrays.asList(0,1,3,6,9,45,77,89,18,55,18),27);
        System.out.println(generatedList);
        Assert.assertTrue(3==generatedList.size());
    }

    @Test
    public void shouldReturnMapOccurrences(){
        Map<Object,Long> generatedMap = StreamsPoc.generateMapOccurrences(Arrays.asList("A","B","C","D","D","B","D","G","KK","K","OO"));
        System.out.println(generatedMap);
    }

    @Test
    public void shouldReturnOccurrencesWithMax(){
        AbstractMap.SimpleEntry<Object,Long> generatedList = StreamsPoc.getMaxOccurrences(Arrays.asList(0,1,3,6,9,45,1,3,9,9,89,18,55,18,18,18,18));
        System.out.println(generatedList);
    }


}
