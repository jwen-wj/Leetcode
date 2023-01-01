package codetop;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/29
 */

public class codetop31 {
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        int left = 0, right = n - 1;
        int leftMax = -1, rightMax = -1;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}
