package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/30
 */

public class MyBinTree {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode find(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        int root_val = preorder[pre_left];
        int root_index = map.get(root_val);
        TreeNode root = new TreeNode(root_val);
        int size_left_subtree = root_index - in_left;

        root.left = find(preorder, inorder, pre_left + 1, pre_left + size_left_subtree, in_left, root_index - 1);
        root.right = find(preorder, inorder, pre_left + size_left_subtree + 1, pre_right, root_index + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return find(preorder, inorder, 0, len - 1, 0, len - 1);
    }
}
