import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove elements not within the sliding window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // Remove elements from the deque that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add current element at the end of deque
            deque.offer(i);
            
            // Start adding results to the array once the first window is completed
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        
        System.out.println(Arrays.toString(result)); // Output: [3, 3, 5, 5, 6, 7]
    }
}


//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
//You can only see the k numbers in the window. Each time the sliding window moves right by one position.

//Return the max sliding window.