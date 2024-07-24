import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        // Use a map to store the prefix sum frequencies
        Map<Long, Integer> prefixSum = new HashMap<>();
        // Initialize the prefix sum map with 0 sum (base case)
        prefixSum.put(0L, 1);
        // Call the recursive DFS method
        return dfs(root, 0L, targetSum, prefixSum);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSum) {
        if (node == null) {
            return 0;
        }

        // Update the current sum with the value of the current node
        currentSum += node.val;

        // Calculate the number of valid paths ending at the current node
        int count = prefixSum.getOrDefault(currentSum - targetSum, 0);

        // Update the prefix sum map with the current sum
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        // Recurse for left and right children
        count += dfs(node.left, currentSum, targetSum, prefixSum);
        count += dfs(node.right, currentSum, targetSum, prefixSum);

        // Restore the prefix sum map for the parent node (backtrack)
        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create the test case tree
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);

        int targetSum = 2;
        int result = solution.pathSum(root, targetSum);
        System.out.println("Number of paths with sum " + targetSum + ": " + result);
    }
}


//Given the root of a binary tree and an integer targetSum, 
//return the number of paths where the sum of the values along the path equals targetSum.

//The path does not need to start or end at the root or a leaf, 
//but it must go downwards (i.e., traveling only from parent nodes to child nodes).