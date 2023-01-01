package keep;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/30
 */

public class C {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(search(nums, 0, 3, 4));
    }

    public static int search(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid + 1;
            }
        }
        return -1;
    }
}
