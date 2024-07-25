class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        // Nodo ficticio para facilitar la manipulación de la cabeza de la lista
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Nodo previo para llevar la referencia al nodo previo en cada iteración
        ListNode prev = dummy;
        
        // Iterar a través de la lista enlazada
        while (head != null && head.next != null) {
            // Identificar los dos nodos a intercambiar
            ListNode first = head;
            ListNode second = head.next;
            
            // Realizar el intercambio de los nodos
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // Mover los punteros para el siguiente par
            prev = first;
            head = first.next;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();
        
        // Crear la lista enlazada: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        // Intercambiar nodos
        ListNode result = solution.swapPairs(head);
        
        // Imprimir el resultado
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
        // Salida esperada: 2 -> 1 -> 4 -> 3
    }
}


//Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying 
//the values in the list's nodes (i.e., only nodes themselves may be changed.)