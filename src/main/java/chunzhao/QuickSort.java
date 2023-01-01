package chunzhao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @description:
 * @author: jwen
 * @date: 2022/11/22
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 5, 8, 6, 4};
        QuickSort q = new QuickSort();
        q.quickSortQueue(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int idx = partition(arr, low, high);
        quickSort(arr, low, idx - 1);
        quickSort(arr, idx + 1, high);
    }

    public void quickSortQueue(int[] arr, int low, int high) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{low, high});
        while (!queue.isEmpty()) {
            int[] nodes = queue.poll();
            if (nodes[0] >= nodes[1]) {
                continue;
            }
            int idx = partition(arr, nodes[0], nodes[1]);
            queue.add(new int[]{nodes[0], idx - 1});
            queue.add(new int[]{idx + 1, nodes[1]});
        }
    }

    public int partition(int[] arr, int low, int high) {
        int idx = new Random().nextInt(high - low) + 1 + low;
        int pivot = arr[idx];
        swap(arr, low, idx);
        int pre = low;
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            while (low < high && arr[low] <= pivot) low++;
            if (low < high) {
                swap(arr, low, high);
            }
        }
        swap(arr, pre, low);
        return low;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
