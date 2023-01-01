package codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/24
 */

public class codetop22 {
    boolean[] exist;
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        exist = new boolean[nums.length];
        dfs(nums, 0);
        return lists;
    }

    public void dfs(int[] nums, int k) {
        if (k == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!exist[i]) {
                exist[i] = true;
                list.add(nums[i]);
                dfs(nums, k + 1);
                list.remove(list.size() - 1);
                exist[i] = false;
            }
        }
    }
}
