package com.booleanchoice.exercise.algorithm.binarytree;

import java.util.*;

/**
 * 回型打印二叉树（利用双端队列）
 *
 */
public class PrintByZigZag {

    public void print(TreeNode head) {

        if (head == null) {
            return;
        }
        // 双端队列
        Deque<TreeNode> dq = new LinkedList<>();
        // 打印层数，初始为1
        int level = 1;
        // 打印方向，从左到右为true，从右到左为false
        boolean lr = true;
        // 每层的最后一个节点，第一层即为head，所以此处初始化为head
        TreeNode last = head;
        // 下一层的最后一个节点
        TreeNode nLast = null;
        // 先把第一个节点从头部放入队列
        dq.offerFirst(head);
        // 打印第一层层数信息和方向，并层数加一
        printLevelAndOrientation(level++, lr);
        while (!dq.isEmpty()) {
            // 如果是从左向右打印，则从队列头部弹出节点，
            // 并依次把节点的左子和右子从队列的尾部放入队列中，
            // 没有当然就不用放，并且指定一下下一层的最后一个节点
            if (lr) {
                head = dq.pollFirst();
                if (head.left != null) {
                    dq.offerLast(head.left);
                    nLast = nLast == null ? head.left : nLast;
                }
                if (head.right != null) {
                    dq.offerLast(head.right);
                    nLast = nLast == null ? head.right : nLast;
                }
            }
            // 如果是从右向左打印，则从队列尾部弹出节点，
            // 并依次把节点的右子和左子从队列的头部放入队列中，并且指定一下下一层的最后一个节点
            else {
                head = dq.pollLast();
                if (head.right != null) {
                    dq.offerFirst(head.right);
                    nLast = nLast == null ? head.right : nLast;
                }
                if (head.left != null) {
                    dq.offerFirst(head.left);
                    nLast = nLast == null ? head.left : nLast;
                }
            }
            // 打印当前节点值
            System.out.print(head.val + " ");
            // 打印到了最后的节点，该进行下层循环了，做一些标志的转移
            if (head == last && !dq.isEmpty()) {
                // 改变打印方向
                lr = !lr;
                // 最后一个节点的标志位也赋值成下层的
                last = nLast;
                nLast = null;
                // 换个行
                System.out.println();
                // 输出即将打印的层数和方向
                printLevelAndOrientation(level++, lr);
            }
        }
    }

    /**
     * 打印层数信息和方向
     * @param level
     * @param lr
     */
    public void printLevelAndOrientation(int level, boolean lr) {
        System.out.print("Level" + level + "from");
        System.out.print(lr ? "left to right: " : "right to left: ");
    }

}
