class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize the previous node to null
        ListNode current = head; // Start with the head of the list
 
        // Iterate through the list
        while (current != null) {
            ListNode next = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move the previous node to the current node
            current = next; // Move the current node to the next node
        }

        return prev; // Return the new head of the reversed list
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse the linked list
        ListNode reversedHead = solution.reverseList(head);

        // Print the reversed linked list
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}


//Given the head of a singly linked list, reverse the list, and return the reversed list.