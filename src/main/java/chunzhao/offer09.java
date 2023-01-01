package chunzhao;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2022/11/22
 */

public class offer09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public offer09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.empty()) {
            return stack2.pop();
        }
        if (stack1.empty()) {
            return -1;
        }
        while (!stack1.empty()) {
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }
}
