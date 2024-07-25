class Solution {
    public int findDuplicate(int[] nums) {
        // Fase 1: Encontrar la intersección de la tortuga y la liebre
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Fase 2: Encontrar la entrada del ciclo
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(solution.findDuplicate(nums1)); // Output: 2
        
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(solution.findDuplicate(nums2)); // Output: 3
    }
}


//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

//There is only one repeated number in nums, return this repeated number.

//You must solve the problem without modifying the array nums and uses only constant extra space.