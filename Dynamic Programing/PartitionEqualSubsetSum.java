import java.util.Arrays;

public class PartitionEqualSubsetSum {
    
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        
        // Si la suma total es impar, no se puede dividir en dos subconjuntos iguales
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int subsetSum = totalSum / 2;
        boolean[] dp = new boolean[subsetSum + 1];
        dp[0] = true; // Podemos obtener suma 0 sin incluir ningún elemento
        
        // Procesar cada número en el array
        for (int num : nums) {
            for (int i = subsetSum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        return dp[subsetSum];
    }
    
    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can partition: " + solution.canPartition(nums)); // Salida esperada: true
        
        nums = new int[]{1, 2, 3, 5};
        System.out.println("Can partition: " + solution.canPartition(nums)); // Salida esperada: false
    }
}


//Given an integer array nums, return true if you can partition the array into two subsets such that the sum of 
//the elements in both subsets is equal or false otherwise.