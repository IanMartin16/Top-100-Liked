import java.util.*;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        
        // Example usage
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        
        // Output the result
        System.out.println(Arrays.toString(result)); // Expected output: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}


//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] 
//is the number of days you have to wait after the ith day to get a warmer temperature. 
//If there is no future day for which this is possible, keep answer[i] == 0 instead.