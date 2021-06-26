package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/11
 */

public class offer57 {
    public static void main(String[] args) {
        findContinuousSequence(9);
    }
    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1, j = 1;
        int m = target / 2  + 1;
        int sum = 0;
        while (j <= m) {
            if (sum + j < target) {
                sum = sum + j;
                j++;
            }
            else if (sum + j > target) {
                sum = sum - i;
                i++;
            }
            else if (sum + j == target){
                int[] arr = new int[j - i + 1];
                int len = 0;
                for (int k = i; k <= j; k++) {
                    arr[len++] = k;
                }
                sum = sum + j;
                j++;
                res.add(arr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
