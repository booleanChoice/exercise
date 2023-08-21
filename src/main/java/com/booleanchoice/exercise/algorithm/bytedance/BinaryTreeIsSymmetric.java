/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.bytedance;

import com.booleanchoice.exercise.algorithm.binarytree.TreeNode;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root， 检查它是否轴对称。
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 *
 */
public class BinaryTreeIsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode a, TreeNode b) {

        if (a == null && b != null || a != null && b == null) {
            return false;
        }

        if (a != null && b != null) {
            if (a.val != b.val) {
                return false;
            }
            if (!check(a.left, b.right)) {
                return false;
            }
            if (!check(a.right, b.left)) {
                return false;
            }
        }
        return true;
    }


}