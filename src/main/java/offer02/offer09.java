package offer02;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/17
 */

public class offer09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public offer09() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()) return -1;
        while (!stack1.isEmpty()) {
            int num = stack1.pop();
            stack2.add(num);
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            int num = stack2.pop();
            stack1.add(num);
        }
        return result;
    }
}
