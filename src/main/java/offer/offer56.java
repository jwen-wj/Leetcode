package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/11
 */

public class offer56 {
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        int y = 1;
        while ((x & y) == 0) {
            y <<= 1;
        }
        int x1 = 0, x2 = 0;
        for (int num : nums) {
            if ((num & y) == 0) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }
        return new int[]{x1, x2};
    }

    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & 1) == 1) bit[i]++;
                num >>= 1;
            }
        }
        int result = 0, mod = 3;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= bit[31 - i] % mod;
        }
        return result;
    }
}
