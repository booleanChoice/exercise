/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.booleanchoice.exercise.algorithm.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author booleanchoice
 * @version DFS.java, v 0.1 2023年08月23日 14:12 booleanchoice
 */
public class DFS {

    /**
     * 非递归实现
     * @param treeNode
     * @return
     */
    public List<Integer> dfs(TreeNode treeNode) {
        List<Integer> rs = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 入栈先右后左
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            rs.add(node.val);
        }
        return rs;
    }

    /**
     * 递归实现
     */
    public List<Integer> dfsRecursion(TreeNode treeNode) {
        List<Integer> rs = new LinkedList<>();
        dfsRecursion(rs, treeNode);
        return rs;
    }

    public void  dfsRecursion(List<Integer> rs, TreeNode treeNode) {
        if (treeNode == null)
            return;
        rs.add(treeNode.val);
        dfsRecursion(rs, treeNode.left);
        dfsRecursion(rs, treeNode.right);
    }

}