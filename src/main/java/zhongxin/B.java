package zhongxin;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/5
 */

public class B {
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int n = Integer.parseInt(a);
        int[] nums = new int[10];
        dfs(nums, 0, n);
        Node[] nodes = new Node[list.size()];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = list.get(i);
        }
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.h != o2.h) {
                return o1.h - o2.h;
            }
            return o1.m - o2.m;
        });


        StringBuffer result = new StringBuffer();
        result.append("[");
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder();
            Node node = nodes[i];
            sb.append(node.h);
            sb.append(":");
            if (node.m < 10) {
                sb.append("0");
            }
            sb.append(node.m);
            result.append(sb);
            if (i != list.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        System.out.println(result);
    }

    public static void dfs(int[] nums, int x, int cnt) {
        if (x == 10) {
            if (cnt != 0) {
                return;
            }

            if (!valid(nums)) {
                return;
            }
            int h = getH(nums);
            int m = getM(nums);
            list.add(new Node(h, m));

            return;
        }

        nums[x] = 1;
        dfs(nums, x + 1, cnt - 1);
        nums[x] = 0;
        dfs(nums, x + 1, cnt);
    }

    public static int getH(int[] nums) {
        int h = 0;

        for (int i = 0; i < 4; i++) {
            h += nums[i] << i;
        }

        return h;
    }

    public static int getM(int[] nums) {
        int m = 0;

        for (int i = 4; i < 10; i++) {
            m += nums[i] << (i - 4);
        }

        return m;
    }

    public static boolean valid(int[] nums) {
        int h = getH(nums);
        int m = getM(nums);
        if (h > 11) {
            return false;
        }
        return m <= 59;
    }
}

class Node {
    int h;
    int m;

    Node(int _h, int _m) {
        h = _h;
        m = _m;
    }
}
