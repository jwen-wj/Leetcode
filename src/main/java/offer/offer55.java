package offer;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/10
 */

public class offer55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return result;
    }

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
