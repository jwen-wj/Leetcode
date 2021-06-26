package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class GenerateParenthesis {
    public static void main(String[] args) {
        for (String result : generateParenthesis(3)) {
            System.out.println(result);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        dfs(combinations, new StringBuffer(), 0, n, 0, 0);
        return combinations;
    }

    public static void dfs(List<String> combinations, StringBuffer result, int index, int n, int leftCount, int rightCount) {
        if (index == 2 * n) {
            combinations.add(result.toString());
            return;
        }
        if (leftCount < n) {
            result.append('(');
            dfs(combinations, result, index + 1, n, leftCount + 1, rightCount);
            result.deleteCharAt(index);
        }
        if (rightCount < leftCount) {
            result.append(')');
            dfs(combinations, result, index + 1, n, leftCount, rightCount + 1);
            result.deleteCharAt(index);
        }
    }
}
