package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/3
 */

public class offer17 {
    int nine = 0, count = 0, start, len;
    char[] ch = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuffer res = new StringBuffer();
    int[] answer;

    public int[] printNumbers(int n) {
        int size = (int) Math.pow(10, n);
        answer = new int[size - 1];
        start = n - 1;
        len = n;
        dfs(0);
        return answer;
    }

    public void dfs(int k) {
        if (k == len) {
            String s = res.toString().substring(start);
            if (s.charAt(0) != '0') {
                answer[count++] = Integer.parseInt(s);
            }
            if(len - start == nine) {
                start--;
            }
            return;
        }
        for (char c : ch) {
            if (c == '9') {
                nine++;
            }
            res.append(c);
            dfs(k + 1);
            res.deleteCharAt(res.length() - 1);
        }
        nine--;
    }
}
