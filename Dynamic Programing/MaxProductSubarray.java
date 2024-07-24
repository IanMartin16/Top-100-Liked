public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Inicializar los productos máximo, mínimo y global
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int globalMax = nums[0];

        // Iterar sobre el array a partir del segundo elemento
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];

            // Si el número actual es negativo, intercambiar los productos máximo y mínimo
            if (currentNum < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Calcular los nuevos productos máximo y mínimo
            maxProduct = Math.max(currentNum, maxProduct * currentNum);
            minProduct = Math.min(currentNum, minProduct * currentNum);

            // Actualizar el producto máximo global
            globalMax = Math.max(globalMax, maxProduct);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        MaxProductSubarray solution = new MaxProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println("Max product: " + solution.maxProduct(nums)); // Salida esperada: 6

        nums = new int[]{-2, 0, -1};
        System.out.println("Max product: " + solution.maxProduct(nums)); // Salida esperada: 0

        nums = new int[]{-2, 3, -4};
        System.out.println("Max product: " + solution.maxProduct(nums)); // Salida esperada: 24
    }
}


//Given an integer array nums, find a 
//subarray
 //that has the largest product, and return the product.

//The test cases are generated so that the answer will fit in a 32-bit integer.