package offer02;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/19
 */

public class offer30 {
    Stack<Integer> A, B;
    /** initialize your data structure here. */
    public offer30() {
        A = new Stack();
        B = new Stack();
    }

    public void push(int x) {
        if (B.isEmpty() || x < B.peek()) {
            B.add(x);
        }
        A.add(x);
    }

    public void pop() {
        int a = A.peek();
        int b = B.peek();
        A.pop();
        if (a == b) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
