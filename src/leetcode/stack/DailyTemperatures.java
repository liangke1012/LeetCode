package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
         int length = temperatures.length;
         int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int pre = stack.pop();
                ans[pre] = i -pre;
            }
            stack.push(i);
        }
        return ans;
    }
}
