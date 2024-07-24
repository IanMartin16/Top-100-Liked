// Definición de la estructura del nodo del árbol binario
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class BinaryTreeDiameter {

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Calcular el diámetro que pasa por el nodo actual
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Altura del nodo actual
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeDiameter solution = new BinaryTreeDiameter();
        int diameter = solution.diameterOfBinaryTree(root);

        // Imprimir el diámetro del árbol
        System.out.println("Diameter of the tree: " + diameter); // Debería imprimir 3
    }
}


//Given the root of a binary tree, return the length of the diameter of the tree.

//The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

//The length of a path between two nodes is represented by the number of edges between them.