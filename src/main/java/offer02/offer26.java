package offer02;

import leetcode.TreeNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/19
 */

public class offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && ((cur(A, B))
                || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean cur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return cur(A.left, B.left) && cur(A.right, B.right);
    }
}
