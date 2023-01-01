package pinduoduo;

/**
 * @description:
 * @author: jwen
 * @date: 2022/10/20
 */

public class UpList {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = nums[0];
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
