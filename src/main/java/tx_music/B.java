package tx_music;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/8
 */

public class B {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode dfs(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder, int pre_left, int pre_right,
                        int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        int root_val = preOrder.get(pre_left);
        int idx = map.get(root_val);
        //    1
        //  2    3
        //4  5  6  7
        // pre: 1 2 4 5 3 6 7
        // in:  4 2 5 1 6 3 7

        //  1
        // 2 3
        // pre: 1 2 3
        // in: 2 1 3
        TreeNode root = new TreeNode(root_val);
        int left_size = idx - in_left;
        root.left = dfs(preOrder, inOrder, pre_left + 1, pre_left + left_size, in_left, idx - 1);
        root.right = dfs(preOrder, inOrder, pre_left + left_size + 1, pre_right, idx + 1, in_right);

        return root;
    }

    public ArrayList<TreeNode> getBinaryTrees (ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        for (int i = 0; i < inOrder.size(); i++) {
            map.put(inOrder.get(i), i);
        }
        TreeNode root = dfs(preOrder, inOrder, 0, 0, 0, 0);
        ArrayList<TreeNode> result = new ArrayList<>();
        result.add(root);
        return result;
    }

    public static void main(String[] args) {
        B b = new B();
        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        pre.add(1);
        pre.add(2);
        ArrayList<Integer> in = new ArrayList<>();
        in.add(2);
        in.add(1);
        in.add(3);
        b.getBinaryTrees(pre, in);
    }
}
