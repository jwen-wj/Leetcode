package chunzhao;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        int n = pushed.length;
        for (int i = n - 1; i >= 0; i--) {
            popStack.add(popped[i]);
        }
        for (int i = 0; i < n; i++) {
            pushStack.add(pushed[i]);
            while (!popStack.empty() && !pushStack.empty()) {
                int a = pushStack.peek();
                int b = popStack.peek();
                if (a == b) {
                    pushStack.pop();
                    popStack.pop();
                } else {
                    break;
                }
            }
        }
        if (!popStack.empty() || !pushStack.empty()) {
            return false;
        }

        return true;
    }
}
