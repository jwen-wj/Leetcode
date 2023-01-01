package chunzhao;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer34 {
    List<List<Integer>> combines = new ArrayList<>();
    LinkedList<Integer> combine = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return combines;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        target -= root.val;
        combine.add(root.val);

        if (target == 0 && root.left == null && root.right == null) {
            List<Integer> temp = new ArrayList<>(combine);
            combines.add(temp);
        }

        dfs(root.left, target);
        dfs(root.right, target);
        combine.removeLast();
    }
}
