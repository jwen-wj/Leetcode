package shuidi;

import leetcode.TreeNode;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/27
 */

public class A {
    public TreeNode jsondiff (TreeNode oldJson, TreeNode newJson) {
        // write code here
        if (oldJson == null && newJson == null) {
            return null;
        }

        if (oldJson == null) {
            return newJson;
        }
        if (newJson == null) {
            return oldJson;
        }

        TreeNode root = newJson;

        root.left = jsondiff(oldJson.left, newJson.left);
        root.right = jsondiff(oldJson.right, newJson.right);

        if (root.left == null && root.right == null && oldJson.val == newJson.val) {
            return null;
        }

        return root;
    }
}
