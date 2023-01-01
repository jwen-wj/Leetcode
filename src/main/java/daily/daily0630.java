package daily;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/30
 */

public class daily0630 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuffer sb = new StringBuffer("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val + ",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;
        String[] split = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(split[index])) {
                node.left = new TreeNode(Integer.parseInt(split[index]));
                queue.offer(node.left);
            }
            index++;
            if (!"null".equals(split[index])) {
                node.right = new TreeNode(Integer.parseInt(split[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}
