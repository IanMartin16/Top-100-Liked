import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        // Primera fila siempre es [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        // Construir cada fila
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();

            // Primer elemento siempre es 1
            row.add(1);

            // Construir los elementos intermedios
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Último elemento siempre es 1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        int numRows = 5;
        List<List<Integer>> result = pt.generate(numRows);
        
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}


//Given an integer numRows, return the first numRows of Pascal's triangle.

//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown: