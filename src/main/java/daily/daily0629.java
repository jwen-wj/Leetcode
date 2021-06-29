package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/29
 */

public class daily0629 {
    public String convertToTitle(int columnNumber) {
        StringBuffer result = new StringBuffer();
        while (columnNumber > 0) {
            char ch = (char) ((columnNumber - 1) % 26 + 'A');
            result.append(ch);
            columnNumber = (columnNumber - 1) / 26;
        }
        return result.reverse().toString();
    }
}
