import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        backtrack(s, 0, currentPartition, result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentPartition.add(s.substring(start, end + 1));
                backtrack(s, end + 1, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partitions = partition(s);
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }
}


//Given a string s, partition s such that every 
//substring
 //of the partition is a 
//palindrome
 //Return all possible palindrome partitioning of s.