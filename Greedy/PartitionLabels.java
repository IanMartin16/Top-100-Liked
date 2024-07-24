import java.util.*;

public class PartitionLabels {
    
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];
        
        // Primera pasada: encontrar la última posición de cada carácter
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Segunda pasada: particionar la cadena usando la información de las últimas posiciones
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = solution.partitionLabels(s);
        System.out.println(result);  // Salida esperada: [9, 7, 8]
    }
}


//You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

//Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

//Return a list of integers representing the size of these parts.