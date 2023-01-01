package Competition0820;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/20
 */

public class C {
    public static void main(String[] args) {
        String s = "dztz";
        int[][] shift = new int[][]{{0, 0, 0}, {1, 1, 1}};
        System.out.println(shiftingLetters(s, shift));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length() + 1];
        diff[0] = s.charAt(0) - 'a';
        for (int i = 1; i < s.length(); i++) {
            diff[i] = s.charAt(i) - s.charAt(i - 1);
        }

        for (int[] shift : shifts) {
            int left = shift[0];
            int right = shift[1];
            int dir = shift[2];
            if (dir == 1) {
                diff[left]++;
                diff[right + 1]--;
            } else {
                diff[left]--;
                diff[right + 1]++;
            }
        }
        int[] result = new int[s.length()];
        result[0] = (diff[0] + 26 * 10000) % 26;
        for (int i = 1; i < s.length(); i++) {
            result[i] = (result[i - 1] + diff[i] + 26 * 10000) % 26;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = (char) ('a' + result[i]);
            sb.append(ch);
        }

        return sb.toString();
    }



}
