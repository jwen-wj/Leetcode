package chunzhao;

import leetcode.Node;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer36 {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        head = null;
        pre = null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        } else {
            head = root;
        }
        pre = root;
        dfs(root.right);
    }
}
