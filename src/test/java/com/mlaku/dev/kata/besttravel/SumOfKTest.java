package com.mlaku.dev.kata.besttravel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumOfKTest {

    @Test
    public void tryToUnderstandIntStream(){
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        SumOfK.chooseBestSum(163,3,ts);
    }

    @Test
    public void shouldReturnOneList(){
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 15, 100));
        Integer sum = SumOfK.chooseBestSum(220,4,ts);
        System.out.println(sum);
    }

    @Test
    public void shouldReturnNullWhenNbrCombinationGreaterThanListSizeInput(){
        List<Integer> ts = new ArrayList<>(Arrays.asList(50));
        Integer sum = SumOfK.chooseBestSum(163,3,ts);
        System.out.println(sum);
    }

    @Test
    public void BasicTests1() {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = SumOfK.chooseBestSum(163, 3, ts);
        System.out.println(n);
        assertEquals(163, n);
        ts = new ArrayList<>(Arrays.asList(50));
        Integer m = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(null, m);
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = SumOfK.chooseBestSum(230, 3, ts);
        System.out.println(n);
        assertEquals(228, n);
    }

}