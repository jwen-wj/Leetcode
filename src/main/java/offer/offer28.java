package offer;

import leetcode.ListNode;
import leetcode.TreeNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/4
 */

public class offer28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
