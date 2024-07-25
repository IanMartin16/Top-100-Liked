import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < heights.length) {
            // Si la pila está vacía o la barra actual es mayor que la barra en el índice de la cima de la pila
            if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
                stack.push(index++);
            } else {
                // Pop the top
                int topOfStack = stack.pop();
                // Calcula el área con la altura de la barra del índice topOfStack
                int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                // Actualiza el área máxima
                maxArea = Math.max(maxArea, area);
            }
        }

        // Ahora procesa los índices restantes en la pila
        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + solution.largestRectangleArea(heights1)); // Output: 10
        
        int[] heights2 = {2, 4};
        System.out.println("Largest Rectangle Area: " + solution.largestRectangleArea(heights2)); // Output: 4
    }
}


//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.