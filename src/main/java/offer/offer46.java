package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/6
 */

public class offer46 {
    char[] chars;
    public int translateNum(int num) {
        chars = String.valueOf(num).toCharArray();
        int result = dfs(0);
        return result;
    }

    public int dfs(int pos) {
        if (pos == chars.length) {
            return 1;
        }
        int result = 0;
        result += dfs(pos + 1);
        if (pos < chars.length - 1) {
            int pre = (chars[pos] - '0');
            int num = (chars[pos] - '0') * 10 + (chars[pos + 1] - '0');
            int after = (chars[pos + 1] - '0');
            if (pre != num && num != after && num <= 25) result += dfs(pos + 2);
        }
        return result;
    }
}
