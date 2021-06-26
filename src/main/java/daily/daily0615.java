package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/15
 */

public class daily0615 {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length;
        int m = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (r - l == 2) break;
            if (arr[m - 1] < arr[m] && arr[m] < arr[m + 1]) l = m;
            else if (arr[m - 1] > arr[m] && arr[m] > arr[m + 1]) r = m;
            else break;
        }
        return m;
    }
}
