package codetop;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class codetop08 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) continue;
            int target = -nums[first];
            int third = n - 1;
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) continue;
                while (nums[third] + nums[second] > target && third > second) {
                    third--;
                }
                if (second == third) break;
                if (nums[third] + nums[second] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
