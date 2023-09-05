/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import com.booleanchoice.exercise.algorithm.binarytree.TreeNode;

/**
 * @author booleanchoice
 * @version SumRoot2Leaf.java, v 0.1 2023年09月04日 19:50 booleanchoice
 */
public class SumRoot2Leaf {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(19);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        treeNode.left = l;
        treeNode.right = r;

        System.out.println(sum(treeNode, 0));
    }

    public static int sum(TreeNode treeNode, int l) {
        if (treeNode == null) {
            return 0;
        }
        int tmp = l * 10 + treeNode.val;
        if (treeNode.left == null && treeNode.right == null) {
            return tmp;
        }
        return sum(treeNode.left, tmp) + sum(treeNode.right, tmp);
    }

}