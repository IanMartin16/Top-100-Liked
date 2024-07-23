import java.util.*;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Inicializar la cola con todas las naranjas podridas y contar las naranjas frescas
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        // Si no hay naranjas frescas, devolver 0
        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Realizar BFS
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // Verificar todas las direcciones
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // Si la nueva celda está dentro de los límites y contiene una naranja fresca
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }
        }

        // Si quedan naranjas frescas, devolver -1
        return freshOranges == 0 ? minutes - 1 : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        
        int result = solution.orangesRotting(grid);
        System.out.println("El número mínimo de minutos para que todas las naranjas frescas se pudran es: " + result);
    }
}


//You are given an m x n grid where each cell can have one of three values:

//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.