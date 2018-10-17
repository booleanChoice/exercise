package com.booleanchoice.exercise.linkedlist;

/**
 * 合并两个有序的单链表
 */
public class MergeTwoSortedSingleLinkedList {

    /*
        public class Node {

            public int value;
            public Node next;

            public Node(int data) {
                this.value = data;
            }

        }
     */

    public Node merge(Node head1, Node head2) {
        // 取合并后的head节点为两链表头结点值较小的一方
        Node head = head1.value < head2.value ? head1 : head2;
        // cur1取被作为head节点的那条链表，称为链表1，cur2作为插入cur1的链表，称为链表2
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        // cur1前面的节点
        Node pre = null;
        // cur2右移所用的中间变量
        Node next = null;
        while (cur1 != null && cur2 != null) {
            // 如果cur1不大于cur2，pre被赋值成cur1，并且cur1右移，要注意，第一次一定会执行这段代码
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            }
            // 否则的话，cur2的值小于cur1的值，
            // 把cur2插入到cur1之前，并且把cur2赋值成pre，因为此时cur1的前面节点变味了cur2，然后cur2右移
            else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        // 如果链表1先走完，此时cur1=null，pre为链表1最后一个节点，则pre直接指向cur2就可以，
        // 否则，链表2走完，pre继续指cur1，最终的head已经是有序的了
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

}
