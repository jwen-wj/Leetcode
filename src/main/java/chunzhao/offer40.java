package chunzhao;

import java.util.Random;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/11
 */

public class offer40 {
    public static void main(String[] args) {
        offer40 o = new offer40();
        int[] arr = new int[]{3, 2, 1};
        int[] res = o.getLeastNumbers(arr, 3);
        Utils.printArr(res);
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        getLeft(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    public void getLeft(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int middle = quickSort(arr, left, right);
        if (middle == k) {
            return;
        }

        if (middle < k) {
            getLeft(arr, middle + 1, right, k);
        } else {
            getLeft(arr, left, middle - 1, k);
        }
    }

    public int quickSort(int[] arr, int left, int right) {
        int idx = new Random().nextInt(right - left ) + 1 + left;
        int pivot = arr[idx];
        swap(arr, left, idx);
        int pre = left;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, pre, left);
        return left;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
