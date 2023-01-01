package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/12
 */

public class daily0712 {
    public int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length - 1;
        int n = citations.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int h = n - mid;
            if (citations[mid] >= h) r = mid - 1;
            else l = mid;
        }
        return n - l;
    }
}
