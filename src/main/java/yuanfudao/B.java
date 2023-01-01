package yuanfudao;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/26
 */

public class B {
    static Map<Integer, Integer> map;

    public static void getInzis(int num) {
        while (num != 1) {
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    num = num / i;
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    break;
                }
            }    
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            map = new HashMap<>();
            int k = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {
                nums[i] = sc.nextInt();
            }
            sc.nextLine();
            getInzis(k);
            int result = getMin(nums);
            System.out.println(result);
        }
    }

    public static int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int n = nums.length;
        int valid = 0;
        Map<Integer, Integer> added = new HashMap<>();
        while (r < n) {
            int R = nums[r];
            r++;
            if (map.containsKey(R)) {
                added.put(R, added.getOrDefault(R, 0) + 1);
                int M = map.get(R);
                int A = added.get(R);
                if (A == M) {
                    valid++;
                }
            }
            while (valid >= map.size()) {
                int L = nums[l];
                min = Math.min(min, r - l);
                l++;
                if (map.containsKey(L)) {
                    added.put(L, added.get(L) - 1);
                    int M = map.get(L);
                    int A = added.get(L);
                    if (A < M) {
                        valid--;
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
