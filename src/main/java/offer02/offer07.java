package offer02;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/19
 */

public class offer07 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode my_build(int[] preorder, int[] inorder,
                             int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) return null;
        int pre_root = map.get(preorder[pre_left]);
        int pre_childTree = pre_root - in_left;
        TreeNode root = new TreeNode(inorder[pre_root]);
        root.left = my_build(preorder, inorder,
                pre_left + 1, pre_left + pre_childTree, in_left, pre_root - 1);
        root.right = my_build(preorder, inorder,
                pre_left + pre_childTree + 1, pre_right, pre_root + 1, in_right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if (n == 0) return null;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return my_build(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
