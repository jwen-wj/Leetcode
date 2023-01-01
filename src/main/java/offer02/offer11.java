package offer02;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/17
 */

public class offer11 {
    public int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) return numbers[i];
        }
        return numbers[0];
    }
}
