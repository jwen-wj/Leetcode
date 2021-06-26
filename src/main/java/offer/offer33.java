package offer;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/4
 */

public class offer33 {
    public boolean verifyPostorder1(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int parent = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > parent) {
                return false;
            }
            while (!stack.empty() && stack.peek() > postorder[i]) {
                parent = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
