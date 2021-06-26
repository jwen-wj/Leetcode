package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class offer65 {
    public int add(int a, int b) {
        if (b == 0) return a;
        return add(a ^ b, (a & b) << 1);
    }
}
