package offer02;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/20
 */

public class offer31 {
    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = popped.length;
        if (n == 0) return true;
        Stack<Integer> popStack = new Stack<>();
        Stack<Integer> pushStack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            popStack.add(popped[i]);
        }
        for (int i = 0; i < n; i++) {
            pushStack.add(pushed[i]);
            while (!popStack.isEmpty() && !pushStack.isEmpty()) {
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
        if (popStack.isEmpty() && pushStack.isEmpty()) return true;
        return false;
    }
}
