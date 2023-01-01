package chunzhao;

import leetcode.TreeNode;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) {
            return false;
        }

        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
