package chunzhao;

import leetcode.TreeNode;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.right) && recur(A.right, B.left);
    }
}
