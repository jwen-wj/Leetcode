package Competition0820;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/20
 */

public class A {
    public int minimumRecolors(String blocks, int k) {
        int[] prefix = new int[blocks.length() + 1];
        for (int i = 1; i <= blocks.length(); i++) {
            prefix[i] = prefix[i - 1] + (blocks.charAt(i - 1) == 'B' ? 1 : 0);
        }
        int min = blocks.length();
        for (int i = 0; i <= blocks.length() - k; i++) {
            min = Math.min(min, k - (prefix[i + k] - prefix[i]));
        }

        return min;
    }
}
