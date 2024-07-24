import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int remainingSum, int start) {
        if (combination.size() == k && remainingSum == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (combination.size() >= k || remainingSum < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            combination.add(i);
            backtrack(result, combination, k, remainingSum - i, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        List<List<Integer>> result = combinationSum3(k, n);
        System.out.println(result);
    }
}


//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.