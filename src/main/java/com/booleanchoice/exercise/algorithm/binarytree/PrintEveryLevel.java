package com.booleanchoice.exercise.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 逐层打印二叉树节点，要求带上层数信息
 */
public class PrintEveryLevel {

    public void print(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node last = head;
        Node nLast = null;
        int level = 1;
        System.out.print("Level " + level++ + " : ");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }
            if (head == last && !queue.isEmpty()) {
                System.out.print("\nLevel " + level++ + " : ");
                last = nLast;
            }
        }
    }

}
