package qianxin;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/25
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] splits = s.split(",");
        int n = splits.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        int leftMax = nums[0];
        int rightMax = nums[n - 1];
        int left = 0;
        int right = n - 1;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, nums[left]);
            rightMax = Math.max(rightMax, nums[right]);
            int num = Math.min(leftMax, rightMax) * (right - left);
            res = Math.max(res, num);
            if (leftMax < rightMax) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(res);
    }
}
