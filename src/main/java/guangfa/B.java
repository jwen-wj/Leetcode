package guangfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/7
 */

public class B {
    List<int[]> result = new ArrayList<>();
    public String printEmail (String str) {
        // write code here
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '@') {
                int x = frontValid(str, i);
                int y = backValid(str, i);
                if (x != -1 && y != -1) {
                    result.add(new int[]{x, y});
                }
            }
        }

        if (result.size() == 0) {
            return "false";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("true");
        for (int[] ints : result) {
            sb.append(" ");
            sb.append(str, ints[0], ints[1] + 1);
        }
        return sb.toString();
    }

    public int frontValid(String str, int i) {
        int j = i - 1;
        while (j >= 0) {
            if (!frontAny(str.charAt(j))) {
                break;
            }
            j--;
        }

        j++;

        if (i - j < 2) {
            return -1;
        }

        while (j <= i - 2) {
            if (!frontNeedBack(str, j)) {
                break;
            }
            j++;
        }
        return j;
    }

    public boolean frontNeedBack(String s, int j) {
        if (j == -1) {
            return true;
        }
        char ch = s.charAt(j);
        return ch == '.' || ch == '-';
    }

    public boolean frontAny(char ch) {
        return Character.isLowerCase(ch) ||
                Character.isUpperCase(ch) ||
                Character.isDigit(ch) ||
                ch == '_' || ch == '.' || ch == '-';
    }

    public int backValid(String str, int i) {
        int j = i + 1;
        while (j < str.length()) {
            if (!backAny(str.charAt(j))) {
                break;
            }
            j++;
        }

        j--;

        int dotCnt = 0;
        for (int k = i + 1; k <= j; k++) {
            if (str.charAt(k) == '.') {
                dotCnt++;
                if (!dotValid(str, k)) {
                    return -1;
                }
            }
        }

        if (dotCnt < 1) {
            return -1;
        }

        return j;
    }

    public boolean backAny(char ch) {
        return Character.isLowerCase(ch) ||
                Character.isUpperCase(ch) ||
                Character.isDigit(ch) ||
                ch == '.';
    }

    public boolean dotValid(String s, int d) {
        int k = d + 1;
        while (k < s.length()) {
            if (!isAZaz(s.charAt(k))) {
                break;
            }
            k++;
        }
        k--;
        return k - d >= 2;
    }

    public boolean isAZaz(char ch) {
        return Character.isLowerCase(ch) ||
                Character.isUpperCase(ch);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        B b = new B();
        System.out.println(b.printEmail(s));
    }
}
