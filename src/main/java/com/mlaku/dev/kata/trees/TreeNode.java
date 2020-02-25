package com.mlaku.dev.kata.trees;

public class TreeNode {
    private static TreeNode left;
    private static TreeNode right;
    private static int value;

    public TreeNode(TreeNode left, TreeNode right,int value){
        this.left= left;
        this.right = right;
        this.value = value;
    }

    public TreeNode(int value){
        this.left= null;
        this.right = null;
        this.value = value;
    }

    public static TreeNode TreeNode(TreeNode left, TreeNode right,int value){
        return new TreeNode(left,right,value);
    }

    public static TreeNode leaf(int value){
        return new TreeNode(value);
    }

    public static TreeNode withLeaves(int left, int right){
        TreeNode.left = new TreeNode(left);
        TreeNode.right = new TreeNode(right);
        return new TreeNode(TreeNode.left,TreeNode.right,TreeNode.value);
    }

    public static TreeNode join(int value,TreeNode left,TreeNode right){
        return new TreeNode(left,right,value);
    }


}
