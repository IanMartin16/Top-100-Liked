public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        // Move all non-zero elements to the front of the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // Fill the remaining positions with zeros
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] nums2 = {0, 0, 1};
        int[] nums3 = {1, 0, 1};

        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1)); // Output: [1, 3, 12, 0, 0]

        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2)); // Output: [1, 0, 0]

        moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3)); // Output: [1, 1, 0]
    }
}


//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

//Note that you must do this in-place without making a copy of the array.