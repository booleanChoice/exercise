package com.booleanchoice.exercise.algorithm.linkedlist;

/**
 * Leetcode 2: 两数相加
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
 * 将两数相加返回一个新的链表。你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class AddTwoNumbers {

    public Node addTwoNumbers(Node l1, Node l2) {
        Node dumyHead = new Node(0);
        Node p = l1, q = l2, curr = dumyHead;
        int carry = 0;  // 进位携带
        while(p != null || q != null) {
            int x = (p != null ) ? p.value : 0; // 需要考虑位数不同的数字相加
            int y = (q != null ) ? q.value : 0;
            int sum = carry + x + y;
            carry = sum / 10;  // 进位携带
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if(p != null ) p = p.next;
            if(q != null ) q = q.next;
        }
        // 加到最后一位
        if(carry > 0) {
            curr.next = new Node(carry);
        }
        return dumyHead.next;
    }

}
