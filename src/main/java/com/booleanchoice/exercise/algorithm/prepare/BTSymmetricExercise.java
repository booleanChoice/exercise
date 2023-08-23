/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.prepare;

import com.booleanchoice.exercise.algorithm.binarytree.TreeNode;

/**
 *
 * @author booleanchoice
 * @version BTSymmetric.java, v 0.1 2023年08月23日 11:35 booleanchoice
 */
public class BTSymmetricExercise {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public static boolean check(TreeNode a, TreeNode b) {

        if (a == null && b != null || a != null && b == null) {
            return false;
        }

        if (a == null && b == null) {
            return true;
        }
        if (a.val != b.val) {
            return false;
        }
        if (!check(a.left, b.right)) {
            return false;
        }
        if (!check(a.right, b.left)) {
            return false;
        }
        return true;
    }

}