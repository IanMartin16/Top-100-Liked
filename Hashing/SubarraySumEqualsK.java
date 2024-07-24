import java.util.HashMap;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        // Mapa para almacenar la suma acumulada y su frecuencia
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        // Inicializar con suma acumulada 0
        sumMap.put(0, 1);

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            // Si la diferencia entre la suma acumulada y k existe en el mapa,
            // significa que hay un subarray cuya suma es k
            if (sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum - k);
            }
            // Agregar la suma acumulada actual al mapa
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(solution.subarraySum(nums, k));  // Salida esperada: 2
        
        nums = new int[]{1, 2, 3};
        k = 3;
        System.out.println(solution.subarraySum(nums, k));  // Salida esperada: 2
    }
}


//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

//A subarray is a contiguous non-empty sequence of elements within an array.