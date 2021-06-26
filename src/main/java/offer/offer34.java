package offer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/4
 */

public class offer34 {
    List<List<Integer>> combinations = new ArrayList<>();
    LinkedList<Integer> combination = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        addPath(root, target);
        return combinations;
    }

    public void addPath(TreeNode node, int target) {
        if (node == null) return;
        target -= node.val;
        combination.add(node.val);
        if (target == 0 && node.left == null && node.right == null) {
            combinations.add(new ArrayList<>(combination));
        }
        addPath(node.left, target);
        addPath(node.right, target);
        combination.removeLast();
    }
}
