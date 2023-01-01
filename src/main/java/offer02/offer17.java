package offer02;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/19
 */

public class offer17 {
    int[] res;
    char[] loop = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] nums;
    int nine, start, n, count;
    public int[] printNumbers(int n) {
        res = new int[(int) Math.pow(10, n) - 1];
        nums = new char[n];
        this.n = n;
        start = n - 1;
        nine = 0;
        count = 0;
        dfs(0);
        return res;
    }

    public void dfs(int k) {
        if (k == n) {
            String s = String.valueOf(nums).substring(start);
            if (!s.equals("0")) res[count++] = Integer.valueOf(s);
            if (n - start == nine) start--;
            return;
        }
        for (char c : loop) {
            if (c == '9') nine++;
            nums[k] = c;
            dfs(k + 1);
        }
        nine--;
    }
}
