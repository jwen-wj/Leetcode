package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/18
 */

public class daily0618 {
    public String smallestGoodBase(String n) {
        int mMax = 64;
        long num = Long.parseLong(n);
        for (int i = 2; i <= mMax; i++) {
            long k = (long) Math.pow(num, 1.0 / i);
            if (k < 2) continue;
            long temp = 0;
            for (int j = 0; j <= i; j++) {
                temp = temp * k + 1;
            }
            if (temp == num) return String.valueOf(k);
        }
        return String.valueOf(num - 1);
    }
}
