package tx_music;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/8
 */

public class A {
    public int minOperations (String str) {
        // write code here
        int[] a = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'a';
            a[num]++;
        }

        // 剩下res个空位
        int res = 26;
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                res--;
            }
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                int num = a[i] / 2;
                if (res > num) {
                    res -= num;
                    result += num;
                } else {
                    int size = res * 2;
                    res = 0;
                    // 3 1
                    // 2 1
                    // 4 1
                    if (a[i] - size > 1) {
                        result = result + res + (a[i] - size - 1);
                    } else {
                        result = result + res + (a[i] - size);
                    }
                }
            }
        }

        return result;
    }
}
// 1000
//
