package offer;

import leetcode.TreeNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/3
 */

public class offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);
        return root;
    }
}
