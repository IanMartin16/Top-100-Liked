import java.util.*;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}


//Given an integer array nums of unique elements, return all possible 
//subsets
 //(the power set).

//The solution set must not contain duplicate subsets. Return the solution in any order.