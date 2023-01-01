package wangyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/4
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 1; i <= n; i++) {
            double x = Math.pow(n, i);
            double y = Math.pow(i, i);
            int g = gcd((int) x, (int) y);
            int _x = (int) x / g;
            int _y = (int) y / g;
            double num = (double)_x / _y;
            nodes[i - 1] = new Node(_x, _y, num);
        }
        Arrays.sort(nodes, Comparator.comparingDouble(o -> o.num));
        System.out.printf("%d %d", nodes[n - 1].x, nodes[n - 1].y);
    }

    public static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    static class Node {
        int x, y;
        double num;

        Node(int _x, int _y, double _num) {
            x = _x;
            y = _y;
            num = _num;
        }
    }
}


