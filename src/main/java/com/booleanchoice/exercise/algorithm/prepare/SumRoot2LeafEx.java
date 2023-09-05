/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import com.booleanchoice.exercise.algorithm.binarytree.TreeNode;

/**
 * @author booleanchoice
 * @version SumRoot2LeafEx.java, v 0.1 2023年09月05日 17:12 booleanchoice
 */
public class SumRoot2LeafEx {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(19);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        treeNode.left = l;
        treeNode.right = r;

        System.out.println(sum(treeNode, 0));
    }

    public static int sum(TreeNode node, int l) {
        if (node == null) {
            return 0;
        }
        int tmp = l * 10 + node.val;
        if (node.left == null && node.right == null) {
            return tmp;
        }
        return sum(node.left, tmp) + sum(node.right, tmp);
    }

}