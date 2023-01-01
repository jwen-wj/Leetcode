package RedBook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/28
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int id = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += nums[i][j];
            }
            nodes[i] = new Node(i + 1, sum);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.sum != o2.sum) {
                    return o2.sum - o1.sum;
                }
                return o1.id - o2.id;
            }
        });
        for (int i = 0; i < n; i++) {
            if (nodes[i].id == id) {
                System.out.println(i + 1);
            }
        }
    }

    static class Node {
        int id;
        int sum;

        Node(int _id, int _sum) {
            id = _id;
            sum = _sum;
        }
    }
}
