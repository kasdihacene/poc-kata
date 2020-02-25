package com.mlaku.dev.kata.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {
    @Test
    public void emptyArray() {
        ArrayTreeNode expected = null;
        assertThat(Solution.arrayToTree(arrayFrom()), is(expected));
    }

    @Test
    public void arrayWithMultipleElements() {
        ArrayTreeNode expected = new ArrayTreeNode(17, new ArrayTreeNode(0, new ArrayTreeNode(3), new ArrayTreeNode(15)), new ArrayTreeNode(-4));
        assertThat(Solution.arrayToTree(arrayFrom(17, 0, -4, 3, 15)), is(expected));
    }

    private int[] arrayFrom(int... values) {
        return values;
    }

    @Test
    public void maxSumInPerfectTree() {
        ArrayTreeNode expected = new ArrayTreeNode(17, new ArrayTreeNode(0, new ArrayTreeNode(3), new ArrayTreeNode(15)), new ArrayTreeNode(-4));

        System.out.println(Solution.getMaxes(expected, new HashSet<>(),0));
        //assertThat(Solution.maxSum(expected), is(32));
    }
}
