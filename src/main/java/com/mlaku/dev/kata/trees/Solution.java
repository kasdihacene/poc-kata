package com.mlaku.dev.kata.trees;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static Object arrayToTree(int[] arrayFrom) {
        return bestSolutionTreeCreation(Arrays.stream(arrayFrom).boxed().collect(Collectors.toList()), 0);
    }

    public static Object generateTreeIterate(List<Integer> listInputs, ArrayTreeNode node, int index) {
        if (index < listInputs.size()) {
            ArrayTreeNode temp = new ArrayTreeNode(listInputs.get(index));
            node = temp;
            node.left = (ArrayTreeNode) generateTreeIterate(listInputs, node.left, 2 * index + 1);
            node.right = (ArrayTreeNode) generateTreeIterate(listInputs, node.right, 2 * index + 2);
        }

        return node;
    }

    public static ArrayTreeNode bestSolutionTreeCreation(List<Integer> listInputs, int index) {
        return index < listInputs.size() ?
                new ArrayTreeNode(listInputs.get(0), bestSolutionTreeCreation(listInputs, index * 2 + 1), bestSolutionTreeCreation(listInputs, index * 2 + 2)) : null;
    }

    public static Object maxSum(ArrayTreeNode tree) {
        return getMaxes(tree, new HashSet<>(), 0);
    }

    public static Integer getMaxes(ArrayTreeNode tree, Set<Integer> max, int count) {
        if (tree == null) {
            max.add(count);
            return count;
        }
        count = count + tree.value;
        getMaxes(tree.left, max, count);
        getMaxes(tree.right, max, count);
        return max.stream().max(Integer::compareTo).get();
    }

    public static Integer bestSolutionTreeMaxSum(ArrayTreeNode root) {
        if (root == null) return 0;
        return Math.max(root.value + bestSolutionTreeMaxSum(root.left), root.value + bestSolutionTreeMaxSum(root.right));
    }
}
