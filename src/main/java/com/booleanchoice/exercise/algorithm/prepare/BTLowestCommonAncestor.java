/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import com.booleanchoice.exercise.algorithm.binarytree.TreeNode;

/**
 * @author booleanchoice
 * @version BTLowestCommonAncestor.java, v 0.1 2023年09月04日 19:27 booleanchoice
 */
public class BTLowestCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }

        TreeNode left = findLowestCommonAncestor(root.left, a, b);
        TreeNode right = findLowestCommonAncestor(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}