package offer;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/2
 */

public class offer6 {

}

class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        int result = -1;
        if (stack1.empty()) {
            return result;
        }
        while (!stack1.empty()) {
            int temp = stack1.peek();
            stack2.push(temp);
            stack1.pop();
        }
        result = stack2.peek();
        stack2.pop();
        while (!stack2.empty()) {
            int temp = stack2.peek();
            stack1.push(temp);
            stack2.pop();
        }
        return result;
    }
}