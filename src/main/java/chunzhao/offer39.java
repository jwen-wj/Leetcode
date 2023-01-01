package chunzhao;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer39 {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int res = -1;
        for (int num : nums) {
            if (votes == 0) {
                res = num;
            }
            votes = votes + (num == res ? 1 : -1);
        }
        return res;
    }
}
