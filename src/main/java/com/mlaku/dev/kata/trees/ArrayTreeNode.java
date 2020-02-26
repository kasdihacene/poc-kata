package com.mlaku.dev.kata.trees;

import java.util.Objects;

class ArrayTreeNode {

    ArrayTreeNode left;
    ArrayTreeNode right;
    int value;

    ArrayTreeNode(int value, ArrayTreeNode left, ArrayTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    ArrayTreeNode(int value) {
        this(value, null, null);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ArrayTreeNode) {
            ArrayTreeNode otherNode = (ArrayTreeNode) other;
            return this.toString().equals(otherNode.toString());
        }
        return false;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + ((this.left == null) ? "" : left.toString()) +
                ", right=" + ((this.right == null) ? "" : right.toString()) +
                ", value=" + value +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(((left == null) ? "" : left), (right == null ? "" : right), value);
    }
}