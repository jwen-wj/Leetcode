package chunzhao;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/10
 */

public class offer17 {
    char[] loop = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int nine;
    int start;
    int n;
    int count;
    int[] res;
    char[] nums;

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        nums = new char[n];
        start = n - 1;
        nine = 0;
        count = 0;
        dfs(0);
        return res;
    }

    public static void main(String[] args) {
        offer17 o = new offer17();
        o.printNumbers(3);
    }

    public void dfs(int k) {
        if (k == n) {
            String s = String.valueOf(nums).substring(start);
            if (!"0".equals(s)) {
                res[count++] = Integer.parseInt(s);
            }
            if (n - start == nine) {
                start--;
            }
            return;
        }

        for (char c : loop) {
            if (c == '9') {
                nine++;
            }
            nums[k] = c;
            dfs(k + 1);
        }
        nine--;
    }
}
