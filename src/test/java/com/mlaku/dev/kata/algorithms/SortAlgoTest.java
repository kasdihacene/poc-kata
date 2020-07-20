package com.mlaku.dev.kata.algorithms;

import org.junit.Test;

import java.util.Arrays;

public class SortAlgoTest {

    @Test
    public void mergeSort_Test() {
        int[] array = {22, 54, 21, 8, 77, 120, 1, 6, 88};
        SortAlgo.mergeSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    @Test
    public void searchElementDictomy_Test() {
        int[] array = {-88, -5, 0, 1, 33, 44, 55, 60, 66, 77, 88, 99, 1000};
        boolean found = SortAlgo.exists(array, 44);
        System.out.println(found);

    }

    @Test
    public void searchElementDictomy_2_Test() {
        int[] array = {-88, -5, 0, 1, 33, 44, 55, 60, 66, 77, 88, 99, 1000, 2000};
        boolean found = SortAlgo.exists(array, 200);
        System.out.println(found);

    }

    @Test
    public void searchClosestToZero_Test() {
        int[] ints = {1, -9, 8, 2, -2, -5, 7, -2, -2, 88, 4, -1};

        int i = SortAlgo.closestToZero(ints);

        System.out.println(i);
    }

}
