package offer;

import leetcode.TreeNode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/10
 */

public class offer54 {
    Queue<Integer> queue = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();
    int size;
    public int kthLargest(TreeNode root, int k) {
        size = k;
        search(root);
        return queue.peek();
    }

    public void search(TreeNode root) {
        if (root == null) return;
        if (queue.size() < size) {
            queue.offer(root.val);
        } else {
            if (root.val > queue.peek()) {
                queue.poll();
                queue.offer(root.val);
            }
        }
        set.add(root.val);
        search(root.left);
        search(root.right);
    }
}
