package offer;

import leetcode.TreeNode;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/4
 */

public class offer32 {

    public int[] levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Vector<Integer> vector = new Vector<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            vector.add(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        int[] result = new int[vector.size()];
        int len = 0;
        for (Integer integer : vector) {
            result[len++] = integer;
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int pre = -1;
        int level = 0;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, level);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level = map.get(node);
            if (level != pre) {
                lists.add(new ArrayList<>());
                map.put(root, level);
                lists.get(level).add(node.val);
                pre++;
            } else {
                lists.get(level).add(node.val);
            }
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, level + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, level + 1);
            }
        }
        return lists;
    }

    public List<List<Integer>> levelOrder2_better(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            lists.add(temp);
        }
        return lists;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        int dir = 1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (dir == 1) temp.addFirst(node.val);
                else temp.addLast(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            dir = -dir;
            lists.add(temp);
        }
        return lists;
    }
}
