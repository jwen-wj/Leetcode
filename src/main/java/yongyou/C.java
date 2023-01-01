package yongyou;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/9
 */

public class C {
    public int[] findBuilding (int[] heights) {
        // write code here

        LinkedList<Integer> stack = new LinkedList<>();
        int n = heights.length;
        int ret[] = new int[n];
        for(int i = n-1; i>=0; i--){
            if(stack.isEmpty()){
                ret[i] = 1; // 1是把自己这层楼带上
            }else{
                ret[i] = stack.size()+1; // 1是把自己这层楼带上
            }
            while(!stack.isEmpty() && stack.peekLast() <= heights[i]){
                stack.pollLast();
            }
            stack.offerLast(heights[i]);
        }
        stack = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!stack.isEmpty()){
                ret[i] += stack.size();
            }
            while(!stack.isEmpty() && stack.peekLast() <= heights[i]){
                stack.pollLast();
            }
            stack.offerLast(heights[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        C c = new C();
        int[] heights = new int[]{50, 30, 80, 30, 27, 57};
        for (int res : c.findBuilding(heights)) {
            System.out.printf("%d,", res);
        }
    }
}
