package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, left.right) && check(right.left, right.right);
    }
}
