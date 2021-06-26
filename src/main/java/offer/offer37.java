package offer;

import leetcode.ListNode;
import leetcode.TreeNode;

import java.awt.*;
import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/4
 */

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

public class offer37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root_left = new TreeNode(2);
        TreeNode root_right = new TreeNode(3);
        root.left = root_left;
        root.right = root_right;

        TreeNode root_right_left = new TreeNode(2);
        TreeNode root_right_right = new TreeNode(4);
        root_right.left = root_right_left;
        root_right.right = root_right_right;

        TreeNode root_right_left_left = new TreeNode(3);
        TreeNode root_right_left_right = new TreeNode(1);
        root_right_left.left = root_right_left_left;
        root_right_left.right = root_right_left_right;

        System.out.println(serialize(root));

    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuffer result = new StringBuffer("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("null,");
                continue;
            }
            result.append(node.val);
            result.append(',');
            queue.offer(node.left);
            queue.offer(node.right);
        }
        result.setCharAt(result.length() - 1, ']');
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == "[]") return null;
        String[] split = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(split[i])) {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(split[i])) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
