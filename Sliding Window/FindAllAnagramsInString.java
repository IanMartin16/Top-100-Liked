import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26]; // Contador de caracteres para p
        int[] sCount = new int[26]; // Contador de caracteres para la ventana en s

        // Inicializar el contador para p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int pLen = p.length();
        int sLen = s.length();

        // Inicializar la primera ventana
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // Comprobar si la primera ventana es un anagrama
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Mover la ventana a través de s
        for (int i = pLen; i < sLen; i++) {
            // Añadir el siguiente carácter en la ventana
            sCount[s.charAt(i) - 'a']++;
            // Quitar el primer carácter de la ventana anterior
            sCount[s.charAt(i - pLen) - 'a']--;
            // Comprobar si la ventana actual es un anagrama
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        
        System.out.println(result); // Output: [0, 6]
        
        s = "abab";
        p = "ab";
        result = solution.findAnagrams(s, p);
        
        System.out.println(result); // Output: [0, 1, 2]
    }
}


//Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.