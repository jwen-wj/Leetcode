package kedaxunfei;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/17
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[][] nums1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums1[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        int[][] nums2 = new int[l][k];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < k; j++) {
                nums2[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int[][] result = new int[n][m];

        int h = l / 2;
        int w = k / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cal(result, nums1, nums2, i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j != 0) {
                    System.out.printf(" %d", result[i][j]);
                } else {
                    System.out.printf("%d", result[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void cal(int[][] result, int[][] nums1, int[][] nums2, int i, int j) {
        int n1 = nums1.length;
        int m1 = nums1[0].length;
        int n2 = nums2.length;
        int m2 = nums2[0].length;

        int h = nums2.length / 2;
        int w = nums2[0].length / 2;
        int num = 0;
        for (int k = -h; k <= h; k++) {
            for (int l = -w; l <= w; l++) {
                int num1 = 0;
                int nums1_i = i + k;
                int nums1_j = j + l;
                if (0 <= nums1_i && nums1_i < n1 && 0 <= nums1_j && nums1_j < m1) {
                    num1 = nums1[nums1_i][nums1_j];
                }
                int num2 = 0;
                int nums2_i = h + k;
                int nums2_j = w + l;
                if (0 <= nums2_i && nums2_i < n2 && 0 <= nums2_j && nums2_j < m2) {
                    num2 = nums2[nums2_i][nums2_j];
                }
                num = num + num1 * num2;
            }
        }

        if (num < 0) {
            num = 0;
        }
        if (num > 255) {
            num = 255;
        }

        result[i][j] = num;
    }
}
