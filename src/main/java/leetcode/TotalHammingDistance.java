package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/28
 */

public class TotalHammingDistance {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 8, 10};
        System.out.println(totalHammingDistance_best(nums));
//        int[] nums = new int[]{9156497, 7921475, 1238122};
//        System.out.println(totalHammingDistance(nums));
    }

    public static int totalHammingDistance(int[] nums) {
        int[][] binary = new int[10001][40];
        int result = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int index = 0;
            while (x > 0) {
                int y = x ^ 1;
                if (x > y) {
                    binary[i][index] = 1;
                }
                index++;
                x = x >> 1;
            }
            maxIndex = Math.max(index, maxIndex);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = maxIndex - 1; j >= 0; j--) {
                System.out.print(binary[i][j] + " ");
            }
            System.out.println();
        }

        for (int j = 0; j < maxIndex; j++) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += binary[i][j];
            }
            result = result + (nums.length - sum) * sum;
        }
        return result;
    }

    public static int totalHammingDistance_best (int[] nums){
        int result = 0;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int num : nums) {
                c += (num >> i) & 1;
            }
            result += c * (nums.length - c);
        }
        return result;
    }
}
