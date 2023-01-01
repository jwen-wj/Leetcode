package codetop;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class codetop18 {
    Map<TreeNode, TreeNode> map = new HashMap();
    Set<Integer> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        map.put(root, null);
        while (p != null) {
            set.add(p.val);
            p = map.get(p);
        }
        while (q != null) {
            if (set.contains(q.val)) return q;
            q = map.get(q);
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right);
        }
    }
}
