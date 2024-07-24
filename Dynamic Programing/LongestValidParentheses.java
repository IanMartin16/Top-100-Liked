import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.push(-1); // Punto de referencia inicial

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Índice de paréntesis abierto
            } else {
                stack.pop(); // Eliminar el último paréntesis abierto o índice de referencia
                if (stack.isEmpty()) {
                    stack.push(i); // Nuevo punto de referencia
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek()); // Actualizar longitud máxima
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        String s = "(()())";
        int result = solution.longestValidParentheses(s);
        System.out.println("The length of the longest valid parentheses substring is: " + result);
    }
}


//Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
//substring
