import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        // Step 1: Find the first position decreasing
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // Step 2: Find the smallest number greater than nums[i] from the end
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap nums[i] and nums[j]
            swap(nums, i, j);
        }
        
        // Step 3: Reverse the sublist from i + 1 to the end
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.println("Next permutation: " + Arrays.toString(nums1)); // Output: [1, 3, 2]
        
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.println("Next permutation: " + Arrays.toString(nums2)); // Output: [1, 2, 3]
        
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.println("Next permutation: " + Arrays.toString(nums3)); // Output: [1, 5, 1]
        
        int[] nums4 = {1};
        solution.nextPermutation(nums4);
        System.out.println("Next permutation: " + Arrays.toString(nums4)); // Output: [1]
    }
}


//A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

//For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
//The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, 
//if all the permutations of the array are sorted in one container according to their lexicographical order, 
//then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, 
//the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).