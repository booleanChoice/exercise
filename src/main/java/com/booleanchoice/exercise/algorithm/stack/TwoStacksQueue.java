package com.booleanchoice.exercise.algorithm.stack;

import java.util.Stack;

/**
 * 用两个栈实现队列的功能
 * 思路：两个栈，一个是专门做入栈的栈，另一个是专门做出栈的栈，
 *      组装出栈的栈只需入栈的栈做弹栈操作时同时把元素压入做出栈的栈，
 *      此时出栈的栈做弹出操作时顺序就与队列一样了
 * 注意：每次从出栈的栈取元素时需重新组装出栈的栈
 *
 */
public class TwoStacksQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        assembleStackPop();
        return stackPop.pop();
    }

    public int peek() {
        assembleStackPop();
        return stackPop.peek();
    }

    /**
     * 组装弹出栈
     */
    private void assembleStackPop() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }
}
