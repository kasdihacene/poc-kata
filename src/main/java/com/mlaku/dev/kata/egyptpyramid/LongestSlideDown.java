package com.mlaku.dev.kata.egyptpyramid;

import java.util.Arrays;

public class LongestSlideDown {
    public static int longestSlideDown(int[][] pyramid) {
        int result = 0;
        for (int[] ints : pyramid) {
            System.out.println(Arrays.stream(ints).max().getAsInt());
            result += Arrays.stream(ints).max().getAsInt();
        }
        return result;
    }
}
