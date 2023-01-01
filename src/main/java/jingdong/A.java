package jingdong;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/3
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                result += cntLen(s.substring(i, j + 1));
            }
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int left_cnt = 0;
        int right_cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left_cnt++;
            }
            left[i] = left_cnt;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right_cnt++;
            }
            right[i] = right_cnt;
        }
        for (int i = 0; i < n; i++) {

        }
//        int result = dfs(s, n, new StringBuffer(), 0);
        System.out.println(result);
    }

    public static int cntLen(String s) {
        int n = s.length();
        int cnt = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    cnt += 2;
                }
            }
        }
        return cnt;
    }
}
