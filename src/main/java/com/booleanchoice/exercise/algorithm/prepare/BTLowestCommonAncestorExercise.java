/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import com.booleanchoice.exercise.algorithm.binarytree.TreeNode;

/**
 * @author booleanchoice
 * @version BTLowestCommonAncestorExercisie.java, v 0.1 2023年09月05日 17:15 booleanchoice
 */
public class BTLowestCommonAncestorExercise {

    public static void main(String[] args) {

    }

    public static TreeNode solution(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }
        TreeNode l = solution(root.left, a, b);
        TreeNode r = solution(root.right, a, b);

        if (l != null && r != null) {
            return root;
        } else if (l == null) {
            return r;
        } else {
            return l;
        }
    }

}