import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definición de la estructura del nodo del árbol binario
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInorderTraversal {

    // Método para realizar la travesía en orden del árbol binario
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // Recorremos hacia la izquierda hasta el final
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Procesamos el nodo en la parte superior de la pila
            current = stack.pop();
            result.add(current.val);
            // Ahora, exploramos el subárbol derecho
            current = current.right;
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        List<Integer> inorder = solution.inorderTraversal(root);

        // Imprimir la travesía en orden
        System.out.println(inorder); // Debería imprimir [1, 3, 2]
    }
}


//Given the root of a binary tree, return the inorder traversal of its nodes' values.