package chunzhao;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2022/11/22
 */

public class offer07 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode dfs(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        int root_val = preorder[pre_left];
        TreeNode root = new TreeNode(root_val);
        int idx = map.get(root_val);
        int tree_size = idx - in_left;
        root.left = dfs(preorder, inorder, pre_left + 1, pre_left + tree_size, in_left, idx - 1);
        root.right = dfs(preorder, inorder, pre_left + tree_size + 1, pre_right, idx + 1, in_right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }
}
