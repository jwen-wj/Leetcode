package daily;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/25
 */

public class daily0625 {
    Queue<String> queue = new LinkedList<>();
    Set<String> exists = new HashSet<>();
    Set<String> barrier = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return -1;
        for (String deadend : deadends) {
            barrier.add(deadend);
        }
        queue.offer("0000");
        exists.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String next : addStatus(status)) {
                    if (!exists.contains(next) && !barrier.contains(next)) {
                        if (next.equals(target)) {
                            return step;
                        }
                        exists.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    public char numAdd(char num) {
        return num == '9' ? '0' : (char)(num + 1);
    }

    public char numMinus(char num) {
        return num == '0' ? '9' : (char)(num - 1);
    }

    public List<String> addStatus(String status) {
        List<String> result = new ArrayList<>();
        char[] now = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char ch = now[i];
            now[i] = numAdd(ch);
            result.add(new String(now));
            now[i] = numMinus(ch);
            result.add(new String(now));
            now[i] = ch;
        }
        return result;
    }
}
