package tx_music;

import leetcode.TreeNode;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/8
 */

public class C {
    final long mod = (long) (1e9 + 7);
    public int getTreeSum (TreeNode tree) {
        // write code here
        return (int) dfs(tree);
    }

    public long dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long left = dfs(root.left) % mod;
        long right = dfs(root.right) % mod;
        long max = Math.max(left, right) % mod;
        return (max * 2 + 1) % mod;
    }
}

//     1
//   1    1
// 1  1  1  1



//   1e9 + 6    1e9+10 % mod = 3