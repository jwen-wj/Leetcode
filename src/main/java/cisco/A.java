package cisco;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/20
 */

public class A {
    public static void main(String[] args) {
        B[] bs = new B[10];
        for (int i = 0; i < 10; i++) {
            bs[i] = new B(i);
        }

        C[] cs = new C[10];
        for (int i = 0; i < 10; i++) {
            cs[i] = new C(i + 10, bs[i]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d %d\n",cs[i].y, cs[i].b.x);
        }

        System.out.println();

        Arrays.sort(cs, (c1, c2) -> {
            return c2.y - c1.y;
        });

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d %d\n",cs[i].y, cs[i].b.x);
        }

        System.out.println();
        cs[0].b.x = 11;
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d %d\n",cs[i].y, cs[i].b.x);
        }
    }

    public void quicksort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high){
        int temp = arr[low];
        while (low < high){
            while (low < high && arr[high] > temp) high--;
            arr[high] = arr[low];
            while (low > high && arr[low] <= temp) low++;
            arr[low] = arr[high];
        }
        arr[low] = temp;
        return low;
    }

}

class B {
    int x;
    B(int _x) {
        x = _x;
    }
}

class C {
    int y;
    B b;
    C(int _y, B _b) {
        y = _y;
        b = _b;
    }
}


