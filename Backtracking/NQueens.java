import java.util.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(solutions, board, 0);
        return solutions;
    }

    private static void backtrack(List<List<String>> solutions, char[][] board, int row) {
        if (row == board.length) {
            solutions.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(solutions, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the diagonal from top left to bottom right
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the diagonal from top right to bottom left
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4; // puedes cambiar n para probar otros tamaños de tablero
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}


//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

//Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, 
//respectively.