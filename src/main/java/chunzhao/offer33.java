package chunzhao;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer33 {
    public boolean verifyPostorder(int[] postorder) {
        // [10,12,13,11,8,9,5,6,3]
        Stack<Integer> stack = new Stack<>();
        int parent = Integer.MAX_VALUE;

        for (int i = postorder.length - 1; i >= 0; i--) {
            int x = postorder[i];
            while (!stack.empty() && x < stack.peek()) {
                parent = stack.pop();
            }
            if (x > parent) {
                return false;
            }
            stack.add(x);
        }

        return true;
    }
}
