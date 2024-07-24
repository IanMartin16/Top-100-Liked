import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // Mapa para contar la frecuencia de cada número
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Cola de prioridad (min-heap) para mantener los k elementos más frecuentes
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        // Agregar las entradas del mapa a la cola de prioridad
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();  // Eliminar el elemento menos frecuente
            }
        }

        // Crear el resultado con los k elementos más frecuentes
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        for (int num : result) {
            System.out.print(num + " ");  // Salida esperada: [1, 2]
        }
        System.out.println();
        
        nums = new int[]{1};
        k = 1;
        result = solution.topKFrequent(nums, k);
        for (int num : result) {
            System.out.print(num + " ");  // Salida esperada: [1]
        }
    }
}


//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.