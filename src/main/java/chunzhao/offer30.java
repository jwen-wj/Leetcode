package chunzhao;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer30 {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public offer30() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.add(x);
        }
        stack.add(x);
    }

    public void pop() {
        int a = stack.peek();
        int b = minStack.peek();
        if (a == b) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
