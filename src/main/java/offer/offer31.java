package offer;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/10
 */

public class offer31 {
    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] poped = new int[]{4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(pushed, poped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, m = pushed.length, j = 0, n = popped.length;
        if (m != n) return false;
        while (i < m || j < n) {
            if (i == m) break;
            stack.add(pushed[i++]);
            while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        if (stack.isEmpty() && i == m && j == n) return true;
        return false;
    }
}
