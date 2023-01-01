package shuidi;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/27
 */

public class B {
    public String reverseString (String words) {
        // write code here
        String[] splits = words.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            int len = splits[i].length();
            for (int j = 0; j < len; j++) {
                sb.append(splits[i].charAt(len - j - 1));
            }
            if (i != splits.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // [-128, 127]
        Integer A = 1;
        Integer B = 1;
        System.out.println(A.equals(B));
        System.out.println(A == B);
    }
}
