package com.mlaku.dev.kata.egyptpyramid;

import java.util.Arrays;

public class LongestSlideDown {
    public static int longestSlideDown(int[][] pyramid) {
        int result = 0;
        for (int i = 0; i < pyramid.length; i++) {
                System.out.println(Arrays.stream(pyramid[i]).max().getAsInt());
                result+= Arrays.stream(pyramid[i]).max().getAsInt();
        }
        return result;
    }
}
