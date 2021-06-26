package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class CanEat {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int length = candiesCount.length;
        long[] sum = new long[length];
        boolean[] answer = new boolean[queries.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int favoriteType = queries[i][0];
            int favoriteDay = queries[i][1];
            int dailyCap = queries[i][2];
            long min = favoriteDay + 1;
            long max= (long) (favoriteDay + 1) * dailyCap;
            boolean eatable = false;
            long right = sum[favoriteType];
            long left = sum[favoriteType] - candiesCount[favoriteType];
            if (min <= right && left < max) {
                eatable = true;
            }
            answer[i] = eatable;
        }
        return answer;
    }
}
