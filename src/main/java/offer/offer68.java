package offer;

import leetcode.TreeNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);;
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        return root;
    }
}
