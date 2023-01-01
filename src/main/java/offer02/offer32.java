package offer02;

import leetcode.TreeNode;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/20
 */

public class offer32 {
    /**
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            res[i++] = num;
        }
        return res;
    }*/

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (reverse) {
                List<Integer> reversedList = new ArrayList<>();
                int[] temp = new int[list.size()];
                int i = 0;
                for (Integer num : list) {
                    temp[i++] = num;
                }
                for (int j = temp.length - 1; j >= 0; j--) {
                    reversedList.add(temp[j]);
                }
                lists.add(reversedList);
            } else {
                lists.add(list);
            }
            reverse = !reverse;
        }
        return lists;
    }
}
