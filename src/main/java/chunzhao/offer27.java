package chunzhao;

import leetcode.TreeNode;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
